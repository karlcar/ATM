package com.karl.ATMDemo;

import com.karl.ATM.User;

public class BankDemo {
	private static UserDemo[] userArray;
	
	static {
		userArray = new UserDemo[100];
		UserDemo user1 = new UserDemo("king", "123456", "����", 20190.91);
		UserDemo user2 = new UserDemo("helena", "343421", "������", 91230.22);
		userArray[0] = user1;
		userArray[1] = user2;
	}
	
	//��ѯ�˻��˺��Ƿ����
	public static boolean CheckUsersIsExist(String username) {
		boolean sign = false;
		for(int i=0; i<userArray.length; i++) {
			if(userArray[i] != null) {
				if(userArray[i].getUsername().equalsIgnoreCase(username)) {
					return true;
				}
			}
		}
		return sign;
	}
	
	//�����˺������ѯ�Ƿ���ȷ
	public static boolean CheckUsersPassword(String username,String password) {
		boolean sign = false;
		for(int i=0; i<userArray.length; i++) {
			if(userArray[i] != null) {
				if(userArray[i].getUsername().equalsIgnoreCase(username) && userArray[i].getPassword().equalsIgnoreCase(password)) {
					return true;
				}
			}
		}
		return sign;
	}
	
	//�˺ŵ�½
	public static boolean login(String username,String password) {
		return CheckUsersPassword(username, password);
	}
	
	//�����û��������ȡ����
	public static UserDemo getUser(String username,String password) {
		
		for(int i=0; i<userArray.length; i++) {
			if(userArray[i] != null) {
				if(userArray[i].getUsername().equalsIgnoreCase(username)&& userArray[i].getPassword().equalsIgnoreCase(password)) {
					return userArray[i];
				}
			}
		}
		return  null;
	}
	
	public static UserDemo getUser(String username) {
		
		for(int i=0; i<userArray.length; i++) {
			if(userArray[i] != null) {
				if(userArray[i].getUsername().equalsIgnoreCase(username)) {
					return userArray[i];
				}
			}
		}
		return  null;
	}
	
	
	//�޸�����
	public static boolean modifyPassword(UserDemo user, String newPassword) {
		boolean sign = false;
		user.setPassword(newPassword);
		sign = true;
		return sign;
	}
	
	//ת��
	public static boolean transfer(UserDemo user, String destAccount, double destMoneyInput) {
		boolean sign = false;
		//��ȡĿ���˻�
		UserDemo destUser = getUser(destAccount);
		user.setBalance(user.getBalance() - destMoneyInput);
		destUser.setBalance(destUser.getBalance() + destMoneyInput);
		sign = true;
		return sign;
	}
	
}
