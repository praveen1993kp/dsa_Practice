package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P01_NumberOfGoodPairs_1512 {

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
		int[] nums = {1,2,3,1,1,3};
		int output = 6;
		Assert.assertEquals(noOfGoodPairs_hashMap(nums), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		int[] nums = {1,1,1,1};
		int output = 6;
		Assert.assertEquals(noOfGoodPairs_hashMap(nums), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int output = 0;
		Assert.assertEquals(noOfGoodPairs_hashMap(nums), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		int[] nums = {1};
		int output = 0;
		Assert.assertEquals(noOfGoodPairs_hashMap(nums), output);
	}
	
	@Test
	public void edge3() {
		//Negative Test Data
		int[] nums = {1,1,2,2,1,2,1,2,3,4,1};
		int output = 16;
		Assert.assertEquals(noOfGoodPairs_hashMap(nums), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Using HashMap --
	 * 
	 * 1. Create an hashmap with generics Integer,Integer
	 * 2. Add the values of nums[i] into the hashMap with nums[i] as key and i as value
	 * 3. Traverse through the hashMap and see if value of each nums[i] is greater than 1
	 * 4. If greater than 1, add value * value-1/2 into pairs variable (Mathematical combination)
	 * 5. Return pairs at the end
	 * 
	 * -- Using Ascii array -- (Based on the constraints)
	 * 
	 * 1. Create an ascii with size 101
	 * 2. For each value in nums[i], increment the respective ascii array value by 1
	 * 3. Traverse through the ascii array
	 * 4. If any of the value found to be greater than one, apply (value*(value-1))/2 and add it to pairs
	 * 5. Return pairs
	 * 
	 * 
	 */	

	private int noOfGoodPairs_hashMap(int[] nums) {
		Map<Integer,Integer> hMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hMap.put(nums[i],hMap.getOrDefault(nums[i],0)+1);
        }
        System.out.println(hMap.toString());
        int pairs = 0;
        Iterator<Integer> eachKey = hMap.keySet().iterator();
        while(eachKey.hasNext()){
                int currentVal = hMap.get(eachKey.next());
                //System.out.println(currentVal);
                if(currentVal>1){
                    pairs += (currentVal *(currentVal-1))/2;
                }
                //System.out.println(pairs);
        }
      return pairs;  
	}
	
private int noOfGoodPairs_ascii(int[] nums) {
	int[] arr = new int[101];
    int pairs = 0;
    for(int i=0;i<nums.length;i++)
        arr[nums[i]]++;
    
    for(int j=0;j<arr.length;j++){
        if(arr[j]>1){
            System.out.println(arr[j]);
            pairs += (arr[j] * (arr[j]-1))/2;
        }
    }
    return pairs;
	}
}
