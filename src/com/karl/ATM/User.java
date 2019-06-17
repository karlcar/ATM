package com.karl.ATM;

public class User {
	private String username; //�˻�
	private String password; //����
	private String name;     //������
	private double balance;  //���
	
	public User(String username, String password, String name, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
