package tests;

import Model.User;

public class UserTest{
	
	public static void main(String[] args) {
		User testUser = new User("mike" , "my_passwd" , "Mike" , "Smith" , "07771234567");
		
		System.out.println(testUser);
	}
	
}
