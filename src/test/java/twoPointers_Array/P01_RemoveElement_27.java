package twoPointers_Array;

import org.junit.Test;

import junit.framework.Assert;

public class P01_RemoveElement_27 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode 27
	 * 
	 * Remove Element
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
		int[] nums = {3,2,2,3};
		int val = 2;
		int output = 2;
		Assert.assertEquals(removeElement(nums,val), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums = {3};
		int val = 2;
		int output = 0;
		Assert.assertEquals(removeElement(nums,val), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {2};
		int val = 2;
		int output = 0;
		Assert.assertEquals(removeElement(nums,val), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		int[] nums = {};
		int val = 2;
		int output = 0;
		Assert.assertEquals(removeElement(nums,val), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers, left=0 and right=0
	 * 2. Traverse till right<nums.length
	 * 3. If right != val, swap left and right and increment both
	 * 4. If right == val, increment right alone
	 * 5. Return left
	 * 
	 */	
	
	private int removeElement(int[] nums,int val) {
		int left=0,right=0,temp=0;
		while(right<nums.length) {
			if(nums[right] != val) {
				temp = nums[left];
				nums[left++] = nums[right];
				nums[right] = temp;
			}
			right++;
		}
		return left;
	}

}
