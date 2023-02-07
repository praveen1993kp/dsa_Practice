package twoPointers_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P15_FruitsIntoBaskets_904 {
	
	@Test
	public void example1() {
		int[] fruits = {1,2,1};
		int output = 3;
		Assert.assertEquals(fruitsIntoBaskets(fruits), output);
	}
	
	@Test
	public void example2() {
		int[] fruits = {0,1,2,2};
		int output = 3;
		Assert.assertEquals(fruitsIntoBaskets(fruits), output);
	}
	
	@Test
	public void example3() {
		int[] fruits = {1,2,3,2,2};
		int output = 3;
		Assert.assertEquals(fruitsIntoBaskets(fruits), output);
	}
	
	@Test
	public void example4() {
		int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
		int output = 5;
		Assert.assertEquals(fruitsIntoBaskets(fruits), output);
	}
	
	/*
	 *
	 * Approach 1 :
	 * 
	 * 1. Create variable maxFruits
	 * 2. Create pointers left and right
	 * 3. Create counter=0
	 * 4. Create a list to hold integers
	 * 5. Traverse while right<length of fruits
	 * 6. If the fruit type is not available, increase the counter and add the fruit type into the list
	 * 7. Calculate maxFruits for each step
	 * 8. If more than two fruit types are added, remove values till 2 values are available in the list
	 * 9. Handle cases where the total length of given array is crossed
	 * 10. Return maxFruits
	 * 
	 * Approach 2:
	 * 
	 * 1. Create variable maxFruits, pointers left=0 and right=0
	 * 2. Create a hashmap
	 * 3. Traverse while right<fruits length
	 * 4. Add current fruit type into hashmap
	 * 5. If the hashmap size is greater than 2, start removing the left most value till size becomes equal to 2
	 * 6. Calculate maxFruits and increment right
	 * 7. continue for all the elements in fruit
	 * 8. return maxFruits
	 * 
	 * 
	 */
	
	public int fruitsIntoBaskets(int[] fruits) {
        int maxFruits = 0;
        int left=0,right=0;
        int counter=0;
        List<Integer> lst = new ArrayList<>();
        while(right<fruits.length){
            if(!lst.contains(fruits[right])) counter++;
            lst.add(fruits[right]);    
            maxFruits = Math.max(maxFruits,right-left);
            right++;   
            while(counter>2) {
                lst.remove(0);
                if(!lst.contains(fruits[left])) counter--;
                left++;
            }   
        }
        if(right==fruits.length){
                maxFruits = Math.max(maxFruits,right-left);
            }
        return maxFruits;
    }
	
	
	public int fruitsIntoBaskets_Approach2(int[] fruits) {
        int maxFruits = 0;
        int left=0,right=0;
        Map<Integer,Integer> hMap = new HashMap<>();
        while(right<fruits.length) {
        	hMap.put(fruits[right], hMap.getOrDefault(fruits[right], 0)+1);
        	while(hMap.size()>2) {
        		hMap.put(fruits[right], hMap.get(fruits[right])-1);
        		hMap.remove(fruits[right],0);
        		left++;
        	}
        	right++;
        	maxFruits = Math.max(maxFruits, right-left);
        }
        return maxFruits;
    }
	
	

}
