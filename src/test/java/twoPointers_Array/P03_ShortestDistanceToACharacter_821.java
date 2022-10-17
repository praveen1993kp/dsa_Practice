package twoPointers_Array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P03_ShortestDistanceToACharacter_821 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode #821
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
		String s = "loveleetcode";
		char ch = 'e';
		int[] output = {3,2,1,0,1,0,0,1,2,2,1,0};
		Assert.assertArrayEquals(shortestDistance(s,ch), output);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "loveleetcode";
		char ch = 'd';
		int[] output = {10,9,8,7,6,5,4,3,2,1,0,1};
		Assert.assertArrayEquals(shortestDistance(s,ch), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "aaba";
		char ch = 'b';
		int[] output = {2,1,0,1};
		Assert.assertArrayEquals(shortestDistance(s,ch), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 
	 * 1. Create two pointers at the left end of array
	 * 2. Create an array for storing the output and fill the array with Integer.MAX_VALUE
	 * 3. Traverse through the array in right direction
	 * 4. Move the fast pointer by default. 
	 * 5. When the val match is found, update the output[slowpointer] and increment
	 * 6. Continue step 5 till slow and fast pointers meet
	 * 7. Continue steps 3-6 till end of array
	 * 8. Initialize the pointers to s.length()-1 
	 * 9. Repeat steps 3-7 but in reverse direction of array
	 * 10. Update the values into output array only when the difference if i-j is less than current array value
	 * 11. Return the output array
	 * 
	 */	
	
	private int[] shortestDistance(String s, char ch) {
		int slow = 0,fast=0;
		int len = s.length();
		int[] output = new int[len];
		Arrays.fill(output, Integer.MAX_VALUE);
		while(fast<len) {
			if(s.charAt(fast)==ch) {
				while(slow<=fast) {
					output[slow] = fast-slow;
					slow++;
				}
			}
			fast++;
		}
		slow = fast = len-1;
		while(fast>=0) {
			if(s.charAt(fast)==ch) {
				while(slow>=fast) {
					output[slow] = Math.min(Math.abs(slow-fast), output[slow]);
					slow--;
				}
			}
			fast--;
		}
		return output;
		 
	}
}
