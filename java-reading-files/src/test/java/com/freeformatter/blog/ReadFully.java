package com.freeformatter.blog;

import java.io.DataInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class ReadFully {

	private static final String FILE_CONTENT = "This is the first line.\r\nThis is the second.\r\nThis is the third and final line.";
	
	@Test
	public void testReadFully() throws IOException {
		
		// Use the new try-with-resource that automatically closes the stream.
		// Similar to C# using statement
		try (DataInputStream input = 
				new DataInputStream(ClassLoader.getSystemResourceAsStream("sample.txt"))) {
		
			// Gets the number of available bytes and allocate and array of that
			// many bytes
			int available = input.available();
			byte [] content = new byte [available]; 
			
			// Read the entire content in the array
			input.readFully(content);
			
			// Create a String representation of the byte array. Make sure
			// to specify the encoding that your file was in!
			String asString = new String(content, "UTF-8");
			Assert.assertEquals(asString, FILE_CONTENT);
			
		} 
			
	}
	
	@Test
	public void testReadFileWithIOUtils() throws IOException {
		
		// Gets the entire file content as a String in one simple call!
		String asString = IOUtils.toString(ClassLoader.getSystemResource("sample.txt"), "UTF-8");
		Assert.assertEquals(asString, FILE_CONTENT);	
		
	}	
	
}
