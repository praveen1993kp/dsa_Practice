package binarySearch;

import org.junit.Test;

import junit.framework.Assert;

public class S03_Sqrtx_69 {

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
		int x = 16;
		int root = 4;
		Assert.assertEquals(squareRoot(x), root);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int x = 1;
		int root = 1;
		Assert.assertEquals(squareRoot(x), root);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int x = 0;
		int root = 0;
		Assert.assertEquals(squareRoot(x), root);
	}
	
	@Test
	public void negative() {
		//Edge Case Test Data
		int x = 12;
		int root = 3;
		Assert.assertEquals(squareRoot(x), root);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int x = 2147395599;
		int root = 46339;
		Assert.assertEquals(squareRoot(x), root);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create variables left=0,right=x/2 and mid=0
	 * 2. Traverse while left<right
	 * 3. Calculate mid everytime
	 * 4. If value equals mid*mid, return mid
	 * 5. If value less than mid*mid, left=mid+1 and store mid in a variable
	 * 6. If value greater than mid*mid, right=mid-1
	 * 7. Return the stored variable
	 * 
	 * 
	 * 
	 */	
	
	private int squareRoot(int x) {
		if(x<2) return x;
		int left=1,right=x/2,mid=0;
		int result=0;
		while(left<=right) {
			mid = left + (right-left)/2;
			if(mid < x/mid) {
				left = mid+1;
				result = mid;
			} else if (mid > x/mid) 
				right = mid-1;
			 else return mid;
		}
		return result;
	}

}
