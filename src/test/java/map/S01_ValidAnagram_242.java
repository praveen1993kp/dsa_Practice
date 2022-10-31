package map;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class S01_ValidAnagram_242 {

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
	public void example1() {
		//Positive Test Data
		String s = "anagram";
		String t = "nagaram";
		Assert.assertEquals(isAnagram_asciiWithoutArray(s,t), true);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "anagrame";
		String t = "nagaram";
		Assert.assertEquals(isAnagram_asciiWithoutArray(s,t), false);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "anagram";
		String t = "nagaaram";
		Assert.assertEquals(isAnagram_asciiWithoutArray(s,t), false);
	}
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * --Brute Force --
	 * 
	 * 1. If length not equal, return false
	 * 2. Sort both the strings
	 * 3. If the strings are not equal, return false
	 * 4. Else return true
	 * 
	 * -- Ascii Method 1 --
	 * 1. Create two ascii arrays of size 26
	 * 2. For each element in s, increment the respective array index by 1
	 * 3. For each element in t, increment the respective array index by 1
	 * 4. return If both the ascii arrays are equal
	 * 
	 * -- Ascii Method 2 --
	 * 1. Create one ascii arrays of size 26
	 * 2. For each element in s, increment the respective array index by 1
	 * 3. For each element in t, decrement the respective array index by 1
	 * 4. return if array is empty
	 * 
	 */	
	
	private boolean isAnagram_bruteForce(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] ch1 = s.toCharArray();
		char[] ch2 = t.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if(Arrays.toString(ch1).equals(Arrays.toString(ch2))) return true;
		return false;
	}
	
	private boolean isAnagram_ascii2(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] ascii1 = new int[26];
		int[] ascii2 = new int[26];
		
		for(int i=0;i<s.length();i++) {
			ascii1[s.charAt(i) - 'a']++;
			ascii2[t.charAt(i) - 'a']++;
		}
		return Arrays.equals(ascii1, ascii2) ? true : false;
	}
	
	private boolean isAnagram_ascii(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] ascii = new int[26];
		
		for(int i=0;i<s.length();i++) {
			ascii[s.charAt(i) - 'a']++;
			ascii[t.charAt(i) - 'a']--;
		}
		
		for(int i=0;i<ascii.length;i++) {
			if(ascii[i]!=0) return false;
		}
		return true;
	}
	
	//Below method needs optimization - Fails for input ac,bb
	private boolean isAnagram_asciiWithoutArray(String s, String t) {
		if(s.length() != t.length()) return false;
		int asciiVal1 = 0;
		for(int i=0;i<s.length();i++) {
			asciiVal1 += s.charAt(i)%'a';
			asciiVal1 -= t.charAt(i)%'a';
		}
		
		return asciiVal1==0 ? true : false;
	}
}
