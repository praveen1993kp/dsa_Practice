package kandaneAlgorithm;

import org.junit.Test;

import junit.framework.Assert;

public class P01_MaximumProductSubArray_152 {

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
		int[] nums = {2,3,5,-1,3,5,7};
		int output = 105;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {2,3,-2,4};
		int output = 6;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {-2};
		int output = -2;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {0,-2,-3};
		int output = 6;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		int[] nums = {Integer.MAX_VALUE/2-1,2};
		int output = Integer.MAX_VALUE-3;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		int[] nums = {0,2,3,4};
		int output = 24;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example7() {
		//Negative Test Data
		int[] nums = {0,2};
		int output = 2;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example8() {
		//Negative Test Data
		int[] nums = {-2,0,-1};
		int output = 0;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	@Test
	public void example9() {
		//Negative Test Data
		int[] nums = {-2,0};
		int output = 0;
		Assert.assertEquals(maxProduct_Kandane(nums), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. 1. Create two loops
	 * 2. Assign prod = nums[0]
	 * 3. When the consecutive prod is greater than maxProd, assign current prod value to it
	 * 4. If the current product is less than maxProd, break the inner loop
	 * 5. Return maxProd
	 * 
	 * Sliding Window:
	 * 
	 * 1. Create prod=1, maxProd = nums[0];
	 * 2. Create pointers left=0 and right =0
	 * 3. Traverse for right<nums.length
	 * 4. If the value from right is 0, 
	 * 		-- If the maxProd calculated before that is less than 0, replace 0 as maxProd
	 * 		-- Increment left, make right=left and prod = 1
	 * 5. If the nums from right is not 0, multiple the values and calculate maxProd
	 * 6. Increment right
	 * 7. If right reaches nums length, reset left right and prod
	 * 
	 * -- Kandane solution --
	 * 
	 * 1. Create variables prod=1 and maxProd = nums[0]
	 * 2. Traverse through the array in forward direction
	 * 3. Multiply the prod value with nums[i]
	 * 4. If maxProd < prod, assign prod to maxProd (As per Kandane)
	 * 5. If prod equals 0, reset prod to 1 ( As per Kandane)
	 * 6. Repeat steps 2 to 5, but starting from the end of nums array (To handle single negative values)
	 * 7. Return the maxProd value
	 * 
	 */	
	
	private int maxProduct(int[] nums) {
		int maxProd = nums[0];
		for(int i=0;i<nums.length;i++) {
			int prod = 1;
			for(int j=i;j<nums.length;j++) {
				prod *= nums[j];
				if(prod>maxProd) maxProd = prod;
			}
		}
		return maxProd;
	}
	
	private int maxProduct_slidingWindow(int[] nums) {
		int prod=1,maxProd = nums[0];
		int left=0,right=0;
		while(right<nums.length) {
			if(nums[right]==0) {
				if(maxProd<0) maxProd = 0;
				left++;
				right=left;
				prod = 1;
			}else {
				prod *= nums[right];
				maxProd = Math.max(maxProd, prod);
				right++;
			}
			
			if(right==nums.length) {
				left++;
				right=left;
				prod=1;
			}
		}
		return maxProd;
	}
	
	private int maxProduct_Kandane(int[] nums) {
		int prod = 1;
		int maxProd = nums[0];
		for(int i=0;i<nums.length;i++) {
			prod *= nums[i];
			if(maxProd < prod) maxProd = prod;
			if(prod==0) prod = 1;
		}
		prod = 1;
		for(int j=nums.length-1;j>=0;j--) {
			prod *= nums[j];
			if(maxProd < prod) maxProd = prod;
			if(prod==0) prod = 1;
		}
		return maxProd;
	}
}
