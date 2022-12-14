package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P07_RemovePalindromicSubsequences_1332 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * You are given a string s consisting only of letters 'a' and 'b'. 
	 * 	In a single step you can remove one palindromic subsequence from s.
	 * Return the minimum number of steps to make the given string empty.
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
		String s = "abba";
		int output = 1;
		Assert.assertEquals(removePalindromicSubSequences(s), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "bababbbbaa";
		int output = 2;
		Assert.assertEquals(removePalindromicSubSequences(s), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "";
		int output = 0;
		Assert.assertEquals(removePalindromicSubSequences(s), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		String s = "ababababaaaaabbbbbbaaaabbbbbababababababababababa";
		int output = 2;
		Assert.assertEquals(removePalindromicSubSequences(s), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * Logic - There are only two characters a and b
	 * aaaaa and bbbb are also palindromes
	 * Since subsequence to be removed, when we remove either all a's or b's, the string becomes palindrome
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Check if the given string is palindrome
	 * 2. If palindrome, return 1
	 * 3. Else return 2
	 * 
	 * -- Two Pointer --
	 * 
	 * 1. If the given string is empty, no operation is required and hence 0
	 * 2. If the given string is a palindrome, return 1
	 * 3. If the given string is not a palindrome, return 2
	 * 
	 */	
	
	private int removePalindromicSubSequences(String s) {
		int start = 0, end = s.length()-1;
		if(s.length()==0) return 0;
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end)) {
				return 2;
			}
			start++;
			end--;
		}
		return 1;
	}
	
}
