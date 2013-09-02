package com.freeformatter.blog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Test;

public class SerializableSingletonTest {

	@Test
	public void testEqualsAndSerialize() throws Exception {

		SerializableSingleton s1 = SerializableSingleton.getInstance();
		SerializableSingleton s2 = SerializableSingleton.getInstance();

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

		s2 = (SerializableSingleton) byteInput.readObject();
		
		byteInput.close();
		
		// Without the readResolve method, these two statements 
		// would be false!
		Assert.assertTrue(s1 == s2);
		Assert.assertTrue(s1.equals(s2));

	}

}