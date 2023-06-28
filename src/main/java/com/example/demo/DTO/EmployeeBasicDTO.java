package com.example.demo.DTO;

public class EmployeeBasicDTO {
	
	private int empId;
	private String empName;
	private String empEmail;
	private String empDoj;
	private String jobrole;
	private String dept;
	private String empImage;
	private int totalScore;
    private int totalPoints;
    private int totalQuizzes;

	public EmployeeBasicDTO() {
		
	}

	

	public String getEmpImage() {
		return empImage;
	}



	public void setEmpImage(String empImage) {
		this.empImage = empImage;
	}



	public EmployeeBasicDTO(int empId, String empName, String empEmail, String empDoj, String jobrole, String dept,
			String empImage, int totalScore, int totalPoints, int totalQuizzes) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empDoj = empDoj;
		this.jobrole = jobrole;
		this.dept = dept;
		this.empImage = empImage;
		this.totalScore = totalScore;
		this.totalPoints = totalPoints;
		this.totalQuizzes = totalQuizzes;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
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

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getTotalQuizzes() {
		return totalQuizzes;
	}

	public void setTotalQuizzes(int totalQuizzes) {
		this.totalQuizzes = totalQuizzes;
	}

	@Override
	public String toString() {
		return "EmployeeBasicDTO [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empDoj="
				+ empDoj + ", jobrole=" + jobrole + ", dept=" + dept + ", totalScore=" + totalScore + ", totalPoints="
				+ totalPoints + ", totalQuizzes=" + totalQuizzes + "]";
	}
	

}
