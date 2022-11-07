package slidingWindow_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class S07_FindAllAnagramsInAString_438 {

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
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> output = Arrays.asList(0,6);
		Assert.assertEquals(findAnagrams(s,p), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		String s = "abc";
		String p = "abcabc";
		List<Integer> output = Arrays.asList();
		Assert.assertEquals(findAnagrams(s,p), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String s = "abc";
		String p = "a";
		List<Integer> output = Arrays.asList(0);
		Assert.assertEquals(findAnagrams(s,p), output);
	}
	
	@Test
	public void negative() {
		//Edge Case Test Data
		String s = "cbaebabacd";
		String p = "abbabaab";
		List<Integer> output = Arrays.asList();
		Assert.assertEquals(findAnagrams(s,p), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		String s = "a";
		String p = "b";
		List<Integer> output = Arrays.asList();
		Assert.assertEquals(findAnagrams(s,p), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Create list for output
	 * 2. If p.length() > s.length(), return the list
	 * 3. Create two ascii arrays of size 26 each
	 * 4. Traverse through the p string and add elements into ascii
	 * 5. Traverse through the s string and while the length
	 * 
	 * 
	 * -- Sliding window --
	 * 
	 * 1. Create list for output. If p.length() > s.length(), return the list
	 * 2. Create two ascii arrays of size 26 each
	 * 3. Create pointer pointer = 0
	 * 4. Traverse for the length of p using the pointer and add the elements into respective arrays
	 * 5. Check if both arrays are equal, if true, add the index into list
	 * 6. Traverse from pointer current location till s.length()-p.length()
	 * 7. Add the character at pointer location and delete the character from ascii array2 at pointer-p.length() location
	 * 8. Add the index into list when both arrays are equal
	 * 9. Return the list
	 * 
	 */	
	
	private List<Integer> findAnagrams(String s, String p) {
		List<Integer> lst = new ArrayList<>();
        if(p.length() > s.length()) return lst;
        int len = p.length();
        int[] ascii1 = new int[26];
        int[] ascii2 = new int[26];
        
        for(int i=0;i<p.length();i++){
            ascii1[p.charAt(i)-'a']++;
        }
        
        for(int j=0;j<s.length()-len+1;j++){
            ascii2 = new int[26];
            for(int k=j;k<j+len;k++){
                ascii2[s.charAt(k)-'a']++;
            }
            if(Arrays.equals(ascii1,ascii2)) lst.add(j);
        }
		return lst;
	}
	
	private List<Integer> findAnagrams_slidingWindow(String s, String p) {
		List<Integer> lst = new ArrayList<>();
        if(p.length() > s.length()) return lst;
        int len = p.length(),pointer = 0;
        int[] pArray = new int[26];
        int[] sArray = new int[26];
        
        while(pointer<len) {
        	pArray[p.charAt(pointer)-'a']++;
        	sArray[s.charAt(pointer++)-'a']++;
        }
        if(Arrays.equals(sArray,pArray)) lst.add(0);
        
        while(pointer<s.length()){
            sArray[s.charAt(pointer)-'a']++;
            sArray[s.charAt(pointer-len)-'a']--;
            if(Arrays.equals(sArray,pArray)) lst.add(pointer-len+1);
            pointer++;
        }
        
        
		return lst;
	}
	
	
	private List<Integer> findAnagrams_slidingWindow_WithoutArrayEqualsMethod(String s, String p) {
		List<Integer> lst = new ArrayList<>();
        if(p.length() > s.length()) return lst;
        int len = p.length(),pointer = 0;
        int[] pArray = new int[26];
        int[] sArray = new int[26];
        
        while(pointer<len) {
        	pArray[p.charAt(pointer)-'a']++;
        	sArray[s.charAt(pointer++)-'a']++;
        }
        if(areArraysEqual(sArray,pArray)) lst.add(0);
        
        while(pointer<s.length()){
            sArray[s.charAt(pointer)-'a']++;
            sArray[s.charAt(pointer-len)-'a']--;
            if(areArraysEqual(sArray,pArray)) lst.add(pointer-len+1);
            pointer++;
        }
        
        
		return lst;
	}
	
	public boolean areArraysEqual(int[] sArray, int[] pArray) {
		int left=0,right=sArray.length-1;
		while(left<right) {
			if(sArray[left]!=pArray[left]) return false;
			if(sArray[right]!=pArray[right]) return false;
			left++;
			right--;
		}
		return true;
	}

	
}
