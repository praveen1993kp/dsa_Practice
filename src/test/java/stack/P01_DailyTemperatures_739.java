package stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P01_DailyTemperatures_739 {

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
		int[] temperatures = {73,74,75,71,69,72,76,73};
		int[] output = {1,1,4,2,1,1,0,0};
		Assert.assertArrayEquals(nextWarmerDay_stack(temperatures), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] temperatures = {30,40,50,60};
		int[] output = {1,1,1,0};
		Assert.assertArrayEquals(nextWarmerDay_stack(temperatures), output);
	}
	
	@Test
	public void negative() {
		//Negative Case Test Data
		int[] temperatures = {5,4,3,2,1};
		int[] output = {0,0,0,0,0};
		Assert.assertArrayEquals(nextWarmerDay_stack(temperatures), output);
	}
	
	

	@Test
	public void edge() {
		//Negative Test Data
		int[] temperatures = {5,4,3,2,4};
		int[] output = {0,0,2,1,0};
		Assert.assertArrayEquals(nextWarmerDay_stack(temperatures), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 1. Traverse through the temperatures array
	 * 2. When any value greater than current value is found, subtract the indices and add in the index of current value and break the loop
	 * 3. Continue for all the elements in temperatures
	 * 4. Return the output array
	 * 
	 */	
	
	//Time Limit Exceeded - 47/48
	private int[] nextWarmerDay(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		for(int i=0;i<temperatures.length;i++) {
			for(int j=i+1;j<temperatures.length;j++) {
				if(temperatures[j] > temperatures[i]) {
					ans[i] = j-i;
					break;
				}
			}
		}
		return ans;
	}
	
	private int[] nextWarmerDay_stack(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[temperatures.length];
		
		for(int i=0;i<temperatures.length;i++) {
			while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int val = stack.pop();
				ans[val] = i-val;
			}
			
			stack.push(i);
		}
		return ans;
	}
}
