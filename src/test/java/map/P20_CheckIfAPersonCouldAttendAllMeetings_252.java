package map;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P20_CheckIfAPersonCouldAttendAllMeetings_252 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
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
	public void negative() {
		//Negative Test Data
		int[][] nums = {{0,30},{5,10},{15,20}};
		boolean output = false;
		Assert.assertEquals(meetings(nums), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[][] nums = {{1,2}};
		boolean output = true;
		Assert.assertEquals(meetings(nums), output);
	}
	
	@Test
	public void example3() {
		//Edge Case Test Data
		int[][] nums = {{1,2},{2,4}};
		boolean output = false;
		Assert.assertEquals(meetings(nums), output);
	}
	
	@Test
	public void positive() {
		//Positive Test Data
		int[][] nums = {{7,10},{2,4}};
		boolean output = true;
		Assert.assertEquals(meetings(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given 2d array
	 * 2. Check if the 1st index value of an element is always less than 0th index of next element
	 * 3. If condition 2 is not true, return false
	 * 4. return true by default
	 * 
	 */	
	
	
	private boolean meetings(int[][] nums) {
		if(nums.length==1) return true;
		Arrays.sort(nums);
		int left=0,right=1;
		while(right<nums.length-1){
			if(nums[left++][1] >= nums[right++][0]) return false;
		}
		return true;
	}
}
