package twoPointers_Array;

import org.junit.Assert;
import org.junit.Test;

public class P10_DuplicateZeroes_1089 {

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
		int[] arr = {1,0,2,3,0,4,5,0};
		int[] output = {1,0,0,2,3,0,0,4};
		Assert.assertArrayEquals(duplicateZeroes(arr), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] arr = {0,0,0,0};
		int[] output = {0,0,0,0};
		Assert.assertArrayEquals(duplicateZeroes(arr), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] arr = {1,2,3,4,5};
		int[] output = {1,2,3,4,5};
		Assert.assertArrayEquals(duplicateZeroes(arr), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		int[] arr = {0,1,0,2,0,3,0,4,5};
		int[] output = {0,0,1,0,0,2,0,0,3};
		Assert.assertArrayEquals(duplicateZeroes(arr), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create pointers left=0 and right=arr.length-1
	 * 2. If left==0, add values of right-1 to right and continue till right>left+1. Else, increment left
	 * 3. Assign left+1 to 0
	 * 4. Re-assign right=arr.length-1
	 * 5. Return arr
	 * 
	 */	
	
	private int[] duplicateZeroes(int[] arr) {
		int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]==0){
                while(right>left+1){
                    arr[right] = arr[right-1];
                    right--;
                }
                arr[left+1] = 0;
                left=left+2;
                right=arr.length-1;
            } else left++;
        }
		return arr;
	}

	
}
