package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P08_IsPalindromeString {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given a String s, find if the string is a palindrome
	 * eg. RADAR - true
	 * 	   TESTER - false
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
		String s = "RADAR";
		boolean output = true;
		Assert.assertEquals(isPalindrome_TwoPointers(s), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "AAAA";
		boolean output = true;
		Assert.assertEquals(isPalindrome_TwoPointers(s), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "ABCD";
		boolean output = false;
		Assert.assertEquals(isPalindrome_TwoPointers(s), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Create variable revWord
	 * 2. Start from the end of given string and traverse till pointer >=0
	 * 3. If the reverse of string and the current string are same, return true
	 * 4. Else return false
	 * 
	 * -- Two Pointer --
	 * 
	 * 1. Create two pointers p1=0 and p2=s.length()-1
	 * 2. Check if both the values are same.
	 * 3. If not matching, return false
	 * 4. Return true by default
	 * 
	 */	
	
	
	private boolean isPalindrome_bruteForce(String s) {
		String revWord = "";
		for(int i=s.length()-1;i>=0;i--) {
			revWord += s.charAt(i);
		}
		return revWord.equals(s) ? true : false;
	}
	
	private boolean isPalindrome_TwoPointers(String s) {
		int left=0,right=s.length()-1;
		while(left<right) {
			if(s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}
