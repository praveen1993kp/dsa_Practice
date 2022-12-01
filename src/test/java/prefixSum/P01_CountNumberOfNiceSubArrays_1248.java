package prefixSum;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P01_CountNumberOfNiceSubArrays_1248 {

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
		int[] nums = {1,1,2,1,1};
		int k = 3;
		int output = 2;
		Assert.assertEquals(noOfNicesubArrays(nums,k), output);
	}
	
	@Test
	public void negative() {
		//Negative Case Test Data
		int[] nums = {2,4,6};
		int k = 1;
		int output = 0;
		Assert.assertEquals(noOfNicesubArrays(nums,k), output);
	}
	
	@Test
	public void edge() {
		//Edge Test Data
		int[] nums = {1,2,3,4,5};
		int k = 3;
		int output = 1;
		Assert.assertEquals(noOfNicesubArrays(nums,k), output);
	}
	
	@Test
	public void edge2() {
		//Edge Test Data
		int[] nums = {2,2,2,1,2,2,1,2,2,2};
		int k = 2;
		int output = 16;
		Assert.assertEquals(noOfNicesubArrays(nums,k), output);
	}

	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create variables currentSum and count = 0
	 * 2. Create a hashMap
	 * 3. Add key 0 and value 1 into hashMap
	 * 4. Traverse through the elements of input array
	 * 5. If the current number is odd, add 1 to currentsum and if even, add 0 to currentSum
	 * 6. Check if hashMap contains currentSum-k key
	 * 		-- If contains, add count with the value of said key
	 * 7. Add currentsum and update the value accordingly
	 * 8. Return the count
	 * 
	 */	
	
	private int noOfNicesubArrays(int[] nums, int k) {
		int currentSum = 0;
        int count = 0;
        Map<Integer,Integer> hMap = new HashMap<>();
        hMap.put(0,1);
        
        for(int i=0;i<nums.length;i++){
            currentSum += nums[i]%2;
            if(hMap.containsKey(currentSum-k)) 
                count += hMap.get(currentSum-k);
            hMap.put(currentSum,hMap.getOrDefault(currentSum,0)+1);
        }
        return count;
	}
}
