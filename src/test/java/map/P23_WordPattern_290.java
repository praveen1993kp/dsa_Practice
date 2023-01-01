package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P23_WordPattern_290 {

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
		String pattern = "abba";
		String s = "dog cat cat dog";
		Assert.assertEquals(wordPattern_UsingAsciiAndMap(pattern,s), true);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String pattern = "abba";
		String s = "dog cat cat fish";
		Assert.assertEquals(wordPattern_UsingAsciiAndMap(pattern,s), false);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String pattern = "aaaa";
		String s = "dog dog dog dog";
		Assert.assertEquals(wordPattern_UsingAsciiAndMap(pattern,s), true);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String pattern = "aaaa";
		String s = "dog dog dog fish";
		Assert.assertEquals(wordPattern_UsingAsciiAndMap(pattern,s), false);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Using Two Maps --
	 * 
	 * 1. Create two maps 1.<Character,String> and 2.<String,Character>
	 * 2. If both the keys are not available, add into respective maps
	 * 3. If either of the values available in map, check for the value in other map.
	 * 4. If the values are not matching with current element value, return false
	 * 5. return true by default
	 * 
	 */	
	
	public boolean wordPattern(String pattern, String s) {
        Map<Character,String> patternMap = new HashMap<>();
        Map<String,Character> stringMap = new HashMap<>();
    
        String[] str = s.split(" ");
        if(pattern.length() != str.length) return false;
        for(int i=0;i<pattern.length();i++){
            if(!patternMap.containsKey(pattern.charAt(i)) && !stringMap.containsKey(str[i])){
                patternMap.put(pattern.charAt(i),str[i]);
                stringMap.put(str[i],pattern.charAt(i));
            } else {
                if(patternMap.containsKey(pattern.charAt(i)) && !patternMap.get(pattern.charAt(i)).equals(str[i])) return false;
                if(stringMap.containsKey(str[i]) && stringMap.get(str[i]) != pattern.charAt(i)) return false;
            }
        }
        return true;
    }
	
	public boolean wordPattern_UsingAsciiAndMap(String pattern, String s) {
		String[] patternAscii = new String[26];
        Map<String,Character> stringMap = new HashMap<>();
    
        String[] str = s.split(" ");
        if(pattern.length() != str.length) return false;
        for(int i=0;i<pattern.length();i++){
            if(patternAscii[pattern.charAt(i)-'a'] == null && !stringMap.containsKey(str[i])){
                patternAscii[pattern.charAt(i)-'a'] = str[i];
                stringMap.put(str[i],pattern.charAt(i));
            } else {
                if(patternAscii[pattern.charAt(i)-'a'] != null && !patternAscii[pattern.charAt(i)-'a'].equals(str[i])) return false;
                if(stringMap.containsKey(str[i]) && stringMap.get(str[i]) != pattern.charAt(i)) return false;
            }
        }
        return true;
    }
}
