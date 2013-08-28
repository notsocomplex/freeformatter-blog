package com.freeformatter.blog;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Example of a User class with an equals method that uses more that one field and makes use
 * EqualsBuilder class from the commons-lang package.
 */
public class EqualsBuilderUser {

	private String name;
	private Date dateOfBirth;
	
	public String getName() {
		return name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public EqualsBuilderUser(final String name, Date dateOfBirth) {
		
		// Very naive validation for the sake of the example
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("'name' is required");
		}
		
		if (dateOfBirth == null) {
			throw new IllegalArgumentException("'dateOfBirth' is required");
		}
		
		// Let's normalize the name just to ease the example
		this.name = StringUtils.trim(name).toLowerCase();
		this.dateOfBirth = dateOfBirth;
		
	}

	@Override
	public boolean equals(Object obj) {

		// Is instance the same reference?
		if (this == obj) {
			return true;
		}

		// Is it of the proper type? Will also take car of cases where obj argument is null
		if (!(obj instanceof EqualsBuilderUser)) {
			return false;
		}

		// Cast it to the proper type
		EqualsBuilderUser other = (EqualsBuilderUser) obj;

		// Use an EqualsBuilder instance to check the equality of the other fields
		return new EqualsBuilder()
			.append(this.name, other.name)
			.append(this.dateOfBirth, other.dateOfBirth)
			.isEquals();

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(name)
			.append(dateOfBirth)
			.hashCode();
	}

	public static void main(String[] args) throws ParseException {

		EqualsBuilderUser user = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		
		Set<EqualsBuilderUser> users = new HashSet<EqualsBuilderUser>();
		users.add(user);
		
		EqualsBuilderUser toLookup = new EqualsBuilderUser("peter parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		EqualsBuilderUser wrongDate = new EqualsBuilderUser("peter parker", DateUtils.parseDate("2013-08-01", "yyyy-MM-dd"));
		
		System.out.println("These are not the same instances: " + (users != toLookup));
		System.out.println("The set contains this object for sure: " + users.contains(user));
		System.out.println("This is a different instance, but is equal regardless: " + users.contains(toLookup));
		System.out.println("This instance is not equal because the birth date is different: " + !users.contains(wrongDate));
			
	}
	
}
