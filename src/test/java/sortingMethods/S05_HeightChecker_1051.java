package sortingMethods;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class S05_HeightChecker_1051 {

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
		int[] heights = {1,1,4,2,1,3};
		int output = 3;
		Assert.assertEquals(heightChecker(heights), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] heights = {5,1,2,3,4};
		int output = 5;
		Assert.assertEquals(heightChecker(heights), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] heights = {1,2,3,4,5};
		int output = 0;
		Assert.assertEquals(heightChecker(heights), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Method 1 - Using additional array --
	 * 
	 * 1. Copy the contents of heights array into another array
	 * 2. Sort the array using any of the sorting algorithms
	 * 3. For each element in heights, if the value in sorted array is not equal, increment counter
	 * 4. return counter
	 * 
	 */	
	
	public int heightChecker(int[] heights) {
		if(heights.length==1) return 0;
        int[] input = Arrays.copyOf(heights,heights.length);
        for(int i=1;i<heights.length;i++) {
        	if(heights[i-1] > heights[i]) {
        		int index=i;
        		while(index>0 && heights[index-1] > heights[index]) {
        			int temp = heights[index];
        			heights[index] = heights[index-1];
        			heights[index-1] = temp;
        			index--;
        		}
        	}
        }
        System.out.println(Arrays.toString(heights));
        int counter=0;

        for(int i=0;i<heights.length;i++){
            if(input[i] != heights[i]) counter++;
        }
        return counter;
	}
}
