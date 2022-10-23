package slidingWindow_Array;

import org.junit.Test;

import junit.framework.Assert;

public class S05_MaximumVowelsInAString {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given a string s and a number k, 
	 * 	find the maximum number of vowels in substring of size k.
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
		String s = "workaatech";
		int k = 3;
		int output = 2;
		Assert.assertEquals(maxVowelsInASubString(s,k), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		String s = "d";
		int k = 1;
		int output = 0;
		Assert.assertEquals(maxVowelsInASubString(s,k), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String s = "e";
		int k = 1;
		int output = 1;
		Assert.assertEquals(maxVowelsInASubString(s,k), output);
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		String s = "eeeeeeeee";
		int k = 3;
		int output = 3;
		Assert.assertEquals(maxVowelsInASubString(s,k), output);
	}
	
	

	@Test
	public void negative() {
		//Negative Test Data
		String s = "cysts";
		int k = 5;
		int output = 0;
		Assert.assertEquals(maxVowelsInASubString(s,k), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a pointer p1=0. Create variables, vowelsCount, maxVowels
	 * 2. Traverse till k and find number of vowels as vowelsCount
	 * 3. Starting from k, add one to vowelsCount if value at p1 is vowel
	 * 4. If value at p1-k is vowel, remove one count
	 * 5. Find the maxCount between current vowelsCount and maxVowels
	 * 6. Return maxCount
	 * 
	 * For finding a Vowel:
	 * 1. If a character is either a,e,i,o,u, return true. Else false
	 * 
	 */	
	
	private int maxVowelsInASubString(String s, int k) {
		int p1=0;
		int vowelsCount=0,maxVowels = 0;
		while(p1<k) 
			if(isVowel(s.charAt(p1++))) vowelsCount++;
		
		maxVowels = vowelsCount;
		while(p1<s.length()) {
			if(isVowel(s.charAt(p1))) vowelsCount++;
			if(isVowel(s.charAt(p1-k))) vowelsCount--;
			p1++;
			maxVowels = Math.max(vowelsCount, maxVowels);
		}
		return maxVowels;
	}
	
	private boolean isVowel(char ch) {
		return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
	}
}
