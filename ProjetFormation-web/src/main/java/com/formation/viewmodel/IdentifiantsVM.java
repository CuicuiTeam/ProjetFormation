package com.formation.viewmodel;

public class IdentifiantsVM {
	private String email;
	private String password;

	public IdentifiantsVM() {
	}

	public IdentifiantsVM(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



}
