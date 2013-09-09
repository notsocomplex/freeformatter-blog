package com.freeformatter.blog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class RegexReplaceGroupTest {
	

	@Test
	public void testReplacementWithGroupsMultipleMatches() {
				
		String text = 
			"this sentence should start with a capital letter. this one also! "
			+ "what about this one? Or this one?";
		
		// Group 1: ([a-z])
		//			-Match a character
		// Group 2: (.+?[.!?])
		//			-Match anything one or more time
		//			-Make the match non-greedy, so stop match the minimum number of times
		//			-Followed by one of these character (punctuation). Could have used
		//			\p{Punct} also.
		String regex = "([a-z])(.+?[.!?])";

		// Enable case-insensitive in Java is done using flags from Pattern.
		// Without this flag, we would have needed [a-zA-z] in our first group.
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);

		StringBuffer sb = new StringBuffer();

		// For each match. There will be 4.
		while (matcher.find()) {

			// Get the first group, which is the first letter of the sentence
			String firstLetter = matcher.group(1);					
			
			// Replace the match from the beginning with the upper case value
			// of the first letter and the group with index 2
			matcher.appendReplacement(sb, firstLetter.toUpperCase() + "$2");

		}

		// Append the tail, there should be none but it is always safer to
		// do this
		matcher.appendTail(sb);		
		Assert.assertEquals(sb.toString(), "This sentence should start with a capital letter. This one also! What about this one? Or this one?");
				
	}
	
	@Test
	public void testReplacementWithGroupsSingleMatch() {
				
		String text = "Frank Castle is Spider-Man. No Really!";
		
		// Group 1: (.+\\Wis\\W)
		//			-Match any character 1 or more time
		//			-Followed by 'is'
		//			-Followed by non-word boundary
		// Group 2: (.+)
		//			-Match any character 1 or more time
		// Group 3: (\\..+)
		//			-
		String regex = "(.+is\\W)(.+)(\\..+)"; 
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
				
		// Make sure we have a match
		Assert.assertTrue(matcher.find());
				
		Assert.assertEquals("Frank Castle is ", matcher.group(1));
		Assert.assertEquals("Spider-Man", matcher.group(2));
		Assert.assertEquals(". No Really!", matcher.group(3));
		
		// Replace the match, which is everything by group 1, 'The Punisher' and group 3
		String replaced = matcher.replaceAll("$1The Punisher$3");
		Assert.assertEquals("Frank Castle is The Punisher. No Really!", replaced);
		
		// Also works with replaceFirst!
		replaced = matcher.replaceFirst("$1The Punisher$3");
		Assert.assertEquals("Frank Castle is The Punisher. No Really!", replaced);

		// Lets reset the matcher and use appendReplacement instead to replace the individual groups
		matcher.reset();
		matcher.matches();
		
		// Replace the match, which is everything, by group 1, 'The Punisher' and group 3
		StringBuffer buffer = new StringBuffer();		
		matcher.appendReplacement(buffer, "$1The Punisher$3");
		Assert.assertEquals("Frank Castle is The Punisher. No Really!", buffer.toString());
		
	}
	
	@Test
	public void testZeroWidthReplacement() {
				
		String text = "Frank Castle is Spider-Man. No Really!";
		
		// Find the 'is' word, followed by a non-word character. Make this a zero-width
		// match. Following that, match anything with at least 1 character until a period(.)
		// And anything that follows is zero-width.
		String regex = "(?<=is\\W)(.+)(?=\\..+)"; 
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		StringBuffer buffer = new StringBuffer();
		
		// Make sure we have a match
		Assert.assertTrue(matcher.find());
			
		// We only have one group, so this works
		Assert.assertEquals("Spider-Man", matcher.group());
		
		// Explicitly ask for the first group. Starts at one, not zero.
		Assert.assertEquals("Spider-Man", matcher.group(1));		
		
		// The group starts with char at 16, 'S'
		Assert.assertEquals(16, matcher.start(1));
		
		// The group ends with char at 26, '.' 
		Assert.assertEquals(26, matcher.end(1));
				
		// This takes everything from the append position up to the position of the match
		matcher.appendReplacement(buffer, "The Punisher");
			
		// This takes everything after the match
		matcher.appendTail(buffer);
			
		// Outputs: Frank Castle is The Punisher. No Really!
		Assert.assertEquals("Frank Castle is The Punisher. No Really!", buffer.toString());
		
		// Use the replace all method instead
		Assert.assertEquals("Frank Castle is The Punisher. No Really!", matcher.replaceAll("The Punisher"));
		
	}

}