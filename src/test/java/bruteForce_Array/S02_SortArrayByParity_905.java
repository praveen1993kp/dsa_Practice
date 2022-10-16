package bruteForce_Array;

import org.junit.Assert;
import org.junit.Test;

public class S02_SortArrayByParity_905 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode #905
	 * 
	 * Given an input array nums, move all the 
	 * even integers at the beginning of the array followed by all the odd integers.
	 * 
	 * Return any array that satisfies this condition.
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? 
	 * 	yes or no - yes
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
		int[] nums = {3,1,2,4};
		int[] output = {2,4,1,3};
		Assert.assertArrayEquals(sortArraysByParity_twoPointer(nums), output);
	}
		

	@Test
	public void negative() {
		//Edge Case Test Data
		int[] nums = {2,4,6,8};
		int[] output = {2,4,6,8};
		Assert.assertArrayEquals(sortArraysByParity_twoPointer(nums), output);
	}
	
	@Test
	public void edge() {
		//Negative Test Data
		int[] nums = {3};
		int[] output = {3};
		Assert.assertArrayEquals(sortArraysByParity_twoPointer(nums), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		int[] nums = {3,2,3};
		int[] output = {2,3,3};
		Assert.assertArrayEquals(sortArraysByParity_twoPointer(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create an output array same size as that of input
	 * 2. Traverse through the input array. 
	 * 3. Have two indices. One at the front and another at the last
	 * 4. If even, add to first and if odd, add to last
	 * 5. Return the output array
	 * 
	 * --- Pseudo Code - Brute Force ---
	 * 1. Traverse through the array using two for loops. i=0 and j=i+1
	 * 2. If nums[i] is odd and nums[j] is even, swap them
	 * 3. Continue the same process for all the elements
	 * 4. Return the nums
	 * 
	 */	
	
	
	private int[] sortArraysByParity_bruteForce(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]%2==1 && nums[j]%2==0) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
	
	private int[] sortArraysByParity_bruteForce2(int[] nums) {
		int[] output = new int[nums.length];
		int index=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2==0) output[index++] = nums[i];
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2==1) output[index++] = nums[i];
		}
		return output;
	}
	
	private int[] sortArraysByParity_twoPointer(int[] nums) {
		int[] output = new int[nums.length];
		int evenIndex = 0;
		int oddIndex = nums.length-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2==0) output[evenIndex++] = nums[i];
			else output[oddIndex--] = nums[i];
		}
		return output;
	}
}
