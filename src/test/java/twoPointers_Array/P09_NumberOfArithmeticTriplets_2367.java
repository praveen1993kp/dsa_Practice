package twoPointers_Array;

import org.junit.Test;

public class P09_NumberOfArithmeticTriplets_2367 {

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
		int[] nums = {0,1,4,6,7,10};
		int diff = 3;
		System.out.println(noOfTriplets_threePointers(nums,diff));
	}
	
	

	@Test
	public void positive2() {
		//Positive Case Test Data
		int[] nums = {4,5,6,7,8,9,10,11,12};
		int diff = 3;
		System.out.println(noOfTriplets_threePointers(nums,diff));
	}
	
	@Test
	public void negative1() {
		//Positive Case Test Data
		int[] nums = {0,3,22};
		int diff = 2;
		System.out.println(noOfTriplets_threePointers(nums,diff));
	}
	
	@Test
	public void positive3() {
		//Positive Case Test Data
		int[] nums = {0,1,2};
		int diff = 1;
		System.out.println(noOfTriplets_threePointers(nums,diff));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1: Two Pointer
	 * 
	 * 1. Initiate counter = 0
	 * 2. Traverse till i < nums.length
	 * 3. Create pointers left=i and right = left+1
	 * 4. Traverse till right<nums.length
	 * 5. When the difference between values at two pointers is less than diff, increment right
	 * 6. When the values are equal,
	 * 		-- If left== iReassign left and right values to previous right and right+1
	 * 		-- Else increase the counter and break the loop
	 * 7. When the difference values between right-left is greater than diff, break the loop
	 * 8. Return the counter
	 * 
	 * 
	 * Approach 2: Three Pointers
	 * 
	 * 1. Create counter = 0, pointers p1,p2,p3 to 0,1,2 respectively
	 * 2. Traverse till p2<nums.length-1 && p3<nums.length
	 * 3. If the difference between p2 and p1 is less than diff, increase p2
	 * 4. If the difference between p2 and p1 is greater than diff, increase p1
	 * 5. When equal,
	 * 		-- Assign p3 as current p2+1
	 * 		-- Traverse till p3<nums.length
	 * 		-- When the difference between p3 and p2 is equal to diff, increase the counter and break
	 * 		-- If not equal, increase p3 till nums length
	 * 6. When equal,
	 * 		-- Reassign p1 = current p1+1, p2 = p1+1 and p3 = p2+1
	 * 7. Continue steps 3-6 till p1 less than nums.length-1
	 * 8. Return the counter
	 * 
	 */	
	
	private int noOfTriplets(int[] nums, int diff) {
		int counter = 0;
        for(int i=0;i<nums.length;i++){
            int left=i,right=left+1;
            while(right<nums.length){
                if(nums[right] - nums[left] < diff) right++;
                else if (nums[right] - nums[left] == diff) {
                    if(left==i){
                        left = right;
                        right = left+1;
                    } else {
                        counter++;
                        System.out.println(i + "-" + left + "-" + right);
                        break;
                    }
                } else break;
                    
                }
            }
        return counter;
	}
	
	private int noOfTriplets_threePointers(int[] nums, int diff) {
		int counter = 0;
        int p1 = 0,p2 = 1, p3 = 2;
        while(p1<nums.length-2 && p2<nums.length-1 && p3<nums.length){
            if(nums[p2] - nums[p1] > diff) p1++;
            else if (nums[p2] - nums[p1] < diff) p2++;
            else {
            	p3 = p2+1;
                while(p3<nums.length){
                    if(nums[p3] - nums[p2] == diff) {
                        //System.out.println(p1 + "-" + p2 + "-" + p3);
                        counter++;
                        break;
                    }
                    else p3++;
                }
                p1 = p1+1;
                p2 = p1+1;
                p3 = p2+1;
            }   
        }
        return counter;
	}
}
