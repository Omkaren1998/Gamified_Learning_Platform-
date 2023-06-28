package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
public class Question {
	@Id
    private String id;
    private String qName;
    private List<QuestionOption> qOptions;
    private String correctAns;
    private String qImage;
//    private String topic;
    private String difficultyLevel;

    


	@Override
	public String toString() {
		return "Question [id=" + id + ", qName=" + qName + ", qOptions=" + qOptions + ", correctAns=" + correctAns
				+ ", qImage=" + qImage + ", difficultyLevel=" + difficultyLevel + "]";
	}


	public Question() {
        this.qOptions = new ArrayList<QuestionOption>();
    }

    
//	public String getTopic() {
//		return topic;
//	}
//
//
//	public void setTopic(String topic) {
//		this.topic = topic;
//	}


	public String getDifficultyLevel() {
		return difficultyLevel;
	}


	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}


	public Question(String id, String qName, List<QuestionOption> qOptions, String correctAns, String qImage,
			String topic) {
		super();
		this.id = id;
		this.qName = qName;
		this.qOptions = qOptions;
		this.correctAns = correctAns;
		this.qImage = qImage;
//		this.topic = topic;
		this.difficultyLevel = difficultyLevel;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
