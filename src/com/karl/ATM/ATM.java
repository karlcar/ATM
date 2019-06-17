package com.karl.ATM;

import java.util.Scanner;

public class ATM {
	//已登录用户 
	User user;
	public void login(){
		Helper.log("请输入账号");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		if(!Bank.CheckUsersIsExist(username)){
			login();
		}
		Helper.log("请输入密码");
		String password = s.nextLine();
		if(!Bank.CheckUsersPassword(username, password)){
			login();
		}
		//TODO 进入主界面
		//把用户查出来,要获取用户，现在Bank类中get到User
		user = Bank.getUser(username, password); 
		Helper.log("恭喜！" + user.getUsername() + "登录成功！！");
		showMainUI();
	}
	
	public void modifyPassword(){
		 Helper.log("请输入原密码");
		 Scanner s = new Scanner(System.in);
		 String password = s.nextLine();
		 if(!user.getPassword().equalsIgnoreCase(password)) {
			 modifyPassword();
		 }
		 Helper.log("请输入新密码");
		 String newPassword = s.nextLine(); 
		 if(!Bank.modifyPassword(user, newPassword)) {
			 modifyPassword();
		 }
		 Helper.log("修改成功！");
		 showMainUI();
	}
	
	public void transfer() {
		Helper.log("请输入对方账号");
		Scanner s = new Scanner(System.in);
		String destAccount = s.nextLine();
		if(!Bank.CheckUsersIsExist(destAccount)) {
			transfer();
		}
		Helper.log("请输入转账金额:");
		String moneyStr = s.nextLine();
		double money = Double.parseDouble(moneyStr);
		if(user.getBalance()<money) {
			Helper.log("您的余额不足!");
			transfer();
		}
		//需要转账
		if(!Bank.transfer(user, destAccount, money)) {
			Helper.log("转账不成功！！");
			transfer();
		}
		Helper.log("转账成功");
		showMainUI();
	}
	
	public void queryBalance() {
		Helper.log("你的余额是：" + user.getBalance());
		showMainUI();
	}
	
	
	public void logout() {
		login();
		user = null;
	}
	
	
	
	
	//主界面方法
	public void showMainUI(){
		//获取用户名
		
		Helper.log("请输入以下数字进入菜单操作");
		Helper.log("1：修改用户密码");
		Helper.log("2: 转账");
		Helper.log("3：查询余额");
		Helper.log("4：退出登录");
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
		Helper.log("欢迎进入ATM系统");
		new ATM().login();
	}
}
