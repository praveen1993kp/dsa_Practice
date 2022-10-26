package slidingWindow_Array;

import org.junit.Test;

import junit.framework.Assert;

public class P02_SubArrayProductLessthanK_713 {

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
	public void example1() {
		//Positive Test Data
		int[] nums = {10,5,2,6};
		int k = 100;
		int output = 8;
		Assert.assertEquals(SubArrayProductLessThanK(nums,k), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {10,5,2,6};
		int k = 100;
		int output = 8;
		Assert.assertEquals(SubArrayProductLessThanK(nums,k), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {10,5,2,6};
		int k = 100;
		int output = 8;
		Assert.assertEquals(SubArrayProductLessThanK(nums,k), output);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
		int k = 19;
		int output = 18;
		Assert.assertEquals(SubArrayProductLessThanK(nums,k), output);
	}
	
	private int SubArrayProductLessThanK_2(int[] nums, int k) {
		int counter=0,left=0,right=0,prod =1 ;
		/*
		 * for(int i=0;i<nums.length;i++){ if(nums[i] < k) counter++; }
		 */
        //System.out.println(counter);
        while(right<nums.length){
                prod *= nums[right];
                if(right<nums.length && prod<k) {
                    right++;
                    counter++;
                } else {
                    left++;
                    right=left;
                    prod = 1;
                }
            }
       return counter; 
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left=0 and right=0
	 * 2. Create variables counter=0 and prod = 1
	 * 3. Traverse while right<nums.length
	 * 4. Find the product
	 * 5. While product>=k, divide the value with nums[left] and increment left
	 * 6. By default, find the counter value as counter += right-left+1;
	 * 7. Increment right
	 * 7. 
	 * 
	 */	
	
	private int SubArrayProductLessThanK(int[] nums, int k) {
		int counter=0,left=0,right=0,prod =1 ;
        while(right<nums.length){
                prod *= nums[right];
                while(prod >= k){
                    prod /= nums[left];
                    left++;
                }
                counter += right-left+1;
                right++;
            }
       return counter;
	}
	
}
