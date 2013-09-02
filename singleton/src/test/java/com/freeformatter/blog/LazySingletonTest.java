package com.freeformatter.blog;

import org.junit.Assert;
import org.junit.Test;

public class LazySingletonTest {

	@Test
	public void testEquals() throws Exception {

		LazySingleton s1 = LazySingleton.getInstance();
		LazySingleton s2 = LazySingleton.getInstance();

		Assert.assertTrue(s1 == s2);
		Assert.assertTrue(s1.equals(s2));

	}

}