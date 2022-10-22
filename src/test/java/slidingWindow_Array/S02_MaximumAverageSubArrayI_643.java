package slidingWindow_Array;

import org.junit.Test;

import junit.framework.Assert;

public class S02_MaximumAverageSubArrayI_643 {

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
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		double output = 12.50;
		Assert.assertEquals(maxAvgSubArrayI_TwoPointers(nums,k), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {2,2,2,2};
		int k = 4;
		double output = 2.00;
		Assert.assertEquals(maxAvgSubArrayI_TwoPointers(nums,k), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {0,0,0,0,0};
		int k = 2;
		double output = 0.00;
		Assert.assertEquals(maxAvgSubArrayI_TwoPointers(nums,k), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1: Sliding window with two pointers
	 * 1. Create two pointers left=0 and right=0
	 * 2. Create variables maxSum=Integer.MIN_VALUE and sum=0
	 * 3. For first k numbers, calculate the sum
	 * 4. Assign the sum to maxSum
	 * 5. Traverse while right<nums.length
	 * 6. Add nums[right] and subtract nums[left] from sum. Increment both pointers
	 * 7. Calculate the maxSum
	 * 8. Return maxSum/k and cast it to double
	 * 
	 * 
	 * Approach 2: Sliding window with one pointer
	 * 1. Create one pointer p1=0
	 * 2. Create variables maxSum=Integer.MIN_VALUE and sum=0
	 * 3. For first k numbers, calcuate the um
	 * 4. Assign the sum to maxSum
	 * 5. Traverse while p1<nums.length
	 * 6. Add nums[p1] to sum and subtract nums[p1-k] from sum. Increment p1
	 * 7. Calculate the maxSum
	 * 8. Return maxSum/k and cast it to double
	 * 
	 */	
	
	private double maxAvgSubArrayI_TwoPointers(int[] nums, int k) {
		int left=0,right=0,maxSum=Integer.MIN_VALUE,sum=0;
        while(right<k)
            sum += nums[right++];
        
        maxSum = sum;
        while(right<nums.length){
            sum += nums[right++] - nums[left++];
            maxSum = Math.max(sum,maxSum);
        }
		return (double)maxSum/k;
	}
	
	private double maxAvgSubArrayI_OnePointer(int[] nums, int k) {
		int p1=0,maxSum=Integer.MIN_VALUE,sum=0;
        while(p1<k)
            sum += nums[p1++];
        
        maxSum = sum;
        while(p1<nums.length){
            sum += nums[p1] - nums[p1-k];
            p1++;
            maxSum = Math.max(sum,maxSum);
        }
        return (double)maxSum/k;
	}

	
}
