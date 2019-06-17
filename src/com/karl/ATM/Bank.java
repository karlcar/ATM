package com.karl.ATM;

public class Bank {
	private static User[] userArray; //static ��̬ȫ��Ψһ
	
	static{
		userArray = new User[100];
		User user1 = new User("karl", "123456", "���", 89078.92);
		User user2 = new User("car", "789067", "���", 123890.91);
		
		userArray[0] = user1;
		userArray[1] = user2;
		
	}
	
	//����û��˺��Ƿ����
	public  static boolean CheckUsersIsExist(String username){
		boolean sign = false;
		for(int i=0; i<userArray.length; i++){
			if(userArray[i] != null){
				if(userArray[i].getUsername().equalsIgnoreCase(username)){
					return true;
				}
			}
		}
		return sign;
	}

	//����û��˺������Ƿ���ȷ
	public  static boolean CheckUsersPassword(String username,String password){
		boolean sign = false;
		for(int i=0; i<userArray.length; i++){
			if(userArray[i] != null){
				if(userArray[i].getUsername().equalsIgnoreCase(username) && userArray[i].getPassword().equalsIgnoreCase(password)){
					return true;
				}
			}
		}
		return sign;
	}
	
	//�û���¼
	public static boolean login(String username,String password){
		return CheckUsersPassword(username,password);
	}
	
	//�޸�����
	public static boolean modifyPassword(User user,String newPassword){
		boolean sign = false;
		user.setPassword(newPassword);
		sign = true;
		return sign;
	}
	
	//�����û��������ȡ�û�����
	public  static User getUser(String username,String password){
		for(int i=0; i<userArray.length; i++){
			if(userArray[i] != null){
				if(userArray[i].getUsername().equalsIgnoreCase(username) && userArray[i].getPassword().equalsIgnoreCase(password)){
					return userArray[i];
				}
			}
		}
		return null;
	}
	
	//�����û�����ȡ�û����󣬽������������ԭ������ת�˵��У�����Ҫ�Է��˻������룬ֻ��Ҫ�˺ż���
	public static User getUser(String username) {
		for(int i=0; i<userArray.length; i++){
			if(userArray[i] != null){
				if(userArray[i].getUsername().equalsIgnoreCase(username)){
					return userArray[i];
				}
			}
		}
		return null;
	}
	
	
	//ת�˷���
	public static boolean transfer(User user, String destAccount, double money) {
		boolean sign = false;
		//��ȡĿ����˺ź���Ҫת�˵Ľ��
		User destUser  = getUser(destAccount);
		//�����û���Ǯ����Ŀ���û���Ǯ
		user.setBalance(user.getBalance() - money);
		destUser.setBalance(destUser.getBalance() + money);
		sign =true;
		
		return sign;
	}
	
	
}
