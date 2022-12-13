package binarySearch;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P01_FindFirstAndLastIndexOfElementInASortedArray_34 {

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
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int[] output = {3,4};
		Assert.assertTrue(Arrays.equals(findIndices(nums,target), output));
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums = {2,2,2,2,2};
		int target = 2;
		int[] output = {0,4};
		Assert.assertTrue(Arrays.equals(findIndices(nums,target), output));
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums = {};
		int target = 8;
		int[] output = {-1,-1};
		Assert.assertTrue(Arrays.equals(findIndices(nums,target), output));
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {2};
		int target = 2;
		int[] output = {0,0};
		Assert.assertTrue(Arrays.equals(findIndices(nums,target), output));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * //Pseudo code
     * When input is empty, I will return -1,-1
     * If length is 1, and target != nums[0] return -1,-1
     * If length is 1 and target==nums[0] return 0,0
     * Traverse through the given array
     * Calculate mid for each instance
     * When value at mid is smaller than target, reassign left to mid+1
     * else decrement right
     * When mid is found, use left and right to find starting and ending indices
	 * 
	 */	
	
	public int[] findIndices(int[] nums, int target) {
        int[] output = {-1,-1};
        if(nums.length==0) return output;
        if(nums.length==1){
            if(nums[0]==target) {
                output[0] = 0;
                output[1] = 0;
            }
            return output;
        }
        int left=0,right=nums.length-1;
        int mid=0;
        
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]==target) {
                while(nums[left] != target) left++;
                while(nums[right] != target) right--;
                output[0] = left;
                output[1] = right;
                break;
            }else if (nums[mid] < target){
                left = mid+1;
            } else right = mid-1;
        }
        return output;
    }
}
