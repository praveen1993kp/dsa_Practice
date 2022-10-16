package bruteForce_Array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P01_SortEvenAndOddIndicesIndependently_2164 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode 2164
	 * 
	 * https://leetcode.com/problems/sort-even-and-odd-indices-independently/
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
		int[] nums = {4,1,2,3};
		int[] output = {2,3,4,1};
		Assert.assertArrayEquals(sortEvenAndOdd(nums), output);
	}
	
	@Test
	public void negative() {
		//Edge Case Test Data
		int[] nums = {3,2};
		int[] output = {3,2};
		Assert.assertArrayEquals(sortEvenAndOdd(nums), output);
	}
	
	@Test
	public void edge() {
		//Negative Test Data
		int[] nums = {4};
		int[] output = {4};
		Assert.assertArrayEquals(sortEvenAndOdd(nums), output);
	}

	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Pseudo code:
	 * 1. Traverse using two loops. Start from index 1 and increment both loops by 2
	 * 2. If the value on left is less than value on right, push the lower value to the right
	 * 3. Complete the step 2 for all the odd elements in the given array
	 * 4. Traverse using two loops. Start from index 0 and increment both loops by 2
	 * 5. If the value on left is greater than value on right, push the higher value to the right
	 * 6. Complete the step 2 for all the even elements in the given array
	 * 7. Return the array nums
	 * 
	 */	
	
	private int[] sortEvenAndOdd(int[] nums) {
		for(int i=1;i<nums.length;i=i+2){
            for(int j=i+2;j<nums.length;j=j+2){
                if(nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        
        for(int i=0;i<nums.length;i=i+2){
            for(int j=i+2;j<nums.length;j=j+2){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
	}
	
}
