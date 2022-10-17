package twoPointers_Array;

import org.junit.Assert;
import org.junit.Test;

public class P02_MoveZeroes_283 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode #283
	 * 
	 * Given an integer array nums, move all 0's to the end of it 
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * Note that you must do this in-place without making a copy of the array.
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? 
	 * 	yes or no  - yes
	 * 	If no ask the person to provide
	 * 	with more details with examples 
	 * 	If yes go to the next step What is the
	 * 	input(s)? What is the expected output?  -- all the zeroes should go to last
	 * 
	 * 	Do I have any constraints to solve the
	 * 	problem? - without additional space
	 *  Do I have all the information to go to the next steps - yes
	 * 	How big is your test data set will be? 
	 * 
	 * 2. Test data set Minimum 3 data set including positive, negative and edge
	 * Validate with the interviewer if the data set is fine by his/ her assumptions
	 * 
	 * 
	 * 3. Do I know to solve it? - yes
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
		int[] nums = {0,1,0,3,12};
		int[] output = {1,3,12,0,0};
		Assert.assertArrayEquals(moveZeroes(nums), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums = {0};
		int[] output = {0};
		Assert.assertArrayEquals(moveZeroes(nums), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {0,0,0,3,0,0};
		int[] output = {3,0,0,0,0,0};
		Assert.assertArrayEquals(moveZeroes(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left = 0 and right = 1
	 * 2. Traverse till right<nums.length
	 * 3. If nums[left] == 0, swap and increment left
	 * 4. Increment right by default
	 * 5. Return nums
	 * 
	 */	
	
	private int[] moveZeroes(int[] nums) {
		int left=0,right=1,temp=0;
		while(right<nums.length) {
			if(nums[left]==0) {
				while(right<nums.length-1 && nums[right]==0) right++;
				temp = nums[left];
				nums[left++] = nums[right];
				nums[right] = temp;
			}
			right++;
		}
		return nums;
	}
}
