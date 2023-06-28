package com.example.demo.Service;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CheckPasswordRequest;
import com.example.demo.DTO.EmployeeTopScorerDataDTO;
import com.example.demo.DTO.EmployeeTopScorerDataDepartmentDTO;
import com.example.demo.DTO.UpdatePasswordRequest;
import com.example.demo.Repository.EmployeeQuizzDataRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.common.EmployeeConstant;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDetails;
import com.example.demo.model.EmployeeQuizzData;
import com.example.demo.model.Login;
import com.example.demo.model.LoginMessage;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class EmployeeService implements UserDetailsService {

	@Autowired
	EmployeeRepository registrationRepository;

	@Autowired
	EmployeeQuizzDataRepository employeeQuizzDataRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	public EmployeeService(EmployeeRepository registrationRepository) {
		super();

		this.registrationRepository = registrationRepository;
	}

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return registrationRepository.findByEmpId(empId);
	}

	public String saveRegistrationData(Employee employee) {
		log.info("Received registrationPage object: {}", employee.toString());
		registrationRepository.save(employee);
		return "Registered Successfully";
	}

	public String addEmployee(Employee employee) {
		boolean employeeExists = registrationRepository.findByEmpIdOrEmpEmail(employee.getEmpId(),
				employee.getEmpEmail()) != null;
		if (employeeExists) {
			if (registrationRepository.findByEmpId(employee.getEmpId()) != null) {
				throw new IllegalArgumentException("Employee with empId " + employee.getEmpId() + " already exists");
			} else {
				throw new IllegalArgumentException(
						"Employee with empEmail " + employee.getEmpEmail() + " already exists");
			}
		}

		String mail = employee.getEmpEmail();
		employee.setRole(
				mail.equalsIgnoreCase("amrita.c@prodapt.com") || mail.equalsIgnoreCase("gowtham.ga@prodapt.com")
				|| mail.equalsIgnoreCase("sudha.d@prodapt.com") ? EmployeeConstant.ADMIN_ACCESS
						: EmployeeConstant.DEFAULT_ROLE);

		try {
			employee.setPassword(this.passwordEncoder.encode(employee.getPassword()));
			registrationRepository.save(employee);
			return "Employee registered successfully";
		} catch (Exception e) {
			throw new IllegalStateException("Failed to register employee: " + e.getMessage());
		}
	}

	public List<EmployeeTopScorerDataDepartmentDTO> getTopScorersByDepartment(String department, int limit) {
		PageRequest pageRequest = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "totalScore"));
		List<EmployeeQuizzData> topScorers = employeeQuizzDataRepository.findByDept(department, pageRequest);

		return topScorers.stream().map(employee -> {
			EmployeeTopScorerDataDepartmentDTO employeeData = new EmployeeTopScorerDataDepartmentDTO();
			Employee emp = registrationRepository.findByEmpId(employee.getEmpid());
			if (emp != null) {
				employeeData.setEmployeeName(emp.getEmpName());
				employeeData.setEmployeeId(employee.getEmpid());
				employeeData.setScore(employee.getTotalScore());
				employeeData.setJobrole(emp.getJobrole());
				employeeData.setDept(emp.getDept());
				employeeData.setEmpImage(emp.getEmpImage());
			}
			return employeeData;
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	public List<EmployeeTopScorerDataDTO> getTopScorer(int limit) {
		PageRequest pageRequest = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "totalScore"));
		List<EmployeeQuizzData> topScorers = employeeQuizzDataRepository.findAll(pageRequest).getContent();

		return topScorers.stream().map(employee -> {
			EmployeeTopScorerDataDTO employeeData = new EmployeeTopScorerDataDTO();
			Employee emp = registrationRepository.findByEmpId(employee.getEmpid());
			if (emp != null) {
				employeeData.setEmployeeName(emp.getEmpName());
				employeeData.setEmployeeId(employee.getEmpid());
				employeeData.setScore(employee.getTotalScore());
				employeeData.setJobrole(emp.getJobrole());
				employeeData.setDept(emp.getDept());
				employeeData.setEmpImage(emp.getEmpImage());
			}
			return employeeData;
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	public LoginMessage loginUser(Login login) {
		log.info("Login Request EmpEmail: {}", login.getEmpEmail());
		Employee user = registrationRepository.findByEmpEmail(login.getEmpEmail());

		return Optional.ofNullable(user).filter(u -> passwordEncoder.matches(login.getPassword(), u.getPassword()))
				.map(u -> {
					String token = jwtTokenProvider.generateToken(u);
					log.info("Token: {}", token);
					return new LoginMessage("Login Success", true, u.getEmpId(), u.getRole(), token);
				}).orElseGet(() -> {
					if (user != null) {
						return new LoginMessage("Incorrect Password", false, user.getEmpId(), user.getRole());
					} else {
						return new LoginMessage("Email does not exist", false);
					}
				});
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee = registrationRepository.findByEmpEmail(email);
		if (employee == null) {
			throw new UsernameNotFoundException("Employee not found");
		}
		return new EmployeeDetails(employee);
	}
	public String verifyEmail(String empEmail) {
		log.info("Verification Request EmpEmail: {}", empEmail);
		Optional<Employee> optionalEmp = Optional.ofNullable(registrationRepository.findByEmpEmail(empEmail));

		return optionalEmp
				.map(emp -> emp.getEmpEmail().equalsIgnoreCase(empEmail) ? emp.getSecurityQtn() : "Email doesn't exist")
				.orElse("Email doesn't exist");
	}

	public boolean checkSecurityAnswer(CheckPasswordRequest chPasswordRequest) {
	    Employee emp = registrationRepository.findByEmpEmail(chPasswordRequest.getEmpEmail());
	    return Optional.ofNullable(emp)
	        .filter(e -> chPasswordRequest.getSecurityAns().equalsIgnoreCase(e.getSecurityAns()))
	        .isPresent();
	}


	public String updatePassword(UpdatePasswordRequest updatePasswordRequest) {
		log.info("Verification Request updatePassword req: {}", updatePasswordRequest);
		Employee existingEmployee = registrationRepository.findByEmpEmail(updatePasswordRequest.getEmpEmail());

		if (existingEmployee != null) {
			existingEmployee.setPassword(this.passwordEncoder.encode(updatePasswordRequest.getPassword()));
			Employee emp = registrationRepository.save(existingEmployee);

			if (emp != null) {
				registrationRepository.deleteByEmpId(existingEmployee.getEmpId());
				return "Password Updated Successfully";
			}
		}
		return "Error while Updating password";
	}
}
