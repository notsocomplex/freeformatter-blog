package com.freeformatter.blog;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class UserTest {

	@Test
	public void testReflexive() {		
		User user1 = new User(1, "peter.parker@dailybugle.com");
		assertTrue(user1.equals(user1));
	}
	
	@Test
	public void testSymmetric() {
		User user1 = new User(1, "peter.parker@dailybugle.com");
		User user2 = new User(1, "peter.parker@dailybugle.com");
		assertTrue(user1.equals(user2));
		assertTrue(user2.equals(user1));
	}
	
	@Test
	public void testTransitive() {
		
		User user1 = new User(1, "peter.parker@dailybugle.com");
		User user2 = new User(1, "peter.parker@dailybugle.com");
		User user3 = new User(1, "peter.parker@dailybugle.com");
		
		assertTrue(user1.equals(user2));
		assertTrue(user1.equals(user3));
		assertTrue(user2.equals(user1));
		assertTrue(user2.equals(user3));
		assertTrue(user3.equals(user1));
		assertTrue(user3.equals(user2));
	}	
	
	@Test
	public void testConsistent() {		
		
		User user1 = new User(1, "peter.parker@dailybugle.com");
		User user2 = new User(1, "peter.parker@dailybugle.com");
		
		// We change the email field, which is not used to compute the equality, therefore it should still be equal
		assertTrue(user1.equals(user2));
		user2.setEmail("spider-man@marvel.com");
		assertTrue(user1.equals(user2));
		
		// Now we have changed the id, hence they should no longer be equal!
		ReflectionTestUtils.setField(user2, "id", 2);
		assertFalse(user1.equals(user2));
		
	}
	
	@Test
	public void testNonNullity() {
		
		User user1 = new User(1, "peter.parker@dailybugle.com");
		assertFalse(user1.equals(null));
		
	}	
	
	@Test
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
