package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P25_UniqueNumberOfOccurrences_1207 {

	@SuppressWarnings("deprecation")
	@Test
	public void example1() {
		//Positive Test Data
		int[] nums = {1,2,2,1,1,3};
		boolean output = true;
		Assert.assertEquals(uniqueOccurrences(nums),output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2};
		boolean output = true;
		Assert.assertEquals(uniqueOccurrences(nums),output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {-3,0,1,-3,1,1,1,-3,10,0};
		boolean output = true;
		Assert.assertEquals(uniqueOccurrences(nums),output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a Map to hold each number and its occurrence
	 * 2. Traverse through the input array and add into hashMap
	 * 3. Get the values from hashmap and add into a set
	 * 4. If the size of set is not equal to number of keys/values in hashmap, return false
	 * 5. return true by default
	 * 
	 * 
	 */	
	
	public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> hMap = new HashMap<>();
        for(int i : arr)
            hMap.put(i,hMap.getOrDefault(i,0)+1);

        Set<Integer> hSet = new HashSet<>(hMap.values());
        return (hSet.size() != hMap.keySet().size()) ? false : true;
    }
}
