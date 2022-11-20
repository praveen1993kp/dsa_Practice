package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P15_RomanToInteger_13 {

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
		String s = "III";
		int output = 3;
		Assert.assertEquals(romanToInteger(s),output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "MMMCMXCIX";
		int output = 3999;
		Assert.assertEquals(romanToInteger(s),output);
	}
	
	@Test
	public void positive2() {
		//Edge Test Data
		String s = "CDXI";
		int output = 411;
		Assert.assertEquals(romanToInteger(s),output);
	}
	
	@Test
	public void edge3() {
		//Negative Test Data
		String s = "LVIII";
		int output = 58;
		Assert.assertEquals(romanToInteger(s),output);
	}
	
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "MCMXCIV";
		int output = 1994;
		Assert.assertEquals(romanToInteger(s),output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Add all the allowed roman letters into hashmap(Including the combinations)
	 * 2. Create pointers left=0 and right=1
	 * 3. Traverse while left<s.length()
	 * 4. If right<s.length(), check if left character + right character together is a key in hashmap
	 * 		If available, add the value into key
	 * 		Else, add the value of left alone. Increment left and right
	 * 5. Else add the value of left
	 * 6. Increment left and right
	 * 7. Return the convertedNum
	 * 
	 * -- Method 2 --
	 * 
	 * 1. Add only unique elements into hashmap
	 * 2. If combination is found, add the right value and subtract the left value
	 * 
	 */	
	
	private int romanToInteger(String s) {
		Map<String,Integer> romanLetters = new HashMap<>();
        romanLetters.put("I",1);
        romanLetters.put("V",5);
        romanLetters.put("X",10);
        romanLetters.put("L",50);
        romanLetters.put("C",100);
        romanLetters.put("D",500);
        romanLetters.put("M",1000);
        romanLetters.put("IV",4);
        romanLetters.put("IX",9);
        romanLetters.put("XL",40);
        romanLetters.put("XC",90);
        romanLetters.put("CD",400);
        romanLetters.put("CM",900);
        
        int left=0,right=1;
        int convertedNum = 0;
        String currLeft = "";
        String currRight="";
        while(left<s.length()){
            currLeft = Character.toString(s.charAt(left));
            if(right<s.length()) currRight = Character.toString(s.charAt(right));
            else currRight = "";
            if(romanLetters.containsKey(currLeft+currRight)){
                convertedNum += romanLetters.get(currLeft+currRight);
                left++;
                right++;
            } else convertedNum += romanLetters.get(currLeft);
            left++;
            right++;
        }
		return convertedNum;
	}
	
	private int romanToInteger_method2(String s) {
		Map<Character,Integer> romanLetters = new HashMap<>();
        romanLetters.put('I',1);
        romanLetters.put('V',5);
        romanLetters.put('X',10);
        romanLetters.put('L',50);
        romanLetters.put('C',100);
        romanLetters.put('D',500);
        romanLetters.put('M',1000);
        
        int convertedNum = 0;
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1 && ch[i]=='I' && (ch[i+1]=='V' || ch[i+1]=='X')){
                convertedNum += romanLetters.get(ch[i+1]) - romanLetters.get(ch[i]);
                i++;
            } else if (i<s.length()-1 && ch[i]=='X' && (ch[i+1]=='L' || ch[i+1]=='C')){
                convertedNum += romanLetters.get(ch[i+1]) - romanLetters.get(ch[i]);
                i++;
            } else if (i<s.length()-1 && ch[i]=='C' && (ch[i+1]=='D' || ch[i+1]=='M')){
                convertedNum += romanLetters.get(ch[i+1]) - romanLetters.get(ch[i]);
                i++;
            } else convertedNum += romanLetters.get(ch[i]);
        }
        return convertedNum;
	}

	
}
