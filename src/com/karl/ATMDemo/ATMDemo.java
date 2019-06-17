package com.karl.ATMDemo;

import java.util.Scanner;

import com.karl.ATM.Helper;

public class ATMDemo {
	
	//由于登录账号是唯一的，所以直接创建一个User
	UserDemo user;
	
	public void login() {
		System.out.println("请输入账号:");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		if(! BankDemo.CheckUsersIsExist(username)) {
			login();
		}
		System.out.println("请输入密码:");
		String password = s.nextLine();
		if(! BankDemo.CheckUsersPassword(username, password)) {
			System.out.println("输入的账号密码有误!");
			login();	
		}
		
		user = BankDemo.getUser(username, password);
		System.out.println("恭喜：" + user.getUsername() + "登录成功");
		showMainUI();
}
	public void modifyPassword() {
		System.out.println("请输入原来的密码：");
		Scanner s = new Scanner(System.in);
		String password = s.nextLine();
		if(! user.getPassword().equalsIgnoreCase(password)) {
			modifyPassword();
		}
		System.out.println("请输入新的密码：");
		String newPassword = s.nextLine();
		if(! BankDemo.modifyPassword(user, newPassword)) {
			modifyPassword();
		}
		System.out.println("修改成功");
		showMainUI();
	}
	
	public void transfer() {
		System.out.println("请输入对方账号：");
		Scanner s = new Scanner(System.in);
		String destAccount = s.nextLine();
		if(! BankDemo.CheckUsersIsExist(destAccount)) {
			System.out.println("该对方账号不存在，请重新输入：");
			transfer();
		}
		System.out.println("请输入转账金额：");
		String Input = s.nextLine();
		double destMoneyInput =  Double.parseDouble(Input);
		if(user.getBalance() < destMoneyInput) {
			System.out.println("您的余额不足，请重新输入！！");
			transfer();
		}
		if(!BankDemo.transfer(user, destAccount, destMoneyInput)) {
			System.out.println("转账失败！！");
			transfer();
		}
		System.out.println("转账成功！！");
		showMainUI();
	}
	
	public void queryBalance() {
		System.out.println("您的余额是：" + (Double)user.getBalance());
		showMainUI();
	}
	
	public void logout() {
		login();
		user = null;
	}
	
	
	
	public void showMainUI() {
		System.out.println("请输入以下数字进入菜单操作");
		System.out.println("1：修改用户密码");
		System.out.println("2: 转账");
		System.out.println("3：查询余额");
		System.out.println("4：退出登录");
		Scanner s = new Scanner(System.in);
		String content = s.nextLine();
		switch (content) {
		case "1":
			modifyPassword();
			break;
		case "2":
			transfer();
			break;
		case "3":
			queryBalance();
			break;
		case "4":
			logout();
			break;

		default:
			break;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("欢迎来到ATM系统!!");
		new ATMDemo().login();
	}
}