package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P09_ContainsDuplicateII_219 {

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
		int[] nums = {1,2,3,1};
		int k = 3;
		boolean output = true;
		Assert.assertEquals(containsDuplicate_hashMap(nums,k),output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] nums = {1,1,3,2};
		int k = 3;
		boolean output = true;
		Assert.assertEquals(containsDuplicate_hashMap(nums,k),output);
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		int[] nums = {1,0,1,1};
		int k = 1;
		boolean output = true;
		Assert.assertEquals(containsDuplicate_hashMap(nums,k),output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,1,2,1};
		int k = 4;
		boolean output = true;
		Assert.assertEquals(containsDuplicate_hashMap(nums,k),output);
	}
	
	@Test
	public void negative1() {
		//Negative Test Data
		int[] nums = {1,2,3,4};
		int k = 3;
		boolean output = false;
		Assert.assertEquals(containsDuplicate_hashMap(nums,k),output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		int[] nums = {1,2,3,1,2,3};
		int k = 2;
		boolean output = false;
		Assert.assertEquals(containsDuplicate_hashMap(nums,k),output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse through the given array
	 * 2. Create inner loop from i+1 till i+k
	 * 3. If the current i value is found, return true
	 * 4. return false by default
	 * 
	 * -- HashMap --
	 * 
	 * 1. If the element not available, add in hashmap
	 * 2. If available, check the index
	 * 3. If current index - prev Index <=3, return true
	 * 4. Else update new index
	 * 5. Return false by default
	 * 
	 */	
	
	private boolean containsDuplicate(int[] nums, int k) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length && j<=i+k;j++) {
				if(nums[i]==nums[j]) return true;
			}
		}
		return false;
	}
	
	private boolean containsDuplicate_hashMap(int[] nums, int k) {
		Map<Integer,Integer> hMap = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(hMap.containsKey(nums[i])) 
				if(i-hMap.get(nums[i])<=k) return true;
			
			hMap.put(nums[i], i);
		}
		return false;
	}

	
}
