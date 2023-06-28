package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.QuizData;

public class EmployeeQuizzDataDTO {

	private int empId;
    private String dept;
    private QuizData quizzData;
    
	public EmployeeQuizzDataDTO() {
		
	}
	public EmployeeQuizzDataDTO(int empId, String dept, QuizData quizzData 
			) {
		super();
		this.empId = empId;
		this.dept = dept;
		this.quizzData = quizzData;
//		this.totalScore = totalScore;
//		this.totalPoints = totalPoints;
//		this.totalQuizzes = totalQuizzes;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public QuizData getQuizzData() {
		return quizzData;
	}
	public void setQuizzData(QuizData quizzData) {
		this.quizzData = quizzData;
	}
//	public int getTotalScore() {
//		return totalScore;
//	}
//	public void setTotalScore(int totalScore) {
//		this.totalScore = totalScore;
//	}
//	public int getTotalPoints() {
//		return totalPoints;
//	}
//	public void setTotalPoints(int totalPoints) {
//		this.totalPoints = totalPoints;
//	}
//	public int getTotalQuizzes() {
//		return totalQuizzes;
//	}
//	public void setTotalQuizzes(int totalQuizzes) {
//		this.totalQuizzes = totalQuizzes;
//	}
//	@Override
//	public String toString() {
//		return "EmployeeQuizzDataDTO [empId=" + empId + ", dept=" + dept + ", quizzData=" + quizzData + ", totalScore="
//				+ totalScore + ", totalPoints=" + totalPoints + ", totalQuizzes=" + totalQuizzes + "]";
//	}
	@Override
	public String toString() {
		return "EmployeeQuizzDataDTO [empId=" + empId + ", dept=" + dept + ", quizzData=" + quizzData + "]";
	}

	
}
