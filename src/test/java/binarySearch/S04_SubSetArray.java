package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class S04_SubSetArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. 
	 * Both the arrays are not in sorted order. 
	 * It may be assumed that elements in both arrays are distinct.
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
		int[] arr1 = {11,1,13,21,3,7};
		int[] arr2 = {11,3,7,1};
		Assert.assertEquals(subSequence(arr1,arr2), true);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] arr1 = {10,5,2,23,19};
		int[] arr2 = {19,5,3};
		Assert.assertEquals(subSequence(arr1,arr2), false);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] arr1 = {10,5,2,23,19};
		int[] arr2 = {50};
		Assert.assertEquals(subSequence(arr1,arr2), false);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		int[] arr1 = {10};
		int[] arr2 = {50,30,10};
		Assert.assertEquals(subSequence(arr1,arr2), false);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * Pseudo code:
	 * Edge case: If the length of arr1 is less than arr2 length, return false
	 * 1. Create hashSet and add arr1 values into it
	 * 2. If the arr2 values are able to be added, return false
	 * 3. return true by default
	 *
	 * Time : O(n)
	 * Space : O(n)
	 *
	 * -- Binary Search --
	 * 1. Edge case: If the length of arr1 is less than arr2 length, return false
	 * 2. Sort both the input arrays
	 * 3. Traverse through arr2. Using Arrays.binarySearch method, check if each value in arr2 is available in arr1
	 * 4. If any of the value returns value less than 0, return false (Meaning the value not available in the array and hence returning -(insertIndex)-1
	 * 5. return true by default
	 * 
	 */	
	
	public boolean subSequence(int[] arr1, int[] arr2){
		if(arr1.length < arr2.length) return false;
		Set<Integer> hSet = new HashSet<>();
		for(int i : arr1){
			hSet.add(i);
		}
		
		for(int i : arr2) {
			if(hSet.add(i)) return false;
		}
		
		return true;
	}
	
	public boolean subSequence_BinarySearch(int[] arr1, int[] arr2){
		if(arr1.length < arr2.length) return false;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for(int i : arr2) {
			if(Arrays.binarySearch(arr1, i) < 0) return false;
		}
		return true;
	}
	
	
}
