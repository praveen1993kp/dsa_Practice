package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P08_MajorityElement_169 {

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
		int[] nums = {3,2,3};
		int output = 3;
		Assert.assertEquals(majorityElement_bruteForce(nums), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] nums = {2,2,1,1,1,2,2};
		int output = 2;
		Assert.assertEquals(majorityElement_bruteForce(nums), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums = {3};
		int output = 3;
		Assert.assertEquals(majorityElement_bruteForce(nums), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {1,1,1,1,1};
		int output = 1;
		Assert.assertEquals(majorityElement_bruteForce(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Sort the array
	 * 2. Return nums[n/2] element
	 * 
	 * -- Brute Force 2 --
	 * 
	 * 1. Create two for loops
	 * 2. Inside first loop, initiate a counter = 0
	 * 3. For each element in second loop, if the value matches first loop element, increment the counter
	 * 4. At the end of inner loop, check if the counter value > n/2. If so, return the element.
	 * 
	 * -- Using HashMap --
	 * 1. Create a hashMap
	 * 2. Add the numbers and its occurrences into hashMap
	 * 3. When the occurrence crosses n/2, return it
	 * 
	 * 
	 */	
	
	private int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	private int majorityElement_bruteForce(int[] nums) {
		int counter=0;
		for(int i=0;i<nums.length;i++) {
			counter = 0;
			for(int j=0;j<nums.length;j++) {
				if(nums[i]==nums[j]) counter++;
			}
			if(counter>nums.length/2) return nums[i];
		}
		return 0;
	}
	
	private int majorityElement_hashMap(int[] nums) {
		Map<Integer,Integer> hMap = new HashMap<>();
		int maxVal = 0;
		for(int i=0;i<nums.length;i++) {
			hMap.put(nums[i], hMap.getOrDefault(nums[i], 0)+1);
			if(hMap.get(nums[i]) > nums.length/2) {
				maxVal = nums[i];
				break;
			}
		}
		return maxVal;
	}
}
