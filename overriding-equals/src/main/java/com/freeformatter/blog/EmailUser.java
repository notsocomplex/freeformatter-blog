package com.freeformatter.blog;

import org.apache.commons.lang3.StringUtils;

/**
 * Example of a User class with an equals method that uses the email for its identifier and that
 * ignores the case
 */
public class EmailUser {

	private String email;

	public EmailUser(final String email) {

		// Very naive validation for the sake of the example
		if (StringUtils.isBlank(email)) {
			throw new IllegalArgumentException("'email' is required");
		}
		
		this.email = email;
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {

		// Is instance the same reference?
		if (this == obj) {
			return true;
		}

		// Is it of the proper type? Will also take car of cases where obj argument is null
		if (!(obj instanceof EmailUser)) {
			return false;
		}

		// Cast it to the proper type
		EmailUser other = (EmailUser) obj;

		// Check that the email are the same. Ignore the case.
		return StringUtils.equalsIgnoreCase(this.email, other.email);

	}

	@Override
	public int hashCode() {
		// We need to normalize the email field for the hashCode, else using the contains method
		// would return false since the String.hashCode method would return a different value!
		return email.toUpperCase().hashCode();
	}

}
