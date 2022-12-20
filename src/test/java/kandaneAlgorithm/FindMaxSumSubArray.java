package kandaneAlgorithm;

import org.junit.Test;

import junit.framework.Assert;

public class FindMaxSumSubArray {

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
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int sum = 6;
		Assert.assertEquals(findMaxSumSubArray_Practice(nums), sum);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {0,3,5,0};
		int sum = 8;
		Assert.assertEquals(findMaxSumSubArray_Practice(nums), sum);
	}
	
	

	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {-1,-3,-5};
		int sum = -1;
		Assert.assertEquals(findMaxSumSubArray_Practice(nums), sum);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Create variables maxSum=Integer.MIN_VALUE and sum=0
	 * 2. Traverse through the given array using two loops. i=0 and j=i
	 * 3. Initiate sum=0 for every i value
	 * 4. Add sum with current value and find maxSum after every sum
	 * 5. Return maxSum
	 * 
	 * Kandane's algorithm : When sum less than 0 is found, reset it to 0
	 * 
	 * 1. Create pointers maxSum=0,sum=0,negMax=Integer.MIN_VALUE and a boolean flag to check if nonZero is available
	 * 2. Traverse through the given array
	 * 3. add current value to sum
	 * 4. If sum < 0, check negMax and reset sum to 0
	 * 5. Calculate the max between maxSum and sum
	 * 6. If maxSum greater than 0 and nonZero available flag is false, make it as true
	 * 7. If nonZero flag is true, return maxSum and if nonZero flag is false, return negMax
	 * 
	 * 
	 */	
	
	private int findMaxSumSubArray_bruteForce(int[] nums) {
		int maxSum=Integer.MIN_VALUE,sum=0;
		for(int i=0;i<nums.length;i++) {
			sum=0;
			for(int j=i;j<nums.length;j++) {
				sum += nums[j];
				maxSum = Math.max(sum, maxSum);
			}
		}
		return maxSum;
	}
	
	private int findMaxSumSubArray_kandane(int[] nums) {
		int maxSum=0,sum=0;
		int negMax = Integer.MIN_VALUE;
		boolean isNonZeroAvailable = false;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			if(sum<0) {
				if(negMax < sum) negMax = sum;
				sum=0;
			}
			maxSum = Math.max(sum, maxSum);
			if(maxSum > 0 && !isNonZeroAvailable) isNonZeroAvailable = true;
		}
		return isNonZeroAvailable ? maxSum : negMax;
	}
	
	private int findMaxSumSubArray_Practice(int[] nums) {
		int tempSum = 0;
		int maxSum = nums[0];
		int negSum = Integer.MAX_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			tempSum += nums[i];
			if(tempSum > maxSum) maxSum = tempSum;
			if(tempSum < 0) {
				if(tempSum < negSum) negSum = tempSum;
				tempSum = 0;
			}
		}
		tempSum = 0;
		for(int i=nums.length-1;i>=0;i--) {
			tempSum += nums[i];
			if(tempSum > maxSum) maxSum = tempSum;
			if(tempSum < 0) {
				if(tempSum < negSum) negSum = tempSum;
				tempSum = 0;
			}
		}
		
		return maxSum;
	}
}
