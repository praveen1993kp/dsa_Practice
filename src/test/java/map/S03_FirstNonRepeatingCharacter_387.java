package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class S03_FirstNonRepeatingCharacter_387 {

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
		String s = "leetcode";
		int output = 0;
		Assert.assertEquals(firstNonRepeatingCharacter(s),output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String s = "lleettccooddea";
		int output = 13;
		Assert.assertEquals(firstNonRepeatingCharacter(s),output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "l";
		int output = 0;
		Assert.assertEquals(firstNonRepeatingCharacter(s),output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "lleettccooddeee";
		int output = -1;
		Assert.assertEquals(firstNonRepeatingCharacter(s),output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 1. Traverse using the given array using two loops : i=0 and j=i+1. Create a set to hold duplicate characters
	 * 2. If the character is not found anywhere in the array and not available in the list, return i
	 * 3. If the character is duplicate, add into a list
	 * 4. If i==s.length()-1 and not available in the list, return it
	 * 5. Return -1 by default
	 * 
	 * -- Using Ascii --
	 * 
	 * 1. Create an ascii of size 26
	 * 2. Add all the characters of s into ascii array
	 * 3. Traverse through the characters of s and if the value of ascii[s.charAt(pointer)-'a'] == 1, return the index
	 * 4. Return -1 by default
	 * 
	 * -- Using Map --
	 * 
	 * 1. Create a hashMap
	 * 2. Add all the characters of s into hashMap
	 * 3. Traverse through the characters of s and if the value of s.charAt(i)==1, return the index
	 * 4. Return -1 by default
	 * 
	 */	
	
	private int firstNonRepeatingCharacter(String s){
		Set<Character> hSet = new HashSet<>();
		    for(int i=0;i<s.length();i++){
			    for(int j=i+1;j<s.length();j++){
				    if(s.charAt(j)==s.charAt(i)) hSet.add(s.charAt(i));		
			    }
			if(!hSet.contains(s.charAt(i))) return i;
		    }
		return -1;
		
	}


	private int firstNonRepeatingCharacter_usingAscii(String s){
		int[] ascii = new int[26];
		for(int i=0;i<s.length();i++){
			ascii[s.charAt(i)-'a']++;
		}
		
		for(int i=0;i<s.length();i++){
			if(ascii[s.charAt(i)-'a']==1) return i;
		}
		
		return -1;
		
	}

	private int firstNonRepeatingCharacter_usingMap(String s){
		Map<Character,Integer> hMap = new HashMap<>();
		
		for(int i=0;i<s.length();i++){
			hMap.put(s.charAt(i),hMap.getOrDefault(s.charAt(i),0)+1);
		}
		
		for(int i=0;i<s.length();i++){
			if(hMap.get(s.charAt(i))==1) return i;
		}
		
		return -1;
	}
	
}
