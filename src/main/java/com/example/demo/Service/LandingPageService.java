package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EmployeeAnalyticsDTO;
import com.example.demo.DTO.EmployeeBasicDTO;
import com.example.demo.DTO.EmployeeTopScorerDataDTO;
import com.example.demo.DTO.EmployeeTopScorerDataDepartmentDTO;
import com.example.demo.DTO.LandingPage;
import com.example.demo.DTO.QuizDetailsDTO;
import com.example.demo.Exception.EmployeeNotFoundException;
import com.example.demo.Exception.LandingPageNotFoundException;
import com.example.demo.Repository.EmployeeQuizzDataRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.QuizRepository;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeQuizzData;

@Service
public class LandingPageService {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	EmployeeRepository emplRepository;
	@Autowired
	EmployeeQuizzDataRepository empQuizzDataRepository;
	@Autowired
	EmployeeRepository registrationRepository;
	@Autowired
	QuizService quizService;
	@Autowired
	EmployeeService employeeService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	public LandingPage getLandingPageObject(Employee emp) {
		log.info("Constructing LandingPage object for employee: {}", emp);
		EmployeeBasicDTO employeeBasicDTO = new EmployeeBasicDTO();
		LandingPage landingPage = new LandingPage();

		EmployeeQuizzData empQuizzData = empQuizzDataRepository.findByEmpId(emp.getEmpId());

		employeeBasicDTO.setEmpId(emp.getEmpId());
		employeeBasicDTO.setEmpName(emp.getEmpName());
		employeeBasicDTO.setEmpEmail(emp.getEmpEmail());
		employeeBasicDTO.setDept(emp.getDept());
		employeeBasicDTO.setJobrole(emp.getJobrole());
		employeeBasicDTO.setEmpDoj(emp.getEmpDoj());
		employeeBasicDTO.setEmpImage(emp.getEmpImage());
		employeeBasicDTO
		.setTotalPoints(Optional.ofNullable(empQuizzData).map(EmployeeQuizzData::getTotalPoints).orElse(0));
		employeeBasicDTO
		.setTotalScore(Optional.ofNullable(empQuizzData).map(EmployeeQuizzData::getTotalScore).orElse(0));
		employeeBasicDTO
		.setTotalQuizzes(Optional.ofNullable(empQuizzData).map(EmployeeQuizzData::getTotalQuizzes).orElse(0));

		landingPage.setEmployeeBasicDTO(employeeBasicDTO);
		List<QuizDetailsDTO> quizzBasicDetails = quizService.getAllQuizTopics();
		log.info("List of quizzBasicDetails: {}", quizzBasicDetails);
		landingPage.setQuizBasicDetails(quizzBasicDetails);

		EmployeeAnalyticsDTO emAnalyticsDTO = Optional.ofNullable(empQuizzData)
				.map(e -> new EmployeeAnalyticsDTO(e.getTotalScore(), e.getTotalPoints(), e.getTotalQuizzes(),
						e.getQuizzDataList()))
				.orElse(null);
		landingPage.setEmployeeAnalyticsDTO(emAnalyticsDTO);

		List<EmployeeTopScorerDataDepartmentDTO> topScorersOfDept = employeeService
				.getTopScorersByDepartment(emp.getDept(), 10);
		landingPage.setTopScorersOfDept(topScorersOfDept);

		List<EmployeeTopScorerDataDTO> topScorersOfAllEmp = employeeService.getTopScorer(10);
		landingPage.setTopScorersOfAllEmp(topScorersOfAllEmp);

		log.info("Landing Page object is: {}", landingPage);
		return landingPage;
	}

	public LandingPage getLandingPagebyempIdOrEmail(String empIdOrEmail) {

		Employee emp = null;
		if (isNumeric(empIdOrEmail)) {
			int empId = Integer.parseInt(empIdOrEmail);
			log.info("Getting LandingPage object for employee ID: {}", empId);
			emp = registrationRepository.findByEmpId(empId);
		} else {
			log.info("Getting LandingPage object for employee Email: {}", empIdOrEmail);
			emp = registrationRepository.findByEmpEmail(empIdOrEmail);
		}
		if (emp == null) {
			throw new EmployeeNotFoundException("Employee not found with empId or empEmail: " + empIdOrEmail);
		}
		return getLandingPageObject(emp);
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+");
	}
}
