package map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class S02_DistributeCandies_575 {

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
		int[] candyType = {1,1,2,2,3,3};
		int output = 3;
		Assert.assertEquals(maxCandies_sortArray(candyType), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[] candyType = {1,1,1,1,2,3,4,5,6,7};
		int output = 3;
		Assert.assertEquals(maxCandies_sortArray(candyType), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] candyType = {1,2,3,4,5,6};
		int output = 3;
		Assert.assertEquals(maxCandies_sortArray(candyType), output);
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] candyType = {1,2};
		int output = 3;
		Assert.assertEquals(maxCandies_sortArray(candyType), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] candyType = {6,6,6,6};
		int output = 1;
		Assert.assertEquals(maxCandies_sortArray(candyType), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Sort the given array. Create two pointers
	 * 2. Find the number of unique candies in the array (Initialize counter=1 and increment only when adjacent elements are different)
	 * 3. When the unique candies count becomes equal to n/2, break it
	 * 4. Return the unique candies (This will handle both scenarios : ==n/2 and less than n/2)
	 * 
	 * -- Set --
	 * 
	 * 1. Create a hashSet
	 * 2. Add all the elements into set
	 * 3. Return the minimum between set size and n/2
	 * 
	 * -- Set Method 2--
	 * 
	 * 1. Create a hashset
	 * 2. if hashset size==n/2, break the loop
	 * 3. else, add current element into hashset
	 * 4. Return the hashset size
	 * 
	 */	
	
	private int maxCandies_sortArray(int[] candyType) {
		Arrays.sort(candyType);
        int maxAllowedCandies = candyType.length/2;
        int maxCandies=1;
        int left=0,right=1;
        while(right<candyType.length){
            if(candyType[left]!=candyType[right]) {
                if(maxCandies==maxAllowedCandies) break;
                maxCandies++;    
            }
            left++;
            right++;
        }
        return maxCandies;
	}
	
	private int maxCandies_set(int[] candyType) {
		int maxCandies = 0;
	    Set<Integer> hSet = new HashSet<>();
	    for(int i=0;i<candyType.length;i++){
		    hSet.add(candyType[i]);
	    }
	    return Math.min(maxCandies, hSet.size());
	}
	
	private int maxCandies_set2(int[] candyType) {
		int maxCandies = 0;
	    Set<Integer> hSet = new HashSet<>();
	    for(int i=0;i<candyType.length;i++){
            if(hSet.size()==candyType.length/2) break;
		    hSet.add(candyType[i]);
	    }
	    return hSet.size();
	}
	
}
