package threePointers;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class SortAnArrayWith012 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * An array nums contains only elements 0,1, and 2. Sort the given array in ascending and descending order
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
		int[] nums = {0,2,1,1,2};
		int[] output = {0,1,1,2,2};
		Assert.assertEquals(Arrays.equals(sortArray_threePointers_ascending(nums), output),true);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {0,2,1,1,2};
		int[] output = {2,2,1,1,0};
		Assert.assertEquals(Arrays.equals(sortArray_threePointers_descending(nums), output),true);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Create two for loops
	 * 2. If nums[i] greater than nums[j], swap it
	 * 3. Continue for i<nums.length
	 * 4. Return nums
	 * 
	 * -- Three Pointers - Dutch Flag - Ascending --
	 * 
	 * 1. Create left=0,middle=0 and right=nums.length-1
	 * 2. When middle==left, swap and increment left and middle
	 * 3. When middle==right, swap and decrement right
	 * 4. When middle==middle, increment right. Continue till middle<=right
	 * 5. Return nums
	 * 
	 * -- Three Pointers - Dutch Flag - Descending --
	 * 
	 * 1. Create left=0,middle and right=nums.length-1
	 * 2. When middle==high val, swap and increment left
	 * 3. When middle==low val, swap and decrement right and decrement middle
	 * 4. When middle==mid val, decrement middle. Continue till low<middle
	 * 5. Return nums
	 * 
	 */	
	
	private int[] sortArray(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	private int[] sortArray_threePointers_ascending(int[] nums) {
		int left=0,middle=0,right=nums.length-1;
		int min=0,mid=1,high=2;
		int temp=0;
		while(middle<right) {
			if(nums[middle]==min) {
				temp = nums[middle];
				nums[middle++] = nums[left];
				nums[left++] = temp;
			} else if(nums[middle]==high) {
				temp = nums[middle];
				nums[middle] = nums[right];
				nums[right--] = temp;
			} else middle++;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	private int[] sortArray_threePointers_descending(int[] nums) {
		int left=0,middle=nums.length-1,right=nums.length-1;
		int val1=2,val2=1,val3=0;
		int temp=0;
		while(left<middle) {
			if(nums[middle]==val1) {
				temp = nums[middle];
				nums[middle] = nums[left];
				nums[left++] = temp;
			} else if(nums[middle]==val3) {
				temp = nums[middle];
				nums[middle--] = nums[right];
				nums[right--] = temp;
			} else middle--;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
