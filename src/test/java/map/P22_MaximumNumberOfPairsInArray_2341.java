package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P22_MaximumNumberOfPairsInArray_2341 {

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
		int[] nums = {1,3,2,1,3,2,2};
		int[] output = {3,1};
		Assert.assertTrue(Arrays.equals(numberOfPairs(nums), output));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {0};
		int[] output = {0,1};
		Assert.assertTrue(Arrays.equals(numberOfPairs(nums), output));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,1};
		int[] output = {1,0};
		Assert.assertTrue(Arrays.equals(numberOfPairs(nums), output));
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 
	 * 1. Create a Map
	 * 2. Traverse through the array and add elements and its occurrence in map
	 * 3. Create an iterator
	 * 4. Traverse while itr has next
	 * 5. If value is odd, add 1 into uniqueKeys
	 * 6. Update pairs removed as (length of array-uniqueKeys)/2 
	 * 7. Return pairs removed and uniqueKeys in an array
	 * 
	 * -- Ascii --
	 * 
	 * 1. Create an ascii of size 101
	 * 2. Add the occurrence of each element into the ascii array
	 * 3. Traverse again through the number and if the occurrence is odd, increment uniqueKeys
	 * 4. Update pairs removed as (length of array-uniqueKeys)/2
	 * 5. Return pairs removed and uniqueKeys in an array
	 */	
	
	public int[] numberOfPairs(int[] nums) {
        Map<Integer,Integer> hMap = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
            hMap.put(nums[i],hMap.getOrDefault(nums[i],0)+1);   
        
        int uniqueKeys = 0;
        Iterator<Integer> itr = hMap.values().iterator();
        while(itr.hasNext())
            uniqueKeys += itr.next()%2;
        
        return new int[]{(nums.length-uniqueKeys)/2,uniqueKeys};
    }
	
	public int[] numberOfPairs_ascii(int[] nums) {
        int[] ascii = new int[101];
        for(int num : nums)
            ascii[num]++;
        
        int uniqueKeys = 0;
        for(int i=0;i<ascii.length;i++){
            if(ascii[i]!=0){
                uniqueKeys += ascii[i]%2;
            }
        }

        return new int[]{(nums.length-uniqueKeys)/2,uniqueKeys};
    }
}
