package assessment;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class ValidAnagram_242_2711 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
	 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
	 * Constrains: s and t consist of lowercase English letters.
	 * Input: s = "anagram", t = "nagaram"
	 * Output: true
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? 
	 * 	yes or no 
	 * 	If no ask the person to provide
	 * 	with more details with examples 
	 * 	If yes go to the next step What is the
	 * 	input(s)? What is the expected output? 
	 * 
	 * 	Do I have any constraints to solve the
	 * 	problem? Do I have all the information to go to the next steps 
	 * 	How big is your test data set will be? 
	 * 
	 * 2. Test data set Minimum 3 data set including positive, negative and edge
	 * Validate with the interviewer if the data set is fine by his/ her assumptions
	 * 
	 * 
	 * 3. Do I know to solve it? 
	 * 	Yes- great is there an alternate ? 
	 * 	No - can I break the problem into sub problems?
	 * 
	 * 
	 * 4. Ask for hint (if you dont know how to solve
	 * this) 
	 * 
	 * 5. Do I know alternate solutions as well Yes- what are those? No- that
	 * is still fine, proceed to solve by what you know 
	 * 
	 * 6. If you know the alternate
	 * solution find out the O-notations (performance) 
	 * 
	 * 
	 * 7. Then, explain either both are the best (depends on
	 * the time) 
	 * 	Approach 1:- start with the worst-> improve (optimize) -> End up
	 * with the best 
	 * 	Approach 2: Write down the options and benefits and code the
	 * best 
	 * 
	 * 8. Start always with the Pseudo code 
	 * 
	 * 9. Test against different test data
	 * 
	 * 10. If it fails then debug to solve it
	 */
	
	@Test
	public void positive() {
		//Positive Test Data
		String s = "anagram";
		String t = "nagaram";
		Assert.assertEquals(isAnagram_asciiWithoutArray(s,t), true);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "anagrame";
		String t = "nagaram";
		Assert.assertEquals(isAnagram_asciiWithoutArray(s,t), false);
	}
	
	@Test
	public void negative2() {
		//Edge Case Test Data
		String s = "a";
		String t = "aa";
		Assert.assertEquals(isAnagram_asciiWithoutArray(s,t), false);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "anagram";
		String t = "nagaaram";
		Assert.assertEquals(isAnagram_asciiWithoutArray(s,t), false);
	}

	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create one ascii array
	 * 2. Add all the characters of s into the array
	 * 3. Remove each of the occurrence of t from the ascii array
	 * 4. When all the elements of ascii are 0, return true
	 * 5. Else, return false
	 * 
	 *
	 * 
	 */	
	
	private boolean isAnagram_asciiWithoutArray(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] ascii = new int[26];
		for(int i=0;i<s.length();i++) {
			ascii[s.charAt(i)-'a']++;
			ascii[t.charAt(i)-'a']--;
		}
		
		for(int i=0;i<ascii.length;i++) 
			if(ascii[i] !=0 ) return false;
			
		return true;
	}
	
	
	
}
