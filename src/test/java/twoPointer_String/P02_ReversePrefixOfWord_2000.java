package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P02_ReversePrefixOfWord_2000 {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode #2000
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
		String word = "abcdefg";
		char ch = 'd';
		String output = "dcbaefg";
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String word = "dabcefgd";
		char ch = 'd';
		String output = "dabcefgd";
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String word = "abcefgd";
		char ch = 'd';
		String output = "dgfecba";
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String word = "abcefg";
		char ch = 'd';
		String output = "abcefg";
	}
	
	@Test
	public void positive3() {
		//Positive Test Data
		String word = "abcdddefg";
		char ch = 'd';
		String output = "dcbaddefg";
	}
	
	@Test
	public void edge2() {
		//Positive Test Data
		String word = "a";
		char ch = 'd';
		String output = "a";
		Assert.assertEquals(reversePrefixWord(word,ch), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Convert given word into charArray
	 * 2. Using a pointer, find the first index where ch occurs
	 * 3. If the first occurrence happens at 0th index or doesn't happen at all,
	 * 		return the original array itself
	 * 4. Create two pointers, left=0 and right=first index of ch
	 * 5. Traverse while left<right
	 * 6. Swap the characters, increment left and decrement right
	 * 7. return the character array as String
	 * 
	 */	
	
	public String reversePrefixWord(String word,char ch) {
		int index=0;                                         //O(1)
        char[] charArray = word.toCharArray();				 //O(n)
        while(index<charArray.length){                       //O(n)
            if(charArray[index]==ch)                         //O(1)
                break;										 //O(1)
            else index++;									 //O(1)
        }
        //Index of first occurrence found from above steps
        int left=0,right=index;								 //O(1)
        //If the index falls at 0th index or not available, returning given input itself as no swap is required
        if(right==0 || right>=charArray.length) return word; //O(1)
        char temp = '0';									 //O(1)
        while(left<right){									 //O(m) m = index-0
            temp = charArray[left];							 //O(1)
            charArray[left++] = charArray[right];			 //O(1)
            charArray[right--] = temp;						 //O(1)
        }
        return String.valueOf(charArray);					 //?
	}
}
