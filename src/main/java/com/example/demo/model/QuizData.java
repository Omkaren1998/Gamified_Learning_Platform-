package com.example.demo.model;

public class QuizData {

	private boolean qattempted;
	private String date;
	private String quizzTopic;
	 private int qcorrect;
	private int qscore;
	private int qpoint;
	private boolean qusedHint;
	private int qtimetaken;

	public QuizData() {

	}

	public QuizData(boolean qattempted, String date, String quizzTopic, int qcorrect, int qscore, int qpoint,
			boolean qusedHint, int qtimetaken) {
		super();
		this.qattempted = qattempted;
		this.date = date;
		this.quizzTopic = quizzTopic;
		this.qcorrect = qcorrect;
		this.qscore = qscore;
		this.qpoint = qpoint;
		this.qusedHint = qusedHint;
		this.qtimetaken = qtimetaken;
	}

	public boolean isQattempted() {
		return qattempted;
	}

	public void setQattempted(boolean qattempted) {
		this.qattempted = qattempted;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQuizzTopic() {
		return quizzTopic;
	}

	public void setQuizzTopic(String quizzTopic) {
		this.quizzTopic = quizzTopic;
	}

	
	public int getQcorrect() {
		return qcorrect;
	}

	public void setQcorrect(int qcorrect) {
		this.qcorrect = qcorrect;
	}

	public int getQscore() {
		return qscore;
	}

	public void setQscore(int qscore) {
		this.qscore = qscore;
	}

	public int getQpoint() {
		return qpoint;
	}

	public void setQpoint(int qpoint) {
		this.qpoint = qpoint;
	}

	public boolean isQusedHint() {
		return qusedHint;
	}

	public void setQusedHint(boolean qusedHint) {
		this.qusedHint = qusedHint;
	}

	public int getQtimetaken() {
		return qtimetaken;
	}

	public void setQtimetaken(int qtimetaken) {
		this.qtimetaken = qtimetaken;
	}

	@Override
	public String toString() {
		return "QuizData [qattempted=" + qattempted + ", date=" + date + ", quizzTopic=" + quizzTopic + ", qcorrect="
				+ qcorrect + ", qscore=" + qscore + ", qpoint=" + qpoint + ", qusedHint=" + qusedHint + ", qtimetaken="
				+ qtimetaken + "]";
	}

}
