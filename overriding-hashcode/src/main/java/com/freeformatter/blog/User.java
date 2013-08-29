package com.freeformatter.blog;

/**
 * Example of a User class with an equals method that uses an id of type int
 */
public class User {

	private int id;
	private String email;

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(final int id, final String email) {

		// Very naive validation for the sake of the example
		if (id <= 0) {
			throw new IllegalArgumentException("'id' should be positive");
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

		// Is it of the proper type? Will also take care of cases where obj
		// argument is null
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
		return new Integer(id).hashCode();
	}

}