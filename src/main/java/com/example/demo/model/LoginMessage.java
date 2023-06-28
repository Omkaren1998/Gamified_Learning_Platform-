package com.example.demo.model;

public class LoginMessage {
	String message;
    Boolean status;
    int empId;
	private String role;
	private String token;
	  public LoginMessage() {
		super();
	}
	public LoginMessage(String message, Boolean status, int empId,String role,String token) {
		super();
		this.message = message;
		this.status = status;
		this.empId = empId;
		this.role=role;
		this.token=token;
	}
		public LoginMessage(String string, boolean b, int empId2, String role2) {
		this.message=string;
		this.status=b;
		this.empId=empId2;
		this.role=role2;
		
	}
		public LoginMessage(String string, boolean b) {
			this.message=string;
			this.status=b;
		}
		public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
}
