package com.freeformatter.blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class HashCodeBuilderUserTest {

	@Test
	public void testIfEqualsSameHashCode() throws ParseException {
		
		HashCodeBuilderUser user1 = new HashCodeBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		HashCodeBuilderUser user2 = new HashCodeBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		
		assertTrue(user1.equals(user2));
		assertTrue(user2.equals(user1));
		assertEquals(user1.hashCode(), user2.hashCode());
		
	}
	
	@Test
	public void testChangeFieldValues() throws ParseException {
		
		HashCodeBuilderUser user1 = new HashCodeBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		HashCodeBuilderUser user2 = new HashCodeBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
				
		assertTrue(user1.equals(user2));
		assertTrue(user2.equals(user1));
		assertEquals(user1.hashCode(), user2.hashCode());
		
		user2.setName("Spider-Man");
		assertNotEquals(user1.hashCode(), user2.hashCode());
		
	}	
	
	@Test
	public void testWithHashSet() throws ParseException {
		
		HashCodeBuilderUser user = new HashCodeBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		
		Set<HashCodeBuilderUser> users = new HashSet<HashCodeBuilderUser>();
		users.add(user);
		
		HashCodeBuilderUser toLookup = new HashCodeBuilderUser("Peter Parker", DateUtils.parseDate("1962-08-01", "yyyy-MM-dd"));
		
		// Not the same instance, but is still equal logically!
		assertTrue(user != toLookup);
		assertTrue(users.contains(toLookup));		
		
	}	
	
}