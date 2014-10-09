package com.howfunny.model;

import java.util.concurrent.ConcurrentHashMap;

public class User {

	private ConcurrentHashMap<String, String> userMap = new ConcurrentHashMap<String,String>();
	public User(){
		userMap.put("mokul", "123456");
		userMap.put("ripon", "ripon12");
		userMap.put("bappi", "bappi12");
		userMap.put("uttam", "uttam12");		
	}
	
	public boolean userExist(String userName){
		return userMap.containsKey(userName);
	}
	public boolean validUser(String userName, String passWord){
		if(userMap.get(userName) == null)
			return false;
		
		return userMap.get(userName).equalsIgnoreCase(passWord);
	}
}
