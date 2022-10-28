package slidingWindow_Array;

import org.junit.Test;

import junit.framework.Assert;

public class P05_LongestSubArrayOf1sAfterDeletingOneElement_1493 {

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
		int output = 4;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int output = 5;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		int[] nums = {0,0,0,0,0,0,0};
		int output = 0;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	@Test
	public void positive4() {
		//Positive Test Data
		int[] nums = {1,0,1,1,0,0,0,1,1};
		int output = 3;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		int[] nums = {1};
		int output = 0;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] nums = {0};
		int output = 0;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	@Test
	public void edge4() {
		//Negative Test Data
		int[] nums = {0,0,1,1,1,0,0};
		int output = 3;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	@Test
	public void negative1() {
		//Negative Test Data
		int[] nums = {1,1,1,1,1,1,1,1};
		int output = 7;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int output = 4;
		Assert.assertEquals(longestSubarray_bruteForce(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * Create variables currentVal=0, maxVal=Integer.Min_VALUE
	 * 1. Create two loops. 
	 * 2. Inside the first loop, assign k=1
	 * 3. For every j value, if nums[j]==0
	 * 		-- If k>0, then decrement k and proceed
	 * 		-- Else, calculate currentVal = j-i and proceed
	 * 4. Outside the inner loop, calculate the max between maxVal and currentVal
	 * 5. Return maxVal after traversing is completed
	 * 
	 * -- Sliding Window --
	 * 
	 * 1. Create two pointers left=0 and right = 0. Create variable maxVal = Integer.MIN_VALUE & k=1.
	 * 2. Traverse while right<nums.lenggh
	 * 3. If nums[right]==0 and k>0, decrement k
	 * 4. Else increment left while k>0
	 * 5. Calculate the max between right-left and maxVal. Increment right by default
	 * 6. Return maxVal
	 * 
	 */	
	
	private int longestSubarray_bruteForce(int[] nums) {
		int maxVal = Integer.MIN_VALUE;
		int k=0;
		for(int i=0;i<nums.length;i++) {
			k=1;
			for(int j=i;j<nums.length;j++) {
				if(nums[j]==0) {
					if(k>0) {
						k--;
					}else {
						break;
					}		
				}
				maxVal = Math.max(j-i, maxVal);
			}
			
		}
		return maxVal;
	}
	
	private int longestSubarray_twoPointers(int[] nums) {
		int maxLength = 0;
		int left=0,right=0;
        int k=1;
		while(right<nums.length) {
			if(nums[right]==0) 
				k--; 
			
			if(k<0){
                if(nums[left]==0) k++;
                left++;
            }
			maxLength = Math.max(maxLength,right-left);
            right++;			
		}
		 return maxLength;
	}
	
	
}
