package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P06_FindFirstPalindromicStringInTheArray_2108 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an array of strings words, 
	 * return the first palindromic string in the array. 
	 * If there is no such string, return an empty string "".
	 * A string is palindromic if it reads the same forward and backward.
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
		String words[] = {"abc","car","ada","racecar","cool"};
		String output = "ada";
		Assert.assertEquals(findFirstPalindromeString(words), output);
	}
	
	@Test
	public void positive2() {
		//Negative Case Test Data
		String words[] = {"abc","car","","cool","racecar"};
		String output = "racecar";
		Assert.assertEquals(findFirstPalindromeString(words), output);
	}
	
	@Test
	public void negative() {
		//Negative Case Test Data
		String words[] = {"notapalindrome","test"};
		String output = "";
		Assert.assertEquals(findFirstPalindromeString(words), output);
	}
	
	@Test
	public void edge() {
		//Negative Test Data
		String words[] = {"racecar","ada","ssddss"};
		String output = "racecar";
		Assert.assertEquals(findFirstPalindromeString(words), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse through the array
	 * 2. Create pointers left=0 and right=words[i].length()-1
	 * 3. If values in left and right are not equal, break
	 * 4. If left>=right return words[i]
	 * 5. Else increment left and decrement right
	 * 
	 */	
	
	private String findFirstPalindromeString(String[] words) {
		int left=0,right=0;
        for(int i=0;i<words.length;i++){
            if(words[i].length()==1) return words[i];
            left=0;
            right=words[i].length()-1;
            while(left<right){
                if(words[i].charAt(left) != words[i].charAt(right))
                    break;
                else {
                    left++;
                    right--;
                }
                if(left>=right) return words[i];
            }       
        }
        return "";
	}
}
