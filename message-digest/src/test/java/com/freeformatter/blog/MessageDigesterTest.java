package com.freeformatter.blog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageDigesterTest {

	private MessageDigester digester;
	
	@Before
	public void before() {
		digester = new MessageDigester();
	}
	
	@Test
	public void testMD5() throws Exception {
		Assert.assertEquals(
			"c1aab3b5796305c52b43cfb831962902", 
			digester.digest("BATMAN AND ROBIN", "MD5")
		);
	}
	
	@Test
	public void testSHA256() throws Exception {
		Assert.assertEquals(
			"9642eb61ba26426e71e3cf370c8b985e77f1b6080fd3cb34805050b9b4e66f4c", 
			digester.digest("BATMAN AND ROBIN", "SHA-256")
		);
	}
	
}
