package comparator;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class S02_MaximumUnitsOnATruck_1710 {

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
		int[][] boxTypes = {{1,3},{2,2},{3,1}};
		int truckSize = 4;
		int output = 8;
		Assert.assertEquals(maxUnits(boxTypes, truckSize),output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[][] boxTypes = {{10,3},{5,2},{3,1}};
		int truckSize = 4;
		int output = 9;
		Assert.assertEquals(maxUnits(boxTypes, truckSize),output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[][] boxTypes = {{10,3}};
		int truckSize = 10;
		int output = 30;
		Assert.assertEquals(maxUnits(boxTypes, truckSize),output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the array based on noOfUnitsPerBox in descending order
	 * 2. Traverse through the elements and calculate maxUnits by multiplying the boxType values and adding with maxUnits
	 * 3. Decrement the truckSize
	 * 4. If truckSize is less than 0, subtract the product of difference and units from maxUnits
	 * 5. return maxUnits
	 * 
	 */	
	
	private int maxUnits(int[][] boxTypes, int truckSize) {
		int maxUnits = 0;
        //Sort in descending order based numberOfUnitsPerBox
        Arrays.sort(boxTypes, (int[]a, int[]b) -> (b[1] - a[1]));
        for(int i=0;i<boxTypes.length;i++){
        	maxUnits += boxTypes[i][0] * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            if(truckSize<=0) {
                if(truckSize==0) break;
                maxUnits -= (-truckSize * boxTypes[i][1]);
                break;
            }
        }

		return maxUnits;
	}

}
