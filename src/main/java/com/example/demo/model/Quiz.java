package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.DTO.QuestionRequest;

import lombok.Data;

@Data
@Document(collection = "Quiz")
public class Quiz {
	private String topic;
	private List<QuestionRequest> questions;
	private int totalScore;
	private String difficultyLevel;
	private String qDescription;
	private boolean qActive;

	public Quiz() {
		super();
	}

	public Quiz(String topic, List<QuestionRequest> questions, int totalScore, String difficultyLevel,
			String qDescription, boolean qActive) {
		super();
		this.topic = topic;
		this.questions = questions;
		this.totalScore = totalScore;
		this.difficultyLevel = difficultyLevel;
		this.qDescription = qDescription;
		this.qActive = qActive;
	}

	public String getqDescription() {
		return qDescription;
	}

	public void setqDescription(String qDescription) {
		this.qDescription = qDescription;
	}

	public boolean isqActive() {
		return qActive;
	}

	public void setqActive(boolean qActive) {
		this.qActive = qActive;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<QuestionRequest> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionRequest> questions) {
		this.questions = questions;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	@Override
	public String toString() {
		return "Quiz [topic=" + topic + ", questions=" + questions + ", totalScore=" + totalScore + ", difficultyLevel="
				+ difficultyLevel + "]";
	}

}
