package twoPointers_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P06_CheckIfDoubleExist_1346 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Given an array arr of integers, check if there exist two indices i and j such that :

		i != j
		0 <= i, j < arr.length
		arr[i] == 2 * arr[j]
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
		int[] nums = {10,5,2,3};
		boolean output = true;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums = {-1,-1};
		boolean output = false;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {2,3};
		boolean output = false;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		int[] nums = {-19,-16};
		boolean output = false;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void negative3() {
		//Negative Test Data
		int[] nums = {10,5,5,5};
		boolean output = true;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void negative4() {
		//Negative Test Data
		int[] nums = {5,5,5,5};
		boolean output = false;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void negative5() {
		//Negative Test Data
		int[] nums = {-10,12,-20,-8,15};
		boolean output = true;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void edge3() {
		//edge Test Data
		int[] nums = {-2,0,10,-19,4,6,-8};
		boolean output = false;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	@Test
	public void edge4() {
		//edge Test Data
		int[] nums = {0,0};
		boolean output = true;
		Assert.assertEquals(checkIfDoubleExist_UsingSet(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create two pointers p1=0 and p2 = 1
	 * 2. When both numbers are not zero 
	 * 		and nums[p2] is twice or half of nums[p1] return true
	 * 3. If nums[p2] < twice nums[p1] increment p2
	 * 4. else if nums[p2] > twice nums[p1] increment p1
	 * 5. When both the numbers are 0, return true
	 * 6. When either of the numbers are 0, increment the respective pointer
	 * 7. Return false by default
	 * 
	 * -- Approach2 : Using Set --
	 * 1. Create Set of Integers
	 * 2. Traverse through the given element
	 * 3. When the set contains twice of current element, return true
	 * 4. If the current element is even and set contains half of current element, return true
	 * 5. Add current element into set
	 * 6. Return false by default
	 * 
	 */	
	
	//Time Complexity O(N logn)
	private boolean checkIfDoubleExist(int[] nums) {
		Arrays.sort(nums);
        int p1=0,p2=1;
        while(p1<nums.length && p2<nums.length){
        	if(nums[p1]!=0 && nums[p2]!=0) {
        		if((nums[p2] * 2 == nums[p1]) || (nums[p2] == 2 * nums[p1])) 
            		return true;
            	else {
            		if(nums[p2] < 2*nums[p1]) p2++;
                    else if (nums[p2] > 2*nums[p1]) p1++;
            	} 
        	} else {
        		if (nums[p1]==0 && nums[p2]==0) return true;
        		else if (nums[p1]==0) p1++;
        		else p2++;
        	}
        }
        return false;
	}
	
	//Time Complexity - O(n)
	private boolean checkIfDoubleExist_UsingSet(int[] nums) {
		Set<Integer> hSet = new HashSet<>();   
		for(int i=0;i<nums.length;i++) {       
			if(hSet.contains(nums[i] * 2) || (nums[i]%2==0 && hSet.contains(nums[i]/2)))
					return true;
			hSet.add(nums[i]);
		}
		return false;
	}
}
