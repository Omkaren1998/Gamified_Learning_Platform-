package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.QuizData;

public class EmployeeAnalyticsDTO {
	private List<QuizData> quizzDataList; 
	private int totalScore;
    private int totalPoints;
    private int totalQuizzes;

	public EmployeeAnalyticsDTO() {
		
	}

	

	public EmployeeAnalyticsDTO(int totalQuizzes, int totalScore, int totalPoints, List<QuizData> quizzDataList) {
		super();
		this.quizzDataList = quizzDataList;
		this.totalScore = totalScore;
		this.totalPoints = totalPoints;
		this.totalQuizzes = totalQuizzes;
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
		return "EmployeeAnalyticsDTO [totalScore=" + totalScore + ", totalPoints=" + totalPoints + ", totalQuizzes="
				+ totalQuizzes + "]";
	}

}
