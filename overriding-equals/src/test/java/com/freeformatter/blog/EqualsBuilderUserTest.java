package com.freeformatter.blog;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class EqualsBuilderUserTest {

	@Test
	public void testReflexive() throws ParseException {
		
		EqualsBuilderUser user1 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		assertTrue(user1.equals(user1));
		
	}
	
	@Test
	public void testSymmetric() throws ParseException {
		
		EqualsBuilderUser user1 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		EqualsBuilderUser user2 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		assertTrue(user1.equals(user2));
		assertTrue(user2.equals(user1));
		
	}
	
	@Test
	public void testTransitive() throws ParseException {
		
		EqualsBuilderUser user1 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		EqualsBuilderUser user2 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		EqualsBuilderUser user3 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
				
		assertTrue(user1.equals(user2));
		assertTrue(user1.equals(user3));
		assertTrue(user2.equals(user1));
		assertTrue(user2.equals(user3));
		assertTrue(user3.equals(user1));
		assertTrue(user3.equals(user2));
	}	
	
	@Test
	public void testConsistent() throws ParseException {		
		
		EqualsBuilderUser user1 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		EqualsBuilderUser user2 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		
		assertTrue(user1.equals(user2));
		
		// Changing the name will now make the equals failed since the field is used in the equals logic
		user2.setName("Spider-Man");
		assertFalse(user1.equals(user2));
		
		// Create a new user that is equal
		user2 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		assertTrue(user1.equals(user2));
		
		// With no more date of birth, this should not be equal
		user2.setDateOfBirth(null);
		assertFalse(user1.equals(user2));
		
		// Setting the date back should return it to equal
		user2.setDateOfBirth(DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		assertTrue(user1.equals(user2));
		
	}
	
	@Test
	public void testNonNullity() throws ParseException {
		
		EqualsBuilderUser user1 = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		assertFalse(user1.equals(null));
		
	}	
	
	@Test
	public void testWithHashSet() throws ParseException {
		
		EqualsBuilderUser user = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		
		Set<EqualsBuilderUser> users = new HashSet<EqualsBuilderUser>();
		users.add(user);
		
		EqualsBuilderUser toLookup = new EqualsBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		
		// Not the same instance, but is still equal logically!
		assertTrue(user != toLookup);
		assertTrue(users.contains(toLookup));		
		
	}	
	
}