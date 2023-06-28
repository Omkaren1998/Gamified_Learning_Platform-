package com.example.demo.DTO;

public class CheckPasswordRequest {
	private String empEmail;
	private String securityAns;
	public String getEmpEmail() {
		return empEmail;
	}
	public CheckPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckPasswordRequest(String empEmail, String securityAns) {
		super();
		this.empEmail = empEmail;
		this.securityAns = securityAns;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getSecurityAns() {
		return securityAns;
	}
	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}
}
