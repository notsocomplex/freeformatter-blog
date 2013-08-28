package com.freeformatter.blog;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class EmailUserTest {

	@Test
	public void testReflexive() {
		EmailUser user1 = new EmailUser("peter.parker@dailybugle.com");
		assertTrue(user1.equals(user1));
	}
	
	@Test
	public void testSymmetric() {
		EmailUser user1 = new EmailUser("peter.parker@dailybugle.com");
		EmailUser user2 = new EmailUser("peter.parker@dailybugle.com");
		assertTrue(user1.equals(user2));
		assertTrue(user2.equals(user1));
	}
	
	@Test
	public void testTransitive() {
		
		EmailUser user1 = new EmailUser("peter.parker@dailybugle.com");
		EmailUser user2 = new EmailUser("PETER.parker@dailybugle.com");
		EmailUser user3 = new EmailUser("peter.PARKER@dailybugle.com");
		
		assertTrue(user1.equals(user2));
		assertTrue(user1.equals(user3));
		assertTrue(user2.equals(user1));
		assertTrue(user2.equals(user3));
		assertTrue(user3.equals(user1));
		assertTrue(user3.equals(user2));
	}	
	
	@Test
	public void testConsistent() {		
		
		EmailUser user1 = new EmailUser("peter.parker@dailybugle.com");
		EmailUser user2 = new EmailUser("peter.parker@dailybugle.com");
		
		assertTrue(user1.equals(user2));
		
		// Now we have changed the email and since this is the key, it is not longer equal
		user2.setEmail("spider-man@marvel.com");
		assertFalse(user1.equals(user2));
		
	}
	
	@Test
	public void testNonNullity() {
		
		EmailUser user1 = new EmailUser("peter.parker@dailybugle.com");
		assertFalse(user1.equals(null));
		
	}	
	
	@Test
	public void testWithHashSet() {
		
		EmailUser user = new EmailUser("peter.parker@dailybugle.com");
		
		Set<EmailUser> users = new HashSet<EmailUser>();
		users.add(user);
		
		EmailUser toLookup = new EmailUser("PETER.PARKER@DAILYBUGLE.COM");
		
		// Not the same instance, but is still equal logically!
		assertTrue(user != toLookup);
		assertTrue(users.contains(toLookup));		
		
	}	
	
}
