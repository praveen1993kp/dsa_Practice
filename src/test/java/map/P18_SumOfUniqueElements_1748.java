package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P18_SumOfUniqueElements_1748 {

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
		int[] nums = {1,2,3,2};
		int output = 4;
		Assert.assertEquals(sumOfUniqueElements(nums), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] nums = {1,2,3,4,5};
		int output = 15;
		Assert.assertEquals(sumOfUniqueElements(nums), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] nums = {1,2,3,2,2,2};
		int output = 4;
		Assert.assertEquals(sumOfUniqueElements(nums), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {1,1,1,1,1};
		int output = 0;
		Assert.assertEquals(sumOfUniqueElements(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force - Using Map --
	 * 
	 * 1. Add the occurrence of all the elements into a map
	 * 2. Traverse through the map and if the value is 1, add it with sum
	 * 3. Return the sum
	 * 
	 * -- Single pass - Using asciia array --
	 * 
	 * 1. Traverse through given array nums
	 * 2. If ascii[nums[i]]==0, set the value as 1 and add nums[i] to sum
	 * 3. If ascii[nums[i]]==1, set the value as -1 and subtract nums[i] from sum
	 * 4. If ascii[nums[i]]==-1, continue;
	 * 5. Return the sum
	 * 
	 */	
	
	private int sumOfUniqueElements(int[] nums) {
		Map<Integer,Integer> hMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hMap.put(nums[i],hMap.getOrDefault(nums[i],0)+1);
        }
        
        Iterator<Integer> itr = hMap.keySet().iterator();
        int sum=0;
        while(itr.hasNext()){
            int currKey = itr.next();
            if(hMap.get(currKey)==1){
                sum += currKey;
            }
        }
        return sum;
	}
	
	private int sumOfUniqueElements_ascii(int[] nums) {
		int sum=0;
        int[] ascii = new int[101];
        for(int i=0;i<nums.length;i++){
            if(ascii[nums[i]]==0) {
                ascii[nums[i]] = 1;
                sum += nums[i];
            } else if(ascii[nums[i]]==1){
                sum -= nums[i];
                ascii[nums[i]] = -1;
            } else continue;
            
        }
        return sum;
	}
}
