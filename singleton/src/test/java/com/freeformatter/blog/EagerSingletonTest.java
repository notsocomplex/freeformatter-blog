package com.freeformatter.blog;

import org.junit.Assert;
import org.junit.Test;

public class EagerSingletonTest {

	@Test
	public void testEquals() throws Exception {

		EagerSingleton s1 = EagerSingleton.getInstance();
		EagerSingleton s2 = EagerSingleton.getInstance();

		Assert.assertTrue(s1 == s2);
		Assert.assertTrue(s1.equals(s2));

	}

}