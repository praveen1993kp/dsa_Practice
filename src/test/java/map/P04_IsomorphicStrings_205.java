package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P04_IsomorphicStrings_205 {

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
		String s = "add";
		String t = "egg";
		boolean output = true;
		Assert.assertEquals(isIsomorphic(s,t), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String s = "add";
		String t = "122";
		boolean output = true;
		Assert.assertEquals(isIsomorphic(s,t), output);
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		String s = "ABCDEFB";
		String t = "!@#DEF@";
		boolean output = true;
		Assert.assertEquals(isIsomorphic(s,t), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "abca";
		String t = "AB2a";
		boolean output = false;
		Assert.assertEquals(isIsomorphic(s,t), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "foo";
		String t = "bar";
		boolean output = false;
		Assert.assertEquals(isIsomorphic(s,t), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two maps
	 * 2. For each character in s and t, add into hMap1 as s.charAt(i) and t.charAt(i) 
	 * 3. Repeat the same process but add elements by swapping key and pair of previous map
	 * 4. Continue steps 2-3 only when both the keys are not available in respective hashmap
	 * 5. When condition 4 is not met, if the values in both maps are not equal to current occuring value, return false
	 * 6. Return true by default
	 * 
	 * 
	 */	
	
	private boolean isIsomorphic(String s, String t) {
		Map<Character,Character> hMap1 = new HashMap<>();
        Map<Character,Character> hMap2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hMap1.containsKey(s.charAt(i)) && !hMap2.containsKey(t.charAt(i))){
                hMap1.put(s.charAt(i),t.charAt(i));
                hMap2.put(t.charAt(i),s.charAt(i));
            } else{
                if((hMap1.containsKey(s.charAt(i)) && hMap1.get(s.charAt(i)) != t.charAt(i)) ||
                  (hMap2.containsKey(t.charAt(i)) && hMap2.get(t.charAt(i)) != s.charAt(i))){
                    return false;
                }
            }
        }
        return true;
	}
}
