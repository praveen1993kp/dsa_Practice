package twoPointers_Array;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P11_RotateArray_189 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
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
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		int[] output = {5,6,7,1,2,3,4};
		Assert.assertTrue(Arrays.equals(rotateArray(nums,k), output));
	}
	
	@Test
	public void example2() {
		//Positive Test Data
		int[] nums = {-1,-100,3,99};
		int k = 2;
		int[] output = {3,99,-1,-100};
		Assert.assertTrue(Arrays.equals(rotateArray(nums,k), output));
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,5,6,7};
		int k = 7;
		int[] output = {1,2,3,4,5,6,7};
		Assert.assertTrue(Arrays.equals(rotateArray(nums,k), output));
	}
	
	@Test
	public void edge2() {
		//Edge Test Data
		int[] nums = {1,2,3,4,5,6,7};
		int k = 10;
		int[] output = {5,6,7,1,2,3,4};
		Assert.assertTrue(Arrays.equals(rotateArray(nums,k), output));
	}
	
	@Test
	public void negative() {
		//Edge Test Data
		int[] nums = {1,2,3,4,5,6,7};
		int k = 1;
		int[] output = {7,1,2,3,4,5,6};
		Assert.assertTrue(Arrays.equals(rotateArray(nums,k), output));
	}
	
	@Test
	public void negative2() {
		//Edge Test Data
		int[] nums = {1,2,3,4,5,6,7};
		int k = 0;
		int[] output = {1,2,3,4,5,6,7};
		Assert.assertTrue(Arrays.equals(rotateArray(nums,k), output));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers left=0 and right=nums.length-1
	 * 2. Swap the numbers from 0 to n-1
	 * 3. Swap the numbers from 0 to k-1
	 * 4. Swap the numbers from k to n-1
	 * 5. Return nums
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 */	
	
	
	
	private int[] rotateArray(int[] nums, int k) {
		if(k==nums.length) return nums;
		k = k%nums.length;
		nums = reverseNumbers(nums,0,nums.length-1);
		nums = reverseNumbers(nums,0,k-1);
		nums = reverseNumbers(nums,k,nums.length-1);
		
		return nums;
	}
	
	public int[] reverseNumbers(int[] nums,int startIndex,int endIndex) {
		int temp = 0;
		while(startIndex<endIndex) {
			temp = nums[startIndex];
			nums[startIndex++] = nums[endIndex];
			nums[endIndex--] = temp;
		}
		return nums;
	}
}
