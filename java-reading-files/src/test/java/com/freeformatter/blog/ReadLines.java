package com.freeformatter.blog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ReadLines {
	
	@Test
	public void testReadLines() throws IOException {
				
		File file = new File(ClassLoader.getSystemResource("sample.txt").getFile());
		
		// Use the new try-with-resource that automatically closes the stream.
		// Similar to C# using statement
		try (BufferedReader input = new BufferedReader(new FileReader(file))) {
			
			String line = null;
			
			int i = 1;
			
			while ((line = input.readLine()) != null) {
				
				if (i == 1) {
					Assert.assertEquals(line, "This is the first line.");
				}
			
				if (i == 2) {
					Assert.assertEquals(line, "This is the second.");
				}
				
				if (i == 3) {
					Assert.assertEquals(line, "This is the third and final line.");
				}
				
				i++;
				
			}
			
		} 
			
	}
		
}
