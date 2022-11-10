package map;

import org.junit.Assert;
import org.junit.Test;

public class P17_FairCandySwap_888 {

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
		int[] aliceSizes = {1,1};
		int[] bobSizes = {2,2};
		int[] output = {1,2};
		Assert.assertArrayEquals(fairCandySwap(aliceSizes,bobSizes), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] aliceSizes = {1,2};
		int[] bobSizes = {2,3};
		int[] output = {1,2};
		Assert.assertArrayEquals(fairCandySwap(aliceSizes,bobSizes), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] aliceSizes = {2};
		int[] bobSizes = {1,3};
		int[] output = {2,3};
		Assert.assertArrayEquals(fairCandySwap(aliceSizes,bobSizes), output);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] aliceSizes = {2,4,3,5};
		int[] bobSizes = {1,2,3,4};
		int[] output = {4,2};
		Assert.assertArrayEquals(fairCandySwap(aliceSizes,bobSizes), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Calculate the sum of aliceSizes and bobSizes individually
	 * 2. Calculate aliceSum-currentValue at aliceSizes + currentValue at bobSizes
	 * 3. Calculate bobSum-currentValue at bobSizes + currentValue at aliceSizes
	 * 4. When the sum from steps 2 and 3 are same, return the indices
	 * 
	 */	
	
	public int[] fairCandySwap(int[] aliceSizes,int[] bobSizes) {
		int aliceSum = 0;
        int bobSum = 0;
        int[] output = new int[2];
        for(int i=0;i<aliceSizes.length;i++){
            aliceSum += aliceSizes[i];
        }
        
        for(int i=0;i<bobSizes.length;i++){
            bobSum += bobSizes[i];
        }
        
        for(int i=0;i<aliceSizes.length;i++){
            for(int j=0;j<bobSizes.length;j++){
                if((aliceSum-aliceSizes[i]+bobSizes[j]) == (bobSum-bobSizes[j]+aliceSizes[i])){
                    output[0] = aliceSizes[i];
                    output[1] = bobSizes[j];
                    break;
                }
            }
        }
        return output;
	}
}
