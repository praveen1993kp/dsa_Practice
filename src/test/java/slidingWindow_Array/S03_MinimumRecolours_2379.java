package slidingWindow_Array;

import org.junit.Test;

import junit.framework.Assert;

public class S03_MinimumRecolours_2379 {

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
		String blocks = "WBBWBBWW";
		int k = 5;
		int output = 1;
		Assert.assertEquals(minRecolours(blocks,k), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String blocks = "W";
		int k = 1;
		int output = 1;
		Assert.assertEquals(minRecolours(blocks,k), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String blocks = "WBBBBBW";
		int k = 7;
		int output = 2;
		Assert.assertEquals(minRecolours(blocks,k), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String blocks = "BBBBBB";
		int k = 3;
		int output = 0;
		Assert.assertEquals(minRecolours(blocks,k), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		String blocks = "B";
		int k = 1;
		int output = 0;
		Assert.assertEquals(minRecolours(blocks,k), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers left=0 and right=0
	 * 2. Create variables whiteBlocks=0 and minBlock=Integer.MAX_VALUE
	 * 3. For the first k elements, count the number of W blocks
	 * 4. Assign minBlocks as whiteBlocks
	 * 5. Traverse till right<blocks.length()
	 * 6. If the character at right pointer is white, increase whiteBlock by 1
	 * 7. If the character at left pointer is white, decrease whiteBlock by 1
	 * 8. Find the min between whiteBlocks and minBlock
	 * 9. Return minBlock
	 * 
	 * Method 2:
	 * 
	 * 1. When single pointer is used, use p1-k when left needs to be used
	 * 
	 */	
	
	private int minRecolours(String blocks, int k) {
		int left=0,right=0;
        int whiteBlocks=0,minBlock = Integer.MAX_VALUE;
        while(right<k){
            if(blocks.charAt(right++)=='W') whiteBlocks++;
        }
        minBlock = whiteBlocks;
        while(right<blocks.length()){
            if(blocks.charAt(right++)=='W') whiteBlocks++;
            if(blocks.charAt(left++)=='W') whiteBlocks--;
            minBlock = Math.min(minBlock,whiteBlocks);
        }
        return minBlock;
	}
	
	private int minRecolours_UsingOnePointer(String blocks, int k) {
		int p1=0;
        int whiteBlocks=0,minBlock = Integer.MAX_VALUE;
        while(p1<k){
            if(blocks.charAt(p1++)=='W') whiteBlocks++;
        }
        minBlock = whiteBlocks;
        while(p1<blocks.length()){
            if(blocks.charAt(p1)=='W') whiteBlocks++;
            if(blocks.charAt(p1-k)=='W') whiteBlocks--;
            p1++;
            minBlock = Math.min(minBlock,whiteBlocks);
        }
        return minBlock;
	}
}
