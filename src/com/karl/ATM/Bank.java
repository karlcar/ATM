package com.karl.ATM;

public class Bank {
	private static User[] userArray; //static 静态全局唯一
	
	static{
		userArray = new User[100];
		User user1 = new User("karl", "123456", "泽佳", 89078.92);
		User user2 = new User("car", "789067", "这家", 123890.91);
		
		userArray[0] = user1;
		userArray[1] = user2;
		
	}
	
	//检查用户账号是否存在
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

	//检查用户账号密码是否正确
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
	
	//用户登录
	public static boolean login(String username,String password){
		return CheckUsersPassword(username,password);
	}
	
	//修改密码
	public static boolean modifyPassword(User user,String newPassword){
		boolean sign = false;
		user.setPassword(newPassword);
		sign = true;
		return sign;
	}
	
	//根据用户名密码获取用户对象
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
	
	//根据用户名获取用户对象，建立这个方法的原因在于转账当中，不需要对方账户的密码，只需要账号即可
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
	
	
	//转账方法
	public static boolean transfer(User user, String destAccount, double money) {
		boolean sign = false;
		//获取目标的账号和需要转账的金额
		User destUser  = getUser(destAccount);
		//给本用户减钱，给目标用户加钱
		user.setBalance(user.getBalance() - money);
		destUser.setBalance(destUser.getBalance() + money);
		sign =true;
		
		return sign;
	}
	
	
}
