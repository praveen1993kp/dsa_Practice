package map;

import org.junit.Test;

import junit.framework.Assert;

public class P13_BuddyStrings_859 {

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
		String s = "abcde";
		String goal = "abedc";
		boolean output = true;
		Assert.assertEquals((buddyStrings(s,goal)), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		String s = "ab";
		String goal = "abcd";
		boolean output = false;
		Assert.assertEquals((buddyStrings(s,goal)), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String s = "ab";
		String goal = "a";
		boolean output = false;
		Assert.assertEquals((buddyStrings(s,goal)), output);
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		String s = "abcd";
		String goal = "abcd";
		boolean output = false;
		Assert.assertEquals((buddyStrings(s,goal)), output);
	}
	
	@Test
	public void edge4() {
		//Edge Case Test Data
		String s = "abab";
		String goal = "abab";
		boolean output = true;
		Assert.assertEquals((buddyStrings(s,goal)), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "abcd";
		String goal = "aaaa";
		boolean output = false;
		Assert.assertEquals((buddyStrings(s,goal)), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. If both strings are not equal, return false,
	 * 2. If both strings are equal, check if s has any character twice.
	 * 		-- If available, return true. Else false
	 * 3. If there are two different characters, add to variables
	 * 4. If there are more than two different characters, return false
	 * 5. After traversing is completed, if character at s diff1 is equal to goal diff2 and s diff2 is equal to goal diff2, return true
	 * 6. Else return false
	 * 
	 */	
	
	private Object buddyStrings(String s, String goal) {
		if(s.length() != goal.length()) return false;
	    if(s.equals(goal)){
	        int[] occurrences = new int[26];
	        for(int i=0;i<s.length();i++){ 
	            occurrences[s.charAt(i)-'a']++;
	            if(occurrences[s.charAt(i)-'a'] > 1) return true;
	        }
	        return false;
	    }
	    int index1=-1,index2=-1;
	    for(int i=0;i<s.length();i++){
			if(s.charAt(i) != goal.charAt(i)) {
				if(index1==-1) index1 = i;
	            else if (index2==-1) index2 = i;
	            else return false;
			}
		}
	        
		if (index2 == -1) return false;
	    if(s.charAt(index1)!=goal.charAt(index2)) return false;
	    return true;
	    
	}

	
}
