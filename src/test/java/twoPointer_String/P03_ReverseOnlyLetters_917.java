package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P03_ReverseOnlyLetters_917 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode #917
	 * 
	 * Given a string s, reverse the string according to the following rules:

		All the characters that are not English letters remain in the same position.
		All the English letters (lowercase or uppercase) should be reversed.
		Return s after reversing it.
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
		String s = "ab-cd";
		String output = "dc-ba";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "-a";
		String output = "-a";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "-a@b$cABC";
		String output = "-C@B$Acba";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void positive2() {
		//Negative Test Data
		String s = "abc1234e";
		String output = "ecb1234a";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		String s = "-12343421348";
		String output = "-12343421348";
		Assert.assertEquals(reverseLetters(s), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Convert the input word into charArray
	 * 2. Start from the end of string and reverse only letters and store in a variable
	 * 3. Convert reversedLetters into charArray
	 * 4. Traverse again from the start of input letter till the end
	 * 5. When character is found, add the first character from reversedLetters Array and so on
	 * 6. Return the input character array as string
	 * 
	 * -- Two Pointers --
	 * 
	 * 1. Create two pointers at extreme ends
	 * 2. Convert given word into character array
	 * 3. Traverse while left<right
	 * 4. When left is character and right is character
	 * 		- Swap and increment left, decrement right
	 * 5. When left is not character, increment left
	 * 6. When right is not character, decrement right
	 * 7. Return the value of character array
	 * 
	 */
	
	private String reverseLetters_bruteForce(String s) {
		String output = "";
		char[] str = s.toCharArray();
		for(int i=s.length()-1;i>=0;i--) {
			if(Character.isAlphabetic(str[i])) output += str[i];
		}
		
		int outputIndex=0;
		char[] reversedLetters = output.toCharArray();
		
		for(int i=0;i<s.length();i++) {
			if(Character.isAlphabetic(str[i])) {
				str[i] = reversedLetters[outputIndex++];
			}				
		}
        return String.valueOf(str);   //?;
	}
	
	private String reverseLetters(String s) {
		int left=0,right=s.length()-1; //O(1)
        char[] ch = s.toCharArray();  //O(n)
        char temp = '0';  //O(1)
        while(left<right){   //O(n/2)
            if(Character.isAlphabetic(ch[left]) && Character.isAlphabetic(ch[right])){  //O(1)
                temp = ch[left];   //O(1)
                ch[left++] = ch[right];   //O(1)
                ch[right--] = temp;   //O(1)
            } else{
                if(!Character.isAlphabetic(ch[left])) left++;  //O(1)
                else right--;    //O(1)
            }        
        }
        return String.valueOf(ch);   //?;
	}

	
}
