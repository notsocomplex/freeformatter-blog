package com.freeformatter.blog.pojo;

public class AnotherUser extends User {

	private int age;
	
	public AnotherUser() {
	}
	
	public AnotherUser(String firstName, String lastName, String email, int age) {
		super(firstName, lastName, email);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
		
}
