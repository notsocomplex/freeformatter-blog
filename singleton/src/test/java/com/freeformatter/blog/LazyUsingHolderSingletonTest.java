package com.freeformatter.blog;

import org.junit.Assert;
import org.junit.Test;

public class LazyUsingHolderSingletonTest {

	@Test
	public void testEquals() throws Exception {

		LazyUsingHolderSingleton s1 = LazyUsingHolderSingleton.getInstance();
		LazyUsingHolderSingleton s2 = LazyUsingHolderSingleton.getInstance();

		Assert.assertTrue(s1 == s2);
		Assert.assertTrue(s1.equals(s2));

	}

}