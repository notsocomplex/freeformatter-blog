package com.freeformatter.blog;

import org.junit.Assert;
import org.junit.Test;

public class EagerStaticBlockSingletonTest {

	@Test
	public void testEquals() throws Exception {

		EagerStaticBlockSingleton s1 = EagerStaticBlockSingleton.getInstance();
		EagerStaticBlockSingleton s2 = EagerStaticBlockSingleton.getInstance();

		Assert.assertTrue(s1 == s2);
		Assert.assertTrue(s1.equals(s2));

	}

}