package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P05_ReverseVowelsOfAString_345 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given a string s, reverse only all the vowels in the string and return it.

		The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
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
	public void positive1() {
		//Positive Test Data
		String s = "hello";
		String output = "holle";
		Assert.assertEquals(reverseVowels_bruteForce(s), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String s = "aeiou";
		String output = "uoiea";
		Assert.assertEquals(reverseVowels_bruteForce(s), output);
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		String s = "TeStInG";
		String output = "TIStenG";
		Assert.assertEquals(reverseVowels_bruteForce(s), output);
	}
	
	@Test
	public void positive4() {
		//Positive Test Data
		String s = "!@12A= e[]";
		String output = "!@12e= A[]";
		Assert.assertEquals(reverseVowels_bruteForce(s), output);
	}
	
	@Test
	public void negative1() {
		//Negative Test Data
		String s = "cysts";
		String output = "cysts";
		Assert.assertEquals(reverseVowels_bruteForce(s), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		String s = "S";
		String output = "S";
		Assert.assertEquals(reverseVowels_bruteForce(s), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String s = "A";
		String output = "A";
		Assert.assertEquals(reverseVowels_bruteForce(s), output);
	}


	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 1. Create a string revVowelsfor output
	 * 2. Start from the end of given string. If vowel found, append. Continue till i>=0
	 * 3. Start from the start of given string. If vowel found, append first char from revVowels
	 * 4. Return given string
	 * 
	 * --Two Pointer--
	 * 
	 * Create two pointers left=0 and right= s.length()-1
	 * When the character in left is not vowel, increment left
	 * When the character in right is not vowel, decrement right
	 * When both the characters are vowel, swap them
	 * Continue till left<right
	 * 
	 */	
	
	private String reverseVowels_bruteForce(String s) {
		String revVowels = "";
		for(int i=s.length()-1;i>=0;i--) {
			if(isVowel(s.charAt(i))) revVowels += s.charAt(i);
		}
		
		char ch[] = s.toCharArray();
		int index=0;
		for(int i=0;i<s.length();i++) {
			if(isVowel(ch[i])) ch[i] = revVowels.charAt(index++);
		}
		
		return String.valueOf(ch);
	}
	
	
	
	private String reverseVowels(String s) {
		int left=0,right=s.length()-1;
        char[] ch = s.toCharArray();
        char temp = '0';
        while(left<right){
            if(!isVowel(ch[left])) left++;
            if(!isVowel(ch[right])) right--;
            if(isVowel(ch[left]) && isVowel(ch[right])){
                temp =  ch[left];
                ch[left++] = ch[right];
                ch[right--] = temp;
            }
            
        }
        return String.valueOf(ch);
	}
	
	public static boolean isVowel(char c){
	       return (c=='a' || c=='A' || c=='e' || c=='E' || c=='i' ||
	    		   c=='I' || c=='o' || c=='O' || c== 'u' || c=='U');
	    }
}
