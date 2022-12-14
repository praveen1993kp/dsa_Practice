package slidingWindow_Array;

import java.util.Arrays;

import org.junit.Test;

public class S06_MinSizeSubArraySumEqualsTarget_209 {

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
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		int output = 2;
		System.out.println(minSubArray(nums,target));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,5};
		int target = 15;
		int output = 5;
		System.out.println(minSubArray(nums,target));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
		int target = 213;
		int output = 8;
		System.out.println(minSubArray(nums,target));
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left=0 and right=0;
	 * 2. Assign sum as nums[0]
	 * 3. Traverse for the length of nums
	 * 4. If sum < target, add nums[right] to sum and increment right
	 * 5. If sum >= target, while sum is greater than or equal to target, calculate right-left
	 * 6. Get the minimum of right-left and minCount 
	 * 7. Edge case: If the minCount is 1, return the minCount (Because it can't better than that
	 * 8. Decrement nums[left] from sum and increment left
	 * 
	 */	
	
	private int minSubArray(int[] nums, int target) {
        int left=0,right=1;
        int sum = nums[0],minCount = Integer.MAX_VALUE;
        while(right<nums.length){
            //System.out.println(left + "-" + right);
            if(sum<target) {
                sum += nums[right++];
            }
            while(sum>=target) {
                minCount = Math.min(right-left,minCount);
                sum -= nums[left];
                left++;
            }
        }
        return minCount==Integer.MAX_VALUE ? 0 : minCount;
	}
	
}
