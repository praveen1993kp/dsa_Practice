package twoPointers_Array;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P05_AssignCookies_455 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode #455
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
		int[] g = {1,2,3};
		int[] s = {3,4,5};
		int output = 3;
		Assert.assertEquals(assignCookies(g,s), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] g = {1};
		int[] s = {3,4,5};
		int output = 1;
		Assert.assertEquals(assignCookies(g,s), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] g = {1,2,3};
		int[] s = {3};
		int output = 1;
		Assert.assertEquals(assignCookies(g,s), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given array
	 * 2. p1=0 and p2 = 0 and assign them to first elements of each array. Create counter = 0
	 * 3. Traverse while p1<g.length && p2<s.length
	 * 4. If nums[left] > nums[right] increment right
	 * 5. Else, increase the counter and increase left and right
	 * 6. Repeat steps 4-5 till condition 3 meets
	 * 7. Return the counter
	 * 
	 */	
	
	private Object assignCookies(int[] g, int[] s) {
		Arrays.sort(g);
        Arrays.sort(s);   
        int p1=0,p2=0,counter=0;
        while(p1<g.length && p2<s.length){
            if(g[p1] > s[p2]) p2++;
            else{
                counter++;
                p1++;
                p2++;
            }
        }
        return counter;
	}
}
