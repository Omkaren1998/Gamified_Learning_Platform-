package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "Employee")
public class Employee {

	
	private int empId;
	private String empName;
	private String empEmail;
	private String empDoj;
	private String jobrole;
	private String dept;
	private String exp;
	private List<String> interestedTech;
	private String password;
	private Boolean participateQuiz;
	private String topics;
	private String role;
	private String empImage;
	private String securityQtn;
	private String securityAns;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String empEmail, String empDoj, String jobrole, String dept, String exp,
			List<String> interestedTech, String password, Boolean participateQuiz, String topics, String role,
			String empImage, String securityQtn, String securityAns) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empDoj = empDoj;
		this.jobrole = jobrole;
		this.dept = dept;
		this.exp = exp;
		this.interestedTech = interestedTech;
		this.password = password;
		this.participateQuiz = participateQuiz;
		this.topics = topics;
		this.role = role;
		this.empImage = empImage;
		this.securityQtn = securityQtn;
		this.securityAns = securityAns;
	}

	public String getJobrole() {
		return jobrole;
	}

	
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}


	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empEmail
	 */
	public String getEmpEmail() {
		return empEmail;
	}

	/**
	 * @param empEmail the empEmail to set
	 */
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	/**
	 * @return the empDoj
	 */
	public String getEmpDoj() {
		return empDoj;
	}

	/**
	 * @param empDoj the empDoj to set
	 */
	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
	}

	
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * @return the exp
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * @return the interestedTech
	 */
	public List<String> getInterestedTech() {
		return interestedTech;
	}

	/**
	 * @param interestedTech the interestedTech to set
	 */
	public void setInterestedTech(List<String> interestedTech) {
		this.interestedTech = interestedTech;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the participateQuiz
	 */
	public Boolean getParticipateQuiz() {
		return participateQuiz;
	}

	/**
	 * @param participateQuiz the participateQuiz to set
	 */
	public void setParticipateQuiz(Boolean participateQuiz) {
		this.participateQuiz = participateQuiz;
	}

	/**
	 * @return the topics
	 */
	public String getTopics() {
		return topics;
	}

	/**
	 * @param topics the topics to set
	 */
	public void setTopics(String topics) {
		this.topics = topics;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmpImage() {
		return empImage;
	}

	public void setEmpImage(String empImage) {
		this.empImage = empImage;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empDoj=" + empDoj
				+ ", jobrole=" + jobrole + ", dept=" + dept + ", exp=" + exp + ", interestedTech=" + interestedTech
				+ ", password=" + password + ", participateQuiz=" + participateQuiz + ", topics=" + topics + ", role="
				+ role + ", empImage=" + empImage + ", securityQtn=" + securityQtn + ", securityAns=" + securityAns
				+ "]";
	}

	public String getSecurityQtn() {
		return securityQtn;
	}

	public void setSecurityQtn(String securityQtn) {
		this.securityQtn = securityQtn;
	}

	public String getSecurityAns() {
		return securityAns;
	}

	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}

}
