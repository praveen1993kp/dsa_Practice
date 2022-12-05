package map;

import org.junit.Test;

import junit.framework.Assert;

public class P21_RansomeNote_383 {

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
		String ransomNote = "a";
		String magazine = "ab";
		boolean output = true;
		Assert.assertEquals(ransom(ransomNote,magazine), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String ransomNote = "aaaaa";
		String magazine = "aaaaaaaaaab";
		boolean output = true;
		Assert.assertEquals(ransom(ransomNote,magazine), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String ransomNote = "ab";
		String magazine = "a";
		boolean output = false;
		Assert.assertEquals(ransom(ransomNote,magazine), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two ascii arrays
	 * 2. Add the characters of ransomNote into ascii1 and magazine into ascii2
	 * 3. Traverse through ransomNote again and for each character, if the count in ransomeArray is greater than magazine array, return false
	 * 4. return true by default
	 * 
	 */	
	
	private Object ransom(String ransomNote, String magazine) {
		int[] ascii1 = new int[26];
        int[] ascii2 = new int[26];
        
        for(char ch : ransomNote.toCharArray())
            ascii1[ch-'a']++;
            
        for(char ch : magazine.toCharArray())
            ascii2[ch-'a']++;
        
        for(char ch : ransomNote.toCharArray())
            if(ascii1[ch-'a'] > ascii2[ch-'a']) return false;
        
        return true;
	}
}
