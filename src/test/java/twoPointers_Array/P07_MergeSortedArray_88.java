package twoPointers_Array;

import org.junit.Assert;
import org.junit.Test;

public class P07_MergeSortedArray_88 {

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
	 * 	problem?  - 
	 * 		-- Non-Decreasing order
	 * 		-- Should be added into nums1 in non-decreasing order
	 * 		-- 
	 * Do I have all the information to go to the next steps 
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
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6,};
		int m = 3;
		int n = 3;
		int[] output = {1,2,2,3,5,6};
		Assert.assertArrayEquals(mergedSortedArray_method3(nums1,nums2,m,n), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums1 = {0};
		int[] nums2 = {};
		int m = 1;
		int n = 0;
		int[] output = {0};
		Assert.assertArrayEquals(mergedSortedArray_method3(nums1,nums2,m,n), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums1 = {0};
		int[] nums2 = {1};
		int m = 0;
		int n = 1;
		int[] output = {1};
		Assert.assertArrayEquals(mergedSortedArray_method3(nums1,nums2,m,n), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums1 = {0,0,0,0,0,0};
		int[] nums2 = {0,0};
		int m = 4;
		int n = 2;
		int[] output = {0,0,0,0,0,0};
		Assert.assertArrayEquals(mergedSortedArray_method3(nums1,nums2,m,n), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		int[] nums1 = {0,1,2,0,0,0};
		int[] nums2 = {-3,-2,-1};
		int m = 3;
		int n = 3;
		int[] output = {-3,-2,-1,0,1,2};
		Assert.assertArrayEquals(mergedSortedArray_method3(nums1,nums2,m,n), output);
	}

	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left = m-1 and right = n-1
	 * 2. Create insertIndex = m+n-1
	 * 3. Traverse while left >=0 or right>=0
	 * 4. Add the greater number to index and decrement pointer and index
	 * 5. When equal, add one of the values to index and decrement respective pointer and index
	 * 6. When any of the pointer goes below 0, add the values of other pointer into array at index
	 * 7. Return nums1
	 * 
	 * 
	 * --- Pseudo code_Method2 ---
	 * 
	 * 1. Create pointers left=m-1, right = n-1 and insertIndex = m+n-1
	 * 2. Traverse while right>=0 (left>=0 won't have impact if right>=0
	 * 3. If left>=0 and value in left > value in right, add into insertIndex and decrement left
	 * 4. Else add nums from right and decrement right
	 * 5. Decrement insertIndex by default
	 * 6. Return nums1
	 */	
	
	
	private int[] mergedSortedArray(int[] nums1, int[] nums2, int m, int n) {
		int left=m-1,right=n-1,insertIndex=m+n-1;
		while(left>=0 || right>=0) {
			if(left < 0) nums1[insertIndex] = nums2[right--];
			else if (right< 0) nums1[insertIndex] = nums1[left--];
			else {
				if(nums1[left] <= nums2[right]) {
					nums1[insertIndex] = nums2[right--];
				} else nums1[insertIndex] = nums1[left--];
			}
			insertIndex--;	
		}
		return nums1;
	}
	
	private int[] mergedSortedArray_method2(int[] nums1, int[] nums2, int m, int n) {
		int left=m-1,right=n-1,insertIndex = nums1.length-1;
		while(right>=0) {
			if(left>=0 && nums1[left] > nums2[right]) 
				nums1[insertIndex] = nums1[left--];
			else nums1[insertIndex] = nums2[right--];
			insertIndex--;
		}
		return nums1;
	}
	
	private int[] mergedSortedArray_method3(int[] nums1, int[] nums2, int m, int n) {
		int left = m-1, right= n-1, newindex = nums1.length-1;
		
		while(left>=0 || right>=0) {
			if(right>=0 && left>=0) {
				if(nums1[left] <= nums2[right]) {
					nums1[newindex--] = nums2[right--];
				} else {
					nums1[newindex--] = nums1[left--];
				}
			}	
			if(right<0) nums1[newindex--] = nums1[left--];
			else if(left < 0) nums1[newindex--] = nums2[right--];
				
		} return nums1;
				
	}

}
	
	
	

