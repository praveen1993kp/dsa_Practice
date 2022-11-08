package slidingWindow_Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class S09_LongestSubstringWithoutRepeatingCharacters_3 {

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
		String s = "abcabcbb";
		int output = 3;
		Assert.assertEquals(longestSubstring(s), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String s = "aabbc";
		int output = 2;
		Assert.assertEquals(longestSubstring(s), output);
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		String s = "bbaabcdefgaabb";
		int output = 7;
		Assert.assertEquals(longestSubstring(s), output);
	}
	
	@Test
	public void negative() {
		//Negative Case Test Data
		String s = "";
		int output = 0;
		Assert.assertEquals(longestSubstring(s), output);
	}
	
	@Test
	public void edge() {
		//Negative Case Test Data
		String s = "bbab!23 c";
		int output = 7;
		Assert.assertEquals(longestSubstring(s), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create variable maxLength
	 * 2. Traverse through the given string
	 * 3. Create a set everytime and add current element into it
	 * 4. Create pointers left=i-1 and right=i+1
	 * 5. With current element at centre, traverse while right and left produces unique characters
	 * 6. Make sure left and right are within the boundary range
	 * 7. At the end of inner loop, calculate maxLength
	 * 8. Return maxLength
	 * 
	 * -- Sliding Window --
	 * 
	 * 1. Create pointers left=0 and right=0
	 * 2. Create variable maxLength
	 * 3. Create a hashMap to store Characters and their occurrence
	 * 4. For each right value, add the character and its occurrence into hashmap
	 * 5. When the number of keys in hashmap is equal to right-left+1, calculate the maxLength
	 * 6. Else, while the values are not equal, remove the value of left from hashmap and increment left.
	 * 7. When the value of character at left becomes 0, remove it from hashmap
	 * 8. Increment right by default
	 * 9. Return maxLength
	 * 
	 */	
	
	
	
	private int longestSubstring(String s) {
		int maxLength = 0;
		for(int i=0;i<s.length();i++){
			Set<Character> hSet = new HashSet<>();
			hSet.add(s.charAt(i));
			int left=i-1,right=i+1;
			int currLength = 1;
			while(left>=0){
				hSet.add(s.charAt(left));
				if(hSet.size()>currLength) currLength = hSet.size();
				else break;
			}
			while(right<s.length())	{
				hSet.add(s.charAt(right));
				if(hSet.size()>currLength) currLength = hSet.size();
				else break;
				
				left--;
				right++;
			}
			maxLength = Math.max(currLength,maxLength);
		}
	return maxLength;
	}
	
	private int longestSubstring_SlidingWindow(String s) {
		int left=0,right=0;
        Map<Character,Integer> hMap = new HashMap<>();
        int maxLength = 0;
        
        while(right<s.length()){
            hMap.put(s.charAt(right),hMap.getOrDefault(s.charAt(right),0)+1);
            if(hMap.keySet().size()==right-left+1){
                if(maxLength < right-left+1) maxLength = right-left+1;
            } else{
                while(hMap.size()!=right-left+1){
                    hMap.put(s.charAt(left),hMap.get(s.charAt(left))-1);
                    if(hMap.get(s.charAt(left))==0) hMap.remove(s.charAt(left));
                    left++;
                }
            }
            right++;
        }
        return maxLength;
	}
	
}
