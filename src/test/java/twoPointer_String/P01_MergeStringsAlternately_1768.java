package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P01_MergeStringsAlternately_1768 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * You are given two strings word1 and word2. 
	 * Merge the strings by adding letters in alternating order, starting with word1. 
	 * If a string is longer than the other, append the additional letters 
	 * onto the end of the merged string.
	 *	
	 * Return the merged string.
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
		String word1 = "abc";
		String word2 = "def";
		String output = "adbecf";
		Assert.assertEquals(mergeStrings(word1,word2), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String word1 = "abcgh";
		String word2 = "def";
		String output = "adbecfgh";
		Assert.assertEquals(mergeStrings(word1,word2), output);
	}
	
	

	@Test
	public void example3() {
		//Negative Test Data
		String word1 = "def";
		String word2 = "a";
		String output = "daef";
		Assert.assertEquals(mergeStrings(word1,word2), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers left=0 and right = 0
	 * 2. Create a string builder
	 * 3. Traverse till left<word1.length() or right<word2.length()
	 * 4. If left<word1.length, append current character from word1 and increment left
	 * 5. If right<word2.length, append current character from word2 and increment right
	 * 6. Return built string
	 * 
	 * 
	 */	
	
	private String mergeStrings(String word1, String word2) {
		int left = 0,right=0;
        int len1 = word1.length(),len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        while(left<len1 || right<len2){
            if(left<len1) sb.append(word1.charAt(left++));
            if(right<len2) sb.append(word2.charAt(right++));
        }
        return sb.toString();
	}
}
