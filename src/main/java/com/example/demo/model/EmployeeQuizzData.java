package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "EmployeeQuizzData")
public class EmployeeQuizzData {
	
	private int empId;
    private String dept;
    private List<QuizData> quizzDataList;
    private int totalScore;
    private int totalPoints;
    private int totalQuizzes;

	public EmployeeQuizzData() {
	}

	public EmployeeQuizzData(int  empid, String dept, List<QuizData> quizzDataList, int totalScore, int totalPoints,
			int totalQuizzes) {
		super();
		this.empId = empid;
		this.dept = dept;
		this.quizzDataList = quizzDataList;
		this.totalScore = totalScore;
		this.totalPoints = totalPoints;
		this.totalQuizzes = totalQuizzes;
	}

	public int getEmpid() {
		return empId;
	}

	public void setEmpid(int empid) {
		this.empId = empid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<QuizData> getQuizzDataList() {
		return quizzDataList;
	}

	public void setQuizzDataList(List<QuizData> quizzDataList) {
		this.quizzDataList = quizzDataList;
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
		return "EmployeeQuizzData [empid=" + empId + ", dept=" + dept + ", quizzDataList=" + quizzDataList
				+ ", totalScore=" + totalScore + ", totalPoints=" + totalPoints + ", totalQuizzes=" + totalQuizzes
				+ "]";
	}
	

}
