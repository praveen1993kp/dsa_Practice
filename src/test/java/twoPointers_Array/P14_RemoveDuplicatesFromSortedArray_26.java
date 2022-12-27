package twoPointers_Array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class P14_RemoveDuplicatesFromSortedArray_26 {

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
	public void positive1() {
		//Positive Test Data
		int[] nums = {1,1,2};
		int output = 2;
		Assert.assertEquals(output, removeDuplicates_TwoPointer(nums));
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int output = 5;
		Assert.assertEquals(output, removeDuplicates_TwoPointer(nums));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,1,1,1,1};
		int output = 1;
		Assert.assertEquals(output, removeDuplicates_TwoPointer(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3,4,5};
		int output = 5;
		Assert.assertEquals(output, removeDuplicates_TwoPointer(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force:
	 * 
	 * 1. Create list
	 * 2. Add integers into list when not already available
	 * 3. Traverse through list elements and add into nums[i] again
	 * 4. return the size of list	
	 * 
	 * Two Pointer:
	 * 
	 * 1. Create left=0,right=1
	 * 2. When nums[left] and nums[right] are same, left++ and traverse right while nums[right]==nums[left]
     * 3. Place nums[right] value into nums[left]. Increment right
	 * 4. When right crosses length of array, return left+1
	 * 
	 */	
	
	public int removeDuplicates(int[] nums) {
	       List<Integer> withoutDuplicates = new ArrayList<>();
	       for(int i=0;i<nums.length;i++){
	           if(!withoutDuplicates.contains(nums[i])) withoutDuplicates.add(nums[i]);
	       }
	       
	       for(int i=0;i<withoutDuplicates.size();i++){
	           nums[i] = withoutDuplicates.get(i);
	       }
	       
	       return withoutDuplicates.size();   
	}
	
	public int removeDuplicates_TwoPointer(int[] nums) {
	    int left=0,right=1;
	    while(right<nums.length) {
	    	if(nums[left] != nums[right]) {
	    		left++;
	    		nums[left] = nums[right];
	    	}
	    	right++;
	    }
	    return left+1;
		
	}
}
