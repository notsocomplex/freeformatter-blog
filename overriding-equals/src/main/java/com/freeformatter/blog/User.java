package com.freeformatter.blog;

import java.util.HashSet;
import java.util.Set;

/**
 * Example of a User class with an equals method that uses a identifier field of type integer
 */
public class User {

	private Integer id;
	private String email;
	
	public Integer getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public User(final Integer id, final String email) {
		
		// Very naive validation for the sake of the example
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("'id' is required and should be positive");
		}
		
		this.id = id;
		this.email = email;
		
	}

	@Override
	public boolean equals(Object obj) {

		// Is instance the same reference?
		if (this == obj) {
			return true;
		}

		// Is it of the proper type? Will also take car of cases where obj argument is null
		if (!(obj instanceof User)) {
			return false;
		}

		// Cast it to the proper type
		User other = (User) obj;

		// Check relevant field. Id is required as per constructor
		return this.id == other.id;

	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public static void main(String[] args) {

		User user = new User(1, "peter.parker@dailybugle.com");
		
		Set<User> users = new HashSet<User>();
		users.add(user);
		
		User toLookup = new User(1, "peter.parker@dailybugle.com");
		
		System.out.println("These are not the same instances: " + (users != toLookup));
		System.out.println("The set contains this object for sure: " + users.contains(user));
		System.out.println("This is a different instance, but is equal regardless: " + users.contains(toLookup));
			
	}
	
}
