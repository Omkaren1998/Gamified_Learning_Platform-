package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeQuizzDataDTO;
import com.example.demo.Service.EmployeeQuizzDataService;
import com.example.demo.model.EmployeeQuizzData;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class EmployeeQuizzDataController {

	@Autowired
	EmployeeQuizzDataService empQuizzDataService;

	public EmployeeQuizzDataController(EmployeeQuizzDataService empQuizzDataService) {
		this.empQuizzDataService = empQuizzDataService;
	}

	@PostMapping("/addempquizzdata")
	public String saveEmployeeQuizzData(@RequestBody EmployeeQuizzDataDTO empData) {
		return empQuizzDataService.updateEmployeeQuizzData(empData);
	}

	@GetMapping("/getempquizzdatabydept/{deptName}")
	public List<EmployeeQuizzData> getEmpQuizzDataByDept(@PathVariable("deptName") String deptName) {
		return empQuizzDataService.getEmployeeQuizzDataByDepartment(deptName);
	}

}
