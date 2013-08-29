package com.freeformatter.blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class UserTest {

	@Test
	public void testIfEqualsSameHashCode() {		
		
		User user1 = new User(1, "peter.parker@dailybugle.com");
		User user2 = new User(1, "peter.parker@dailybugle.com");
		
		assertTrue(user1.equals(user2));
		assertEquals(user1.hashCode(), user2.hashCode());
		
	}
	
	@Test
	public void testChangeFieldValues() {		
		
		User user1 = new User(1, "peter.parker@dailybugle.com");
		User user2 = new User(1, "peter.parker@dailybugle.com");
		
		assertTrue(user1.equals(user2));
		assertEquals(user1.hashCode(), user2.hashCode());
		
		// Still the same hashCode as only the int field is used to compute
		user2.setEmail("spider-man@marvel.com");
		assertEquals(user1.hashCode(), user2.hashCode());
		
		// Not the same hashCode since the id is now not the same, hence 
		// the instance
		ReflectionTestUtils.setField(user2, "id", 2);
		assertNotEquals(user1.hashCode(), user2.hashCode());
		
	}
	
	public void testWithHashSet() {
		
		User user = new User(1, "peter.parker@dailybugle.com");
		
		Set<User> users = new HashSet<User>();
		users.add(user);
		
		User toLookup = new User(1, "peter.parker@dailybugle.com");
		
		// Not the same instance, but is still equal logically!
		assertTrue(user != toLookup);
		assertTrue(users.contains(toLookup));		
		
	}	
	
}