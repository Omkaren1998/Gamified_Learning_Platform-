package com.example.demo.model;

public class Login {
	private String empEmail;
	private String password;
//	private int empId;
	 
	public Login() {
	}
	 
	

	public Login(String empEmail, String password) {
		super();
		this.empEmail = empEmail;
		this.password = password;
//		this.empId = empId;
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

	

	@Override
	public String toString() {
		return "Login [empEmail=" + empEmail + ", password=" + password +  "]";
	}



//	public int getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(int empId) {
//		this.empId = empId;
//	} 
}
