package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P09_ValidPalindromeII_680 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
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
		String s = "racevcar";
		boolean output = true;
		Assert.assertEquals(ValidPalindromeII(s), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "aae";
		boolean output = true;
		Assert.assertEquals(ValidPalindromeII(s), output);
	}
	
	

	@Test
	public void example3() {
		//Negative Test Data
		String s = "ar";
		boolean output = true;
		Assert.assertEquals(ValidPalindromeII(s), output);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String s = "mraacm";
		boolean output = false;
		Assert.assertEquals(ValidPalindromeII(s), output);
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		String s = "abcddrcba";
		boolean output = true;
		Assert.assertEquals(ValidPalindromeII(s), output);
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		String s = "abcrddcba";
		boolean output = true;
		Assert.assertEquals(ValidPalindromeII(s), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * --Two Pointers - Opposite Direction---
	 * 1. Create two pointers left=0 and right = s.length()-1
	 * 2. Traverse while left<right
	 * 3. if the characters matches, increment left and decrement right
	 * 4. else check if left+1 till right or left till right-1 are palindrome
	 * 5. Return the result of step 4
	 * 6. Return true by default
	 *  
	 * 
	 */	
	
	private boolean ValidPalindromeII(String s) {
		int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            } else 
                return (isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1));
        }
        return true;	
	}
	
	private boolean isPalindrome(String s, int p1, int p2) {
		while(p1<p2){
            if(s.charAt(p1) != s.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
	}
}
