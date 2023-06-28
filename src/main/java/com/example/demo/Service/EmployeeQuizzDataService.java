package com.example.demo.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EmployeeQuizzDataDTO;
import com.example.demo.Exception.EmployeeNotFoundException;
import com.example.demo.Repository.EmployeeQuizzDataRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.EmployeeQuizzData;
import com.example.demo.model.QuizData;

@Service
public class EmployeeQuizzDataService {

	@Autowired
	EmployeeQuizzDataRepository emplQuizzDataRepository;

	@Autowired
	EmployeeRepository empRepository;

	private final Logger log = LoggerFactory.getLogger(getClass());

	public String updateEmployeeQuizzData(EmployeeQuizzDataDTO empquizzData) {
		log.info("Received EmpQuizz data is : " + empquizzData);
		EmployeeQuizzData employee;
		employee = emplQuizzDataRepository.findByEmpId(empquizzData.getEmpId());
		log.info("DB Emp data is : " + employee);
		if (employee == null) {
			employee = new EmployeeQuizzData();
			employee.setEmpid(empquizzData.getEmpId());
			employee.setDept(empquizzData.getDept());
			employee.setQuizzDataList(Collections.singletonList(empquizzData.getQuizzData()));
			employee.setTotalScore(empquizzData.getQuizzData().getQscore());
			employee.setTotalPoints(empquizzData.getQuizzData().getQpoint());
			employee.setTotalQuizzes(1);
		} else {
			List<QuizData> existingQuizzData = employee.getQuizzDataList();
			existingQuizzData.add(empquizzData.getQuizzData());
			employee.setQuizzDataList(existingQuizzData);
			employee.setTotalScore(employee.getTotalScore() + empquizzData.getQuizzData().getQscore());
			employee.setTotalPoints(employee.getTotalPoints() + empquizzData.getQuizzData().getQpoint());
			employee.setTotalQuizzes(existingQuizzData.size());
		}
		EmployeeQuizzData emp = employee;
		if (employee != null) {
			emplQuizzDataRepository.deleteByEmpId(employee.getEmpid());
		}
		emplQuizzDataRepository.save(emp);
		return "Employee Quizz Data is Added successfully";
	}

	public List<EmployeeQuizzData> getEmployeeQuizzDataByDepartment(String departmentName) {
		return Optional.ofNullable(emplQuizzDataRepository.findByDept(departmentName)).filter(list -> !list.isEmpty())
				.orElseThrow(
						() -> new EmployeeNotFoundException("No employees found for department: " + departmentName));
	}

}
