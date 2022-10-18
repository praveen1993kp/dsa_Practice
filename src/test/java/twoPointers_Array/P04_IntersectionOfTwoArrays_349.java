package twoPointers_Array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P04_IntersectionOfTwoArrays_349 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode #349
	 * 
	 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
	 * Each element in the result must be unique and you may return the result in any order.
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
		int[] output = {2};
		Assert.assertArrayEquals(insersectionOfArrays(nums1,nums2), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums1 = {1,1};
		int[] nums2 = {2,2};
		int[] output = {};
		Assert.assertArrayEquals(insersectionOfArrays(nums1,nums2), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums1 = {1};
		int[] nums2 = {1,1,1,1,1,1};
		int[] output = {1};
		Assert.assertArrayEquals(insersectionOfArrays(nums1,nums2), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given arrays
	 * 2. Create an arraylist to store intersecting values
	 * 3. Create pointers left and right to 0
	 * 4. Traverse while left<nums1.length && right<nums2.length
	 * 5. When the numbers are not equal, increase the pointer of least value till it reaches a different value
	 * 6. When the numbers are equal, add it to arrayList and increase the pointers till it reaches a different value
	 * 7. Convert the arraylist into output array
	 * 8. Return the output array
	 * 
	 */	
	
	private int[] insersectionOfArrays(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length,currentVal = 0;
        ArrayList<Integer> al = new ArrayList<>();
        int left=0,right=0;
        while(left<len1 && right<len2){
            if(nums1[left] < nums2[right]){
                currentVal = nums1[left++];
                while (left<len1 && nums1[left]==currentVal) left++;
            } else if (nums2[right] < nums1[left]) {
                currentVal = nums2[right++];
                while(right<len2 && nums2[right]==currentVal) right++;
            } else{
                al.add(nums1[left]);
                currentVal = nums1[left++];
                while(left<len1 && nums1[left]==currentVal) left++;
                while(right<len2 && nums2[right]==currentVal) right++;
            }
        }
        int[] output = new int[al.size()];
        for(int i=0;i<output.length;i++){
            output[i] = al.get(i);
        }
        return output;
	}

	public void method1() {
		
	}
}
