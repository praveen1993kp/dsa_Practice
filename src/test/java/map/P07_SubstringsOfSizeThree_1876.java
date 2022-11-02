package map;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P07_SubstringsOfSizeThree_1876 {

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
		String s = "xyzzaz";
		int output = 1;
		Assert.assertEquals(subStringOfSizeThree_SetAndSlidingWindow(s), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String s = "aababcabc";
		int output = 4;
		Assert.assertEquals(subStringOfSizeThree_SetAndSlidingWindow(s), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "xy";
		int output = 0;
		Assert.assertEquals(subStringOfSizeThree_SetAndSlidingWindow(s), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "xxyyzzaabb";
		int output = 0;
		Assert.assertEquals(subStringOfSizeThree_SetAndSlidingWindow(s), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create counter = 0
	 * 2. Create a for loop to traverse for the length of s. Create variable k = i+2
	 * 3. Check if adjacent elements are not same and first and last elements are not same in the 3 element window
	 * 4. If all are true, increment the counter
	 * 5. Increment k and i
	 * 6. Return counter at the end
	 * 
	 * -- Two Pointer --
	 * 
	 * 1. Create two pointers left=0 and right = 2;
	 * 2. Create counter = 0
	 * 3. Traverse while right<nums.length
	 * 4. Create 3 flags to compare the values (If there is not duplicate)
	 * 5. If all are true, increment counter
	 * 6. If the last 2 elements are same, increment left and right 
	 * 7. Increment left and right by default
	 * 8. Return the counter
	 * 
	 * -- Sliding Window with Set --
	 * 
	 * 1. Create two pointers left=0 and right = 0
	 * 2. Add first 3 elements into the set using right pointer
	 * 3. If set size == 3, increment counter
	 * 4. Traverse while right<s.length()
	 * 5. Add the value at right and remove value at left
	 * 6. Repeat step 3
	 * 7. Increment left and right by default
	 * 8. Return the counter
	 * 
	 */	
	
	private int subStringOfSizeThree_bruteForce(String s) {
		int counter = 0;
		for(int i=0;i<s.length()-2;i++) {
			int k=i+2;
			if(s.charAt(i) != s.charAt(i+1) && 
					s.charAt(i+1) != s.charAt(k) &&
					s.charAt(i) != s.charAt(k)) counter++;
			k++;
		}
		return counter;
	}
	
	private int subStringOfSizeThree_twoPointer(String s) {
		int left=0,right=2;
        int counter = 0;
        while(right<s.length()){         
            boolean flag1 = s.charAt(right) != s.charAt(right-1);
            boolean flag2 = s.charAt(right-1) != s.charAt(left);
            boolean flag3 = s.charAt(right) != s.charAt(left);
            if(flag1 && flag2 && flag3) counter++;
            if(!flag1) {
            	left++;
                right++;
            }
            left++;
            right++;
        }
        return counter;
	}
	
	private int subStringOfSizeThree_SetAndSlidingWindow(String s) {
		int left=0,right=0;
		int counter = 0;
		if(s.length()<3) return counter;
		Set<Character> hSet = new HashSet<>();
		while(right<3) {
			hSet.add(s.charAt(right++));
		}
		if(hSet.size()==3) counter++;
		while(right<s.length()) {
			hSet.add(s.charAt(right++));
			if(s.charAt(left)!=s.charAt(left+1)) hSet.remove(s.charAt(left));
			left++;
			if(hSet.size()==3) counter++;
		}
		return counter;
	}

	
}
