package bruteForce_Array;

import org.junit.Assert;
import org.junit.Test;

public class S04_SortAnArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Given an input array, sort the elements without using in-built functions.
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? 
	 * 	yes or no  - yes
	 * 	If no ask the person to provide
	 * 	with more details with examples 
	 * 	If yes go to the next step What is the
	 * 	input(s)? What is the expected output? 
	 * 
	 * 	Do I have any constraints to solve the - without in-built
	 * 	problem? Do I have all the information to go to the next steps - yes
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
		int nums[] = {-1,-2,0,3,5,2};
		int output[] = {-2,-1,0,2,3,5};
		Assert.assertArrayEquals(sortArray(nums), output);
	}
	
	@Test
	public void negative() {
		//Edge Case Test Data
		int nums[] = {1,2,3,4,5};
		int output[] = {1,2,3,4,5};
		Assert.assertArrayEquals(sortArray(nums), output);
	}
	
	@Test
	public void edge() {
		//Negative Test Data
		int nums[] = {1,2,2,3,4,5};
		int output[] = {1,2,2,3,4,5};
		Assert.assertArrayEquals(sortArray(nums), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		int nums[] = {};
		int output[] = {};
		Assert.assertArrayEquals(sortArray(nums), output);
	}
	
	@Test
	public void edge3() {
		//Negative Test Data
		int nums[] = {3};
		int output[] = {3};
		Assert.assertArrayEquals(sortArray(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse using two for loops. i=0 and j=i+1
	 * 2. If the number on left side is greater than number on right side, swap them
	 * 3. Else continue to next
	 * 4. Complete steps 2-3 for all the elements
	 * 5. Return the array nums
	 * 
	 * 
	 */	
	
	private int[] sortArray(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
}
