package bruteForce_Array;

import org.junit.Assert;
import org.junit.Test;

public class S03_sortArrayByParityII_922 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

		Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

		Return any answer array that satisfies this condition.
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
		int[] nums = {4,2,5,7};
		int[] output = {4,5,2,7};
		Assert.assertArrayEquals(sortParityII(nums), output);
	}
		

	@Test
	public void negative() {
		//Edge Case Test Data
		int[] nums = {2,3,4,5};
		int[] output = {2,3,4,5};
		Assert.assertArrayEquals(sortParityII(nums), output);
	}
	
	@Test
	public void edge() {
		//Negative Test Data
		int[] nums = {1,1,2,2};
		int[] output = {2,1,2,1};
		Assert.assertArrayEquals(sortParityII(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse through the given array
	 * 2. If the index is odd and the number is odd, skip to next
	 * 3. If the index is even and the number is even, skip to next
	 * 4. Else, find the next available opposite number and swap it
	 * 5. Return nums
	 * 
	 */	
	
	private int[] sortParityII(int[] nums) {
		int[] output = new int[nums.length];
		int insertIndex=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2==0) {
				output[insertIndex] = nums[i];
				insertIndex += 2;
			}	
		}
		insertIndex = 1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2!=0) {
				output[insertIndex] = nums[i];
				insertIndex += 2;
			}			
		}
		return output;
	}
}
