package com.example.demo.DTO;

public class EmployeeTopScorerDataDepartmentDTO {

	private String employeeName;
	private int employeeId;
	private int score;
	private String jobrole;
	private String dept;
	private String empImage;

	public EmployeeTopScorerDataDepartmentDTO(String employeeName, int employeeId, int score, String jobrole,
			String dept, String empImage) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.score = score;
		this.jobrole = jobrole;
		this.dept = dept;
		this.empImage = empImage;
	}

	public EmployeeTopScorerDataDepartmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getJobrole() {
		return jobrole;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmpImage() {
		return empImage;
	}

	public void setEmpImage(String empImage) {
		this.empImage = empImage;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "EmployeeTopScorerDataDepartmentDTO [employeeName=" + employeeName + ", employeeId=" + employeeId
				+ ", score=" + score + "]";
	}

}
