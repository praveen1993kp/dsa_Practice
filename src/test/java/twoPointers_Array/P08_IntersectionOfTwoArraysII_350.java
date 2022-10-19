package twoPointers_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P08_IntersectionOfTwoArraysII_350 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode #350
	 * 
	 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
	 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
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
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] output = {2,2};
		Assert.assertArrayEquals(insersectionOfArraysII(nums1,nums2), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums1 = {1,1};
		int[] nums2 = {2,2};
		int[] output = {};
		Assert.assertArrayEquals(insersectionOfArraysII(nums1,nums2), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums1 = {1};
		int[] nums2 = {1,1,1,1,1,1};
		int[] output = {1};
		Assert.assertArrayEquals(insersectionOfArraysII(nums1,nums2), output);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums1 = {4,9,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] output = {4,9,9};
		Assert.assertArrayEquals(insersectionOfArraysII(nums1,nums2), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given arrays
	 * 2. Create an arraylist to store intersecting values
	 * 3. Create pointers left and right to 0
	 * 4. Traverse while left<nums1.length && right<nums2.length
	 * 5. When the numbers are not equal, increase the least value pointer to next value
	 * 6. When the numbers are equal, add it to arrayList and increase both pointers
	 * 7. Convert the arraylist into output array
	 * 8. Return the output array
	 * 
	 */	
	
	private int[] insersectionOfArraysII(int[] nums1, int[] nums2) {
		if(nums1.length==0 || nums2.length==0) return new int[0];
		Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> al = new ArrayList<>();
        int left=0,right=0;
        while(left<nums1.length && right<nums2.length){
        	if(nums2[right] < nums1[left]) right++;
        	else {
        		if(nums1[left] == nums2[right]) {
        			al.add(nums1[left]);
        			right++;
        		}		
        		left++;
        	}
        }
        int[] output = new int[al.size()];
        Iterator<Integer> itr = al.iterator();
        int i=0;
        while(itr.hasNext()) {
        	output[i++] = itr.next();
        }
        return output;
	}
}
