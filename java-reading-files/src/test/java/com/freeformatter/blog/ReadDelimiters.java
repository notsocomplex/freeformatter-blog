package com.freeformatter.blog;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class ReadDelimiters {
	
	@Test
	public void testReadDelimiters() throws IOException {
		
		String lineSeparator = System.getProperty("line.separator");
		File file = new File(ClassLoader.getSystemResource("sample.txt").getFile());
		
		// Use the new try-with-resource that automatically closes the stream.
		// Similar to C# using statement
		try (Scanner scanner = new Scanner(file)) {
			
			scanner.useDelimiter(Pattern.compile(lineSeparator, Pattern.MULTILINE));
			
			String line = null;
			
			int i = 1;
			while (scanner.hasNext()) {
				
				line = scanner.next();
				
				if (i == 1) {
					Assert.assertEquals(line, "This is the first line.");
				}
			
				if (i == 2) {
					Assert.assertEquals(line, "This is the second.");
				}
				
				if (i == 3) {
					Assert.assertEquals(line, "This is the third and final line.");
				}
				
				i++;;
								
			}
			
		} 
			
	}	
	
	@Test
	public void testReadDelimitersComplex() throws IOException {
		
		String lineSeparator = System.getProperty("line.separator");
		File file = new File(ClassLoader.getSystemResource("sample-complex.txt").getFile());
		
		try (Scanner scanner = new Scanner(file)) {
				
			scanner.useDelimiter(",|" +  lineSeparator);
			scanner.useLocale(Locale.US);
						
			int i = 1;			
			while (scanner.hasNext()) {
				
				String name = scanner.next();
				Double savings = scanner.nextDouble();

				if (i == 1) {
					Assert.assertEquals("Peter Parker", name);
					Assert.assertEquals(Double.valueOf("1323.55"), savings);
				}

				if (i == 2) {
					Assert.assertEquals("Anthony Stark", name);
					Assert.assertEquals(Double.valueOf("999999999.99"), savings);
				}
				
				i++;
				
			}
			
		} 
			
	}		
	
}
