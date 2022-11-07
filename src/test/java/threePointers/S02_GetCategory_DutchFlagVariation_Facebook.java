package threePointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class S02_GetCategory_DutchFlagVariation_Facebook {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * https://leetcode.com/discuss/interview-question/algorithms/124623/facebook-onsite-variation-of-dutch-national-flag-problem
	 * 
	 * You have an unsorted array of integers and a function
	string getCategory(integer), which deterministically returns 1 of three possible strings: 
	"low", "medium", or "high", depending on the input integer. You need to output an array with all the "low" numbers at the bottom, all the "medium" numbers in the middle, and all the "high" numbers at the top. This is basically a partial sort. Within each category, the order of the numbers does not matter.

    For example, you might be give the array [5,7,2,9,1,14,12,10,5,3].
    For input integers 1 - 3, getCategory(integer) returns "low", 
    for 4 - 10 it returns "medium," and 
    for 11 - 15 it returns "high".

	You could output an array (or modify the given array) that looks like this: [3,1,2,5,5,9,7,10,14,12]
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
		int[] input = {5,7,2,9,1,14,12,10,5,3};
		int[] output = {2,1,3,9,7,5,5,10,12,14};
		Assert.assertTrue(Arrays.equals(sortBasedOnCategory_DutchFlag(input),output));
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] input = {5,5,5,5,5};
		int[] output = {5,5,5,5,5};
		Assert.assertTrue(Arrays.equals(sortBasedOnCategory_DutchFlag(input),output));
	}
	
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] input = {3,2,1,3,2};
		int[] output = {3,2,1,3,2};
		Assert.assertTrue(Arrays.equals(sortBasedOnCategory_DutchFlag(input),output));
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] input = {11,12,11,14,11};
		int[] output = {12,11,14,11,11};
		Assert.assertTrue(Arrays.equals(sortBasedOnCategory_DutchFlag(input),output));
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] input = {3,2,1,5,5,5};
		int[] output = {3,2,1,5,5,5};
		Assert.assertTrue(Arrays.equals(sortBasedOnCategory_DutchFlag(input),output));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Sort the given array - That will keep the elements based on category
	 * 
	 * -- Using Ascii -0
	 * 1. Create an ascii array of size 15 and output array of size nums.length
	 * 2. Traverse through nums and add relevant values into ascii
	 * 3. Traverse through ascii and add values into output array
	 * 
	 * -- Using Dutch Flag Algorithm --
	 * 1. Create pointers low =0, medium=0 and high=nums.length-1
	 * 2. Traverse while middle<high
	 * 3. If nums[middle] value is less than 4, swap with nums[low] and increment both
	 * 4. If nums[middle] value is greater than 10, swap with nums[high] and decrement right
	 * 5. If nums[middle] lies between 4 and 10, increment middle
	 * 
	 * 
	 */	
	
	private int[] sortBasedOnCategory(int[] nums) {
		Arrays.sort(nums);
		return nums;
	}

	private int[] sortBasedOnCategory_Ascii(int[] nums){
		int[] ascii = new int[15];
		int[] output = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			ascii[i]++;
		}
		int index=0;
		for(int i=0;i<ascii.length;i++){
			if(ascii[i]!=0) {
				for(int j=0;j<ascii[j];j++){
					output[index++] = ascii[i];
				}
			}
		}
		
	return output;	
	}
	
	private int[] sortBasedOnCategory_DutchFlag(int[] nums){
		int low=0,middle=0,high=nums.length-1;
		while(middle<high) {
			if(nums[middle]<=3) {
				int temp = nums[low];
				nums[low++] = nums[middle];
				nums[middle++] = temp;
			} else if (nums[middle]>=11) {
				int temp = nums[high];
				nums[high--] = nums[middle];
				nums[middle] = temp;
			} else middle++;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	
}
