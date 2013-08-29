package com.freeformatter.blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class EmailUserTest {

	@Test
	public void testIfEqualsSameHashCode() {

		EmailUser user1 = new EmailUser("peter.parker@dailybugle.com");
		EmailUser user2 = new EmailUser("peter.parker@dailybugle.com");
		EmailUser user3 = new EmailUser("PETER.PARKER@dailybugle.com");

		assertTrue(user1.equals(user2));
		assertTrue(user1.equals(user3));
		assertTrue(user2.equals(user3));

		assertEquals(user1.hashCode(), user2.hashCode());
		assertEquals(user1.hashCode(), user3.hashCode());
		assertEquals(user2.hashCode(), user3.hashCode());

	}

	@Test
	public void testChangeFieldValues() {

		EmailUser user1 = new EmailUser("peter.parker@dailybugle.com");
		EmailUser user2 = new EmailUser("peter.parker@dailybugle.com");

		assertTrue(user1.equals(user2));
		assertEquals(user1.hashCode(), user2.hashCode());

		// Same hashCode cause case-insensitive
		ReflectionTestUtils.setField(
			user2, "email", "PETER.PARKER@DAILYBUGLE.COM"
		);
		assertEquals(user1.hashCode(), user2.hashCode());

		// Not the same hashCode since the email was modified to another value
		ReflectionTestUtils.setField(user2, "email", "spider-man@marvel.com");
		assertNotEquals(user1.hashCode(), user2.hashCode());

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