package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CheckPasswordRequest;
import com.example.demo.DTO.UpdatePasswordRequest;
import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.model.LoginMessage;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController  {

	@Autowired
	EmployeeService employeeService;

	public RegistrationController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/register")
	public String saveRegistrationData(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PostMapping("/loginUser")
	public LoginMessage loginUser(@RequestBody Login login) {
		return employeeService.loginUser(login);
	}
	@PostMapping("/verify_email")
	public String verifyEmployeeEmail(@RequestBody String empEmail) {
		return employeeService.verifyEmail(empEmail);
	}
	
	@PostMapping("/check_security_answer")
	public boolean checkSecurityAnswer(@RequestBody CheckPasswordRequest checkPasswordRequest ) {
		return employeeService.checkSecurityAnswer(checkPasswordRequest);
	}
	
	@PostMapping("/update_password")
	public String updateResetPassword(@RequestBody UpdatePasswordRequest upPasswordRequest) {
		return employeeService.updatePassword(upPasswordRequest);
	}
}
