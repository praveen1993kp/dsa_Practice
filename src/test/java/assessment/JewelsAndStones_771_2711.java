package assessment;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class JewelsAndStones_771_2711 {

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
		String jewels = "aA";
		String stones = "aAAbbbb";
		int output = 3;
		Assert.assertEquals(findJewelStones(jewels,stones), output);
	}
	
	@Test
	public void negative() {
		//Edge Case Test Data
		String jewels = "z";
		String stones = "ZZ";
		int output = 0;
		Assert.assertEquals(findJewelStones(jewels,stones), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String jewels = "AaBbC";
		String stones = "a";
		int output = 1;
		Assert.assertEquals(findJewelStones(jewels,stones), output);
	}
	
	@Test
	public void positive2() {
		//Negative Test Data
		String jewels = "Z";
		String stones = "ZZ";
		int output = 2;
		Assert.assertEquals(findJewelStones(jewels,stones), output);
	}

	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create an ascii array and add all the stones in it
	 * 2. Traverse through the ascii and get the value of each jewel and add in counter
	 * 3. Return the counter
	 * 
	 *
	 * 
	 */	
	
	private int findJewelStones(String jewels, String stones) {
		int counter=0;
		int[] ascii = new int[128];
		for(int i=0;i<stones.length();i++) {
			ascii[stones.charAt(i)-'A']++;
		}
		
		for(int i=0;i<jewels.length();i++) {
			counter += ascii[jewels.charAt(i)-'A'];
		}
		return counter;
	}
	
	
	
}
