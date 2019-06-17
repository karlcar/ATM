package com.karl.ATMDemo;

import java.util.Scanner;

import com.karl.ATM.Helper;

public class ATMDemo {
	
	//���ڵ�¼�˺���Ψһ�ģ�����ֱ�Ӵ���һ��User
	UserDemo user;
	
	public void login() {
		System.out.println("�������˺�:");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		if(! BankDemo.CheckUsersIsExist(username)) {
			login();
		}
		System.out.println("����������:");
		String password = s.nextLine();
		if(! BankDemo.CheckUsersPassword(username, password)) {
			System.out.println("������˺���������!");
			login();	
		}
		
		user = BankDemo.getUser(username, password);
		System.out.println("��ϲ��" + user.getUsername() + "��¼�ɹ�");
		showMainUI();
}
	public void modifyPassword() {
		System.out.println("������ԭ�������룺");
		Scanner s = new Scanner(System.in);
		String password = s.nextLine();
		if(! user.getPassword().equalsIgnoreCase(password)) {
			modifyPassword();
		}
		System.out.println("�������µ����룺");
		String newPassword = s.nextLine();
		if(! BankDemo.modifyPassword(user, newPassword)) {
			modifyPassword();
		}
		System.out.println("�޸ĳɹ�");
		showMainUI();
	}
	
	public void transfer() {
		System.out.println("������Է��˺ţ�");
		Scanner s = new Scanner(System.in);
		String destAccount = s.nextLine();
		if(! BankDemo.CheckUsersIsExist(destAccount)) {
			System.out.println("�öԷ��˺Ų����ڣ����������룺");
			transfer();
		}
		System.out.println("������ת�˽�");
		String Input = s.nextLine();
		double destMoneyInput =  Double.parseDouble(Input);
		if(user.getBalance() < destMoneyInput) {
			System.out.println("�������㣬���������룡��");
			transfer();
		}
		if(!BankDemo.transfer(user, destAccount, destMoneyInput)) {
			System.out.println("ת��ʧ�ܣ���");
			transfer();
		}
		System.out.println("ת�˳ɹ�����");
		showMainUI();
	}
	
	public void queryBalance() {
		System.out.println("��������ǣ�" + (Double)user.getBalance());
		showMainUI();
	}
	
	public void logout() {
		login();
		user = null;
	}
	
	
	
	public void showMainUI() {
		System.out.println("�������������ֽ���˵�����");
		System.out.println("1���޸��û�����");
		System.out.println("2: ת��");
		System.out.println("3����ѯ���");
		System.out.println("4���˳���¼");
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
		System.out.println("��ӭ����ATMϵͳ!!");
		new ATMDemo().login();
	}
}