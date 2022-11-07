package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P11_UniqueMorseCode_804 {

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
		String[] words = {"gin","zen","gig","msg"};
		int output = 2;
		Assert.assertEquals(uniqueMorseCode_usingMap(words), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String[] words = {"a"};
		int output = 1;
		Assert.assertEquals(uniqueMorseCode_usingMap(words), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String[] words = {"a","b","aa"};
		int output = 3;
		Assert.assertEquals(uniqueMorseCode_usingMap(words), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Add the morse code for each character into a String array
	 * 2. Create a set for holding the values
	 * 3. Consolidate the morsecode for each string and add it into the set after every word
	 * 4. Calculate the size of set at the end and return it
	 * 
	 * -- Map --
	 * 
	 *
	 */	
	
	private int uniqueMorseCode(String[] words) {
		String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		Set<String> hSet = new HashSet<>();
		
		for(int i=0;i<words.length;i++) {
			String currWord = "";
			for(int j=0;j<words[i].length();j++) {
				currWord += morseCode[words[i].charAt(j)-'a'];
			}
			hSet.add(currWord);
		}
		return hSet.size();
	}
	
	private int uniqueMorseCode_usingMap(String[] words) {
		String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		Map<String,Integer> hMap = new HashMap<>();
		
		for(int i=0;i<words.length;i++) {
			String currWord = "";
			for(int j=0;j<words[i].length();j++) {
				currWord += morseCode[words[i].charAt(j)-'a'];
			}
			hMap.put(currWord,hMap.getOrDefault(currWord, 0)+1);
		}
		return hMap.keySet().size();
	}

	
}
