package com.freeformatter.blog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Test;

public class EnumSingletonTest {

	@Test
	public void testEqualsAndSerialize() throws Exception {

		EnumSingleton s1 = EnumSingleton.INSTANCE;
		EnumSingleton s2 = EnumSingleton.INSTANCE;

		Assert.assertTrue(s1 == s2);
		Assert.assertTrue(s1.equals(s2));

		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(byteOut);

		objectOut.writeObject(s1);
		objectOut.close();
		
		byte [] bytes = byteOut.toByteArray();
		
		ObjectInputStream byteInput = new ObjectInputStream(
			new ByteArrayInputStream(bytes)
		);

		s2 = (EnumSingleton) byteInput.readObject();
		
		byteInput.close();
		
		Assert.assertTrue(s1 == s2);
		Assert.assertTrue(s1.equals(s2));
		
	}

}