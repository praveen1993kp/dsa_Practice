package slidingWindow_Array;

import org.junit.Test;

import junit.framework.Assert;

public class S01_MaxSumOfKConsecutiveElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an array of integers and a number k.
	 * Return the highest sum of any k consecutive elements in the array
	 * 
	 * Target = k
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
		int[] nums = {1,5,2,3,7,1};
		int k = 3;
		int output = 12;
		Assert.assertEquals(twoPointer(nums,k), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3};
		int k = 4;
		int output = 0;
		Assert.assertEquals(twoPointer(nums,k), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {0,0,0};
		int k = 3;
		int output = 0;
		Assert.assertEquals(twoPointer(nums,k), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * Before: Create tempSum, sum and i
	 * 1. Traverse for the length of nums, assign tempSum to 0
	 * 2. Start a while loop for meeting k. 
	 * 3. When k<0 stop the loop and get the maximum out of tempSum and sum
	 * 4. Return sum
	 * 
	 * Two Pointer
	 * 
	 * 1. Create two pointers left=0 and right = 1
	 * 2. Traverse through the given array
	 * 3. If right-left == k-1, assign left = right and right = left+1
	 * 4. Add sum till above condition is met
	 * 5. Get the maximum of tempsum and sum
	 * 
	 */	
	
	private int kConsecutiveSum(int[] nums, int k) {
		int sum=Integer.MIN_VALUE,tempSum=0;
		if(nums.length < k) return tempSum;
		for(int i=0;i<nums.length;i++) {
			tempSum=0;
			for(int j=i;j<nums.length && j<i+k;j++) {
				tempSum += nums[j];
			}
			sum = Math.max(tempSum, sum);
		}	
		return sum;
	}
	
	private int twoPointer(int[] nums, int k) {
		int sum=Integer.MIN_VALUE,tempSum=0;
		if(nums.length < k) return tempSum;
		int left=0,right=0;
		while(right<k) {
			tempSum += nums[right++];
		}
		System.out.println(tempSum);
		sum = tempSum;
		while(right<nums.length) {
			tempSum += nums[right++] - nums[left++];
			sum = Math.max(tempSum, sum);
		}
		return sum;
	}
}
