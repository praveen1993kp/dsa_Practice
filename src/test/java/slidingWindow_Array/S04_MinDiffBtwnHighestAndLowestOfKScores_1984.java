package slidingWindow_Array;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class S04_MinDiffBtwnHighestAndLowestOfKScores_1984 {

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
	public void edge() {
		//Edge Test Data
		int[] nums = {90};
		int k = 1;
		int output = 0;
		Assert.assertEquals(minDiffOfKScores(nums,k), output);
	}
	
	@Test
	public void positive() {
		//Positive Case Test Data
		int[] nums = {2,10,5,4,19};
		int k = 4;
		int output = 8;
		Assert.assertEquals(minDiffOfKScores(nums,k), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {5,4,3,2};
		int k = 4;
		int output = 3;
		Assert.assertEquals(minDiffOfKScores(nums,k), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create a pointer p1=k-1
	 * 2. Create variable minDiff = Integer.MAX_VALUE
	 * 3. Traverse while p1<nums.length
	 * 4. Get the min of nums[p1] and nums[p1-k+1]
	 * 5. return the min value
	 * 
	 */	
	
	private Object minDiffOfKScores(int[] nums, int k) {
		Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int p1 = k-1;
        while(p1<nums.length){
            minDiff = Math.min(minDiff,nums[p1] - nums[p1-k+1]);
            p1++;
        }
        return minDiff;
	}
}
