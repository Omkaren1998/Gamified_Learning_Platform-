package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questionOptions")
public class QuestionOption {
	
	
    private String option;
    private int priority;
    private String oImage;
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getoImage() {
		return oImage;
	}
	public void setoImage(String imagePath) {
		this.oImage = imagePath;
	}
	@Override
	public String toString() {
		return "QuestionOption [option=" + option + ", priority=" + priority + ", oImage=" + oImage + "]";
	}
	public QuestionOption(String option, int priority, String oImage) {
		super();
		this.option = option;
		this.priority = priority;
		this.oImage = oImage;
	}
	public QuestionOption() {
		super();
		// TODO Auto-generated constructor stub
	}

}
