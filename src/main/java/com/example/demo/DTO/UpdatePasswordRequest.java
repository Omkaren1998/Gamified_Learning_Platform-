package com.example.demo.DTO;

public class UpdatePasswordRequest {
	private String empEmail;
    private String password;
	public UpdatePasswordRequest(String empEmail, String password) {
		super();
		this.setEmpEmail(empEmail);
		this.setPassword(password);
	}
	public UpdatePasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
