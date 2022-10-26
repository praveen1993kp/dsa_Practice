package slidingWindow_Array;

import org.junit.Test;

import junit.framework.Assert;

public class P03_MaximumConsecutiveOnesIII_1004 {

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
	public void positive() {
		//Positive Test Data
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k=2;
		int output = 6;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k=3;
		int output = 10;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		int[] nums = {0,0,0,0,0,0,0};
		int k=3;
		int output = 3;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void positive4() {
		//Positive Test Data
		int[] nums = {1,0,1,1,0,0,0,1,1};
		int k=3;
		int output = 7;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		int[] nums = {1};
		int k=1;
		int output = 1;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums = {0};
		int k=0;
		int output = 0;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] nums = {0};
		int k=1;
		int output = 1;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void edge4() {
		//Negative Test Data
		int[] nums = {0,0,1,1,1,0,0};
		int k=0;
		int output = 3;
		Assert.assertEquals(maxConsecutiveOnes(nums,k), output);
	}
	
	@Test
	public void negative1() {
		//Negative Test Data
		int[] nums = {1,1,1,1,1,1,1,1};
		int k=4;
		int output = 8;
		Assert.assertEquals(maxConsecutiveOnes_twoPointer(nums,k), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k=0;
		int output = 4;
		Assert.assertEquals(maxConsecutiveOnes(nums,k), output);
	}
	
	
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse using a for loop for elements till nums.length
	 * 2. Create an inner loop while k>=0
	 * 3. When k is greater than or equal to zero 
	 *	3a. When current value is 1, skip to next
	 *	3b. When current value is 0, skip to next and decrement k
	 * 4. Get the maximum length
	 * 5. Return the length
	 * 
	 * Sliding Window:
	 * 
	 * 1. Create pointers left=0 and right=0
	 * 2. Traverse for right<nums.length
	 * 3. When nums[right] is 0, decrement k
	 * 4. When k<0, increment k if nums[left] is also 0. increment left
	 * 5. Get the maxLength
	 * 6. Increment right
	 * 7. return maxLength
	 * 
	 */	
	
	private int maxConsecutiveOnes(int[] nums, int k) {
		int maxLength = Integer.MIN_VALUE;
		int tempK = 0, j=0;
		for(int i=0;i<nums.length;i++) {
			tempK = k;
			for(j=i;j<nums.length;j++) {
				if(nums[j] == 0) {
					if(tempK>0) {		
						tempK--;
					} else break;
				}	
				if(maxLength<j-i+1) maxLength = j-i+1;	
				
			}	
			
			System.out.println(maxLength);
		}
		
		return maxLength==Integer.MIN_VALUE ? 0 : maxLength;
	}
	
	private int maxConsecutiveOnes_twoPointer(int[] nums, int k) {
		int maxLength = 0;
		int left=0,right=0;
		while(right<nums.length) {
			if(nums[right]==0) 
				k--; 
			
			if(k<0) {
				if(nums[left]==0) k++;
				left++;
			}
			maxLength = Math.max(maxLength, right-left+1);
			right++;
			System.out.println(maxLength);
		}
		return maxLength;
	}

}
