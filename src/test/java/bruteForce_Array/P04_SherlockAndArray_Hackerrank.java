package bruteForce_Array;

import org.junit.Assert;
import org.junit.Test;

public class P04_SherlockAndArray_Hackerrank {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * 
	 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
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
		int[] arr = {5,6,8,1};
		String output = "YES";
		Assert.assertEquals(areSumSame(arr),output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] arr = {0,0,0,2};
		String output = "YES";
		Assert.assertEquals(areSumSame(arr),output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] arr = {1,2,3};
		String output = "NO";
		Assert.assertEquals(areSumSame(arr),output);
	}
	
	@Test
	public void positive2() {
		//Negative Test Data
		int[] arr = {1,2,3,3};
		String output = "YES";
		Assert.assertEquals(areSumSame(arr),output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Get the sum of all the elements and assign it to rightSum
	 * 2. Create variable leftSum
	 * 3. If leftSum equals rightSum - current element, then return Yes
	 * 4. Increment leftSum with current element value
	 * 
	 */	
	
	public String areSumSame(int[] arr) {
		int rightSum = 0;
	    for(int i=0;i<arr.length;i++){
	        rightSum += arr[i];
	    }
	    int leftSum = 0;
	    for(int i=0;i<arr.length;i++){
	        rightSum -= arr[i];
	        if(leftSum==rightSum) return "YES";
	        leftSum += arr[i];
	     
	    }
	    return "NO";
	}
}
