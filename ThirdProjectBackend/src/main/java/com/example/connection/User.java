package com.example.connection;

public class User {

	private String id; // _id로 지정
	private String password;
	
	public User() {}
	
	public User(String userId, String password) {
		this.id = userId;
		this.password = password;
	}
	public String getid() {
		return id;
	}
	public String getpassword() {
		return password;
	}

	public String toString() {
		return String.format("User[userId:%s, password: %s]", id, password);
	}

}