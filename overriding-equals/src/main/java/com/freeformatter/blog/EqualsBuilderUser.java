package com.freeformatter.blog;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Example of a User class with an equals method that uses more that one field
 * and makes use EqualsBuilder class from the commons-lang package.
 */
public class EqualsBuilderUser {

	private String name;
	private Date dateOfBirth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtils.trim(name).toLowerCase();
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		setName(name);
		this.dateOfBirth = dateOfBirth;

	}

	@Override
	public boolean equals(Object obj) {

		// Is instance the same reference?
		if (this == obj) {
			return true;
		}

		// Is it of the proper type? Will also take care of cases where obj
		// argument is null
		if (!(obj instanceof EqualsBuilderUser)) {
			return false;
		}

		// Cast it to the proper type
		EqualsBuilderUser other = (EqualsBuilderUser) obj;

		// Use an EqualsBuilder instance to check the equality of the other
		// fields
		return new EqualsBuilder()
				.append(this.name, other.name)
				.append(this.dateOfBirth, other.dateOfBirth)
				.isEquals();

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(dateOfBirth)
				.hashCode();
	}

}