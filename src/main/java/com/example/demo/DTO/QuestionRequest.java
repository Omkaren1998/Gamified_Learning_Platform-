package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.QuestionOption;

public class QuestionRequest {
	private int qId;
	private String qName;
	private List<QuestionOption> qOptions;
	private String correctAns;
	private String qImage;
//	private String topic;
	private String difficultyLevel;


	public QuestionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "QuestionRequest [qId=" + qId + ", qName=" + qName + ", qOptions=" + qOptions + ", correctAns="
				+ correctAns + ", qImage=" + qImage + ", difficultyLevel=" + difficultyLevel + "]";
	}

	public QuestionRequest(int qId, String qName, List<QuestionOption> qOptions, String correctAns, String qImage,
			String difficultyLevel) {
		super();
		this.qId = qId;
		this.qName = qName;
		this.qOptions = qOptions;
		this.correctAns = correctAns;
		this.qImage = qImage;
//		this.topic = topic;
		this.difficultyLevel = difficultyLevel;
	}
//	public String getTopic() {
//		return topic;
//	}
//	public void setTopic(String topic) {
//		this.topic = topic;
//	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public Integer getqId() {
		return qId;
	}
	public void setqId(Integer qId) {
		this.qId = qId;
	}
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	public List<QuestionOption> getqOptions() {
		return qOptions;
	}
	public void setqOptions(List<QuestionOption> qOptions) {
		this.qOptions = qOptions;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	public String getqImage() {
		return qImage;
	}
	public void setqImage(String qImage) {
		this.qImage = qImage;
	}


}
