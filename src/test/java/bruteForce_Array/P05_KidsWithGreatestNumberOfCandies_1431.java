package bruteForce_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class P05_KidsWithGreatestNumberOfCandies_1431 {

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
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		List<Boolean> output = Arrays.asList(true,true,true,false,true);
		Assert.assertEquals(output, greatestNoOfCandies(candies,extraCandies));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] candies = {12,1,12};
		int extraCandies = 10;
		List<Boolean> output = Arrays.asList(true,false,true);
		Assert.assertEquals(output, greatestNoOfCandies(candies,extraCandies));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] candies = {4,2,1,1,2};
		int extraCandies = 1;
		List<Boolean> output = Arrays.asList(true,false,false,false,false);
		Assert.assertEquals(output, greatestNoOfCandies(candies,extraCandies));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a list for output
	 * 2. Find the maximum number in the array
	 * 3. Traverse through the array again and if the sum of current and extracandies is greater than or 
	 * 			equal to max number, add true in list. Else add false
	 * 4. Return list
	 * 
	 */	
	
	private List<Boolean> greatestNoOfCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();
        int maxCandy = 0;
        for(int i : candies){
            maxCandy = Math.max(i,maxCandy);
        }
        
        for(int i : candies){
            result.add(i+extraCandies>=maxCandy);
        }
        return result;
	}
}
