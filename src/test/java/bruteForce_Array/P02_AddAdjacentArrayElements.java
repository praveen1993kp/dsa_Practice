package bruteForce_Array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P02_AddAdjacentArrayElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an input array, add the adjacent elements and return the output in another array
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
		int[] nums = {1,2,3,4,5};
		int[] output = {3,5,7,9};
		Assert.assertArrayEquals(addElements_twoPointers(nums), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {2,2};
		int[] output = {4};
		Assert.assertArrayEquals(addElements_twoPointers(nums), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3,4,5};
		int[] output = {3,5,7,9};
		Assert.assertArrayEquals(addElements_twoPointers(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Edge case: When the input array size is less than 2, return the input array as it is
	 * 2. Initiate index as 0
	 * 3. Create an array for output with size nums.length-1
	 * 4. Traverse through the given array starting from index 1
	 * 5. Add current element with previous element and store it in output[index]. Increment the index
	 * 6. Return output array
	 * 
	 * 
	 * --- Pseudo code - Two Pointers ---
	 * 1. Create two pointers 
	 * 2. left = 0, right = left+window-1
	 * 3. Add elements till left<=right
	 * 4. Update into the new array
	 * 5. Return the output array
	 * 
	 */	
	
	private int[] addElements(int[] nums) {
		if(nums.length < 2) return nums;
		int[] out = new int[nums.length-1];
		int index = 0;
		for(int i=1;i<nums.length;i++)
			out[index] = nums[i-1] + nums[i];
		return out;
	}
	
	private int[] addElements_twoPointers(int[] nums) {
		int window = 2;	
		int index = 0,right=0,sum=0;
		int[] output = new int[nums.length-window+1];
		for(int i=0;i<nums.length-window+1;i++) {
			right=i+window-1;
			sum=0;
			while(right>=i)
				sum += nums[right--];
			output[index++] = sum;
		}
		System.out.println(Arrays.toString(output));
		return output;
	}

}
