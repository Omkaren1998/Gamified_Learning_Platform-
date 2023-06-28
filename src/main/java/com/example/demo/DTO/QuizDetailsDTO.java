package com.example.demo.DTO;

public class QuizDetailsDTO {
	private String topic;
	private String qDescription;
	private boolean qActive;

	public QuizDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizDetailsDTO(String topic, String qDescription, boolean qActive) {
		super();
		this.topic = topic;
		this.qDescription = qDescription;
		this.qActive = qActive;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

	@Override
	public String toString() {
		return "QuizDetailsDTO [topic=" + topic + ", qDescription=" + qDescription + ", qActive=" + qActive + "]";
	}

}
