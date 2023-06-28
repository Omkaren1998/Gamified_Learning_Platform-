package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeQuizzData;

public class LandingPage {

	private EmployeeBasicDTO employeeBasicDTO;
	private List<QuizDetailsDTO> quizBasicDetails;
	private EmployeeAnalyticsDTO employeeAnalyticsDTO;
	private List<EmployeeTopScorerDataDepartmentDTO> topScorersOfDept;
	private List<EmployeeTopScorerDataDTO> topScorersOfAllEmp;

	public LandingPage() {

	}

	public LandingPage(EmployeeBasicDTO employeeBasicDTO, List<QuizDetailsDTO> quizBasicDetails,
			EmployeeAnalyticsDTO employeeAnalyticsDTO, List<EmployeeTopScorerDataDepartmentDTO> topScorersOfDept,
			List<EmployeeTopScorerDataDTO> topScorersOfAllEmp) {
		super();
		this.employeeBasicDTO = employeeBasicDTO;
		this.quizBasicDetails = quizBasicDetails;
		this.employeeAnalyticsDTO = employeeAnalyticsDTO;
		this.topScorersOfDept = topScorersOfDept;
		this.topScorersOfAllEmp = topScorersOfAllEmp;
	}

	public EmployeeBasicDTO getEmployeeBasicDTO() {
		return employeeBasicDTO;
	}

	public void setEmployeeBasicDTO(EmployeeBasicDTO employeeBasicDTO) {
		this.employeeBasicDTO = employeeBasicDTO;
	}

	public List<QuizDetailsDTO> getQuizBasicDetails() {
		return quizBasicDetails;
	}

	public void setQuizBasicDetails(List<QuizDetailsDTO> quizBasicDetails) {
		this.quizBasicDetails = quizBasicDetails;
	}

	public EmployeeAnalyticsDTO getEmployeeAnalyticsDTO() {
		return employeeAnalyticsDTO;
	}

	public void setEmployeeAnalyticsDTO(EmployeeAnalyticsDTO employeeAnalyticsDTO) {
		this.employeeAnalyticsDTO = employeeAnalyticsDTO;
	}

	public List<EmployeeTopScorerDataDepartmentDTO> getTopScorersOfDept() {
		return topScorersOfDept;
	}

	public void setTopScorersOfDept(List<EmployeeTopScorerDataDepartmentDTO> topScorersOfDept2) {
		this.topScorersOfDept = topScorersOfDept2;
	}

	public List<EmployeeTopScorerDataDTO> getTopScorersOfAllEmp() {
		return topScorersOfAllEmp;
	}

	public void setTopScorersOfAllEmp(List<EmployeeTopScorerDataDTO> topScorersOfAllEmp2) {
		this.topScorersOfAllEmp = topScorersOfAllEmp2;
	}

	@Override
	public String toString() {
		return "LandingPage [employeeBasicDTO=" + employeeBasicDTO + ", quizBasicDetails=" + quizBasicDetails
				+ ", employeeAnalyticsDTO=" + employeeAnalyticsDTO + ", topScorersOfDept=" + topScorersOfDept
				+ ", topScorersOfAllEmp=" + topScorersOfAllEmp + "]";
	}

	

}
