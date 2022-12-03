package binarySearch;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class S02_SearchInsertIndex_35 {

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
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		int output = 4;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] nums = {1,3,5,6};
		int target = 2;
		int output = 1;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		int[] nums = {1,2,3,4};
		int target = 5;
		int output = 4;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}
	
	@Test
	public void edge3() {
		//Positive Test Data
		int[] nums = {1};
		int target = 4;
		int output = 1;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}

	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums = {10};
		int target = 9;
		int output = 0;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums = {9,9,9};
		int target = 1;
		int output = 0;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {1,2,3,4};
		int target = 3;
		int output = 2;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		int[] nums = {2,3,4};
		int target = 9;
		int output = 3;
		Assert.assertEquals(insertPosition_InbuiltMethod(nums,target), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse through the given array
	 * 2. If nums[i] equals target, return i
	 * 3. return -1 by default
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * 
	 * -- Binary Search --
	 * 1. Create pointers left,right and mid
	 * 2. Calculate mid as left+(right-left)/2
	 * 3. Check if the value is matching
	 * 4. If the current mid value is less than target, left = mid+1
	 * 5. If the current mid value is greater than target, right=mid-1;
	 * 
	 * Time: O(logn)
	 * Space: O(1)
	 * 
	 * -- Using Inbuilt method --
	 * 1. Get the index from Arrays.binarySearch() method
	 * 2. If the index is negative, return (-1*index)-1
	 * 3. Else, return index
	 *
	 * 
	 */	
	
	private int isTargetElementPresent(int[] nums, int target) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==target) return i;
		}
		return -1;
	}
	
	private int insertPosition(int[] nums, int target) {
		int left=0,right=nums.length-1,mid=0;
		while(left<=right) {
			mid = left+(right-left)/2;
			if(nums[mid] < target) {
				left = mid+1;
			} else if(nums[mid] > target) {
				right = mid-1;
			} else {
				return mid;
			}
		}
		return left;
	}
	
	private int insertPosition_WithoutEquals(int[] nums, int target) {
		int left=0,right=nums.length-1,mid=0;
		while(left<right) {
			mid = left+(right-left)/2;
			if(nums[mid] < target) {
				left = mid+1;
			} else if(nums[mid] > target) {
				right = mid-1;
			} else {
				return mid;
			}
		}
		return nums[left] < target ? left+1 : left;
	}
	
	private int insertPosition_InbuiltMethod(int[] nums, int target) {
		int index = Arrays.binarySearch(nums, target);
		return (index<0) ? (-1*index)-1 : index;
	}
}
