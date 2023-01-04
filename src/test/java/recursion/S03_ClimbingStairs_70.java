package recursion;

import org.junit.Test;

import junit.framework.Assert;

public class S03_ClimbingStairs_70 {

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
		int n = 10;
		int output = 55;
		Assert.assertEquals(climbingStairs(n), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int n = 1;
		int output = 1;
		Assert.assertEquals(climbingStairs(n), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int n = 0;
		int output = 0;
		Assert.assertEquals(climbingStairs(n), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. If n=0 or n=1, return n 
	 * 2. Create variables to accommodate first 2 values of fibonnaci series i.e. 0 and 1
	 * 3. Traverse from i=0 and till <=n
	 * 4. Set val2 value into temp
	 * 5. Sum val2 and val1 to accommodate into val2
	 * 6. reset val2 to temp value
	 * 7. return val2 by default
	 * 
	 * Same logic with recursion
	 * 
	 */	
	
	private int climbingStairs(int n) {
		if(n<=1) return n;
        int val1=0;
        int val2=1;
        for(int i=2;i<=n;i++){
            int temp = val2;
            val2 = val2+val1;
            val1 = temp;
        }
        return val2;
	}
	
	private int climbingStairs_Recursion(int n) {
		if(n<=1) return n;
        return recursion(2,n,0,1);     
	}
	
	public int recursion(int index,int n,int val1,int val2){
        if(index==n) return val2+val1;
        int temp = val2;
        val2 = val2+val1;
        val1 = temp;
        return recursion(index+1,n,val1,val2);
    }

	
}
