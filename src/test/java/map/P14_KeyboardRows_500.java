package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class P14_KeyboardRows_500 {

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
		String[] words = {"Hello","Alaska","Dad","Peace"};
		String[] output = {"Alaska","Dad"};
		Assert.assertTrue(Arrays.equals(keyboardRows(words), output));
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String[] words = {"adsdf","sfd"};
		String[] output = {"adsdf","sfd"};
		Assert.assertTrue(Arrays.equals(keyboardRows(words), output));
	}
	
	@Test
	public void negative() {
		//Negative Case Test Data
		String[] words = {"Hello"};
		String[] output = {};
		Assert.assertTrue(Arrays.equals(keyboardRows(words), output));
	}
	
	@Test
	public void edge() {
		//Edge Test Data
		String[] words = {"A"};
		String[] output = {"A"};
		Assert.assertTrue(Arrays.equals(keyboardRows(words), output));
	}
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a method, which will take given conditions as input and return the value
	 * 2. Create a list and flag=true
	 * 3. Traverse through all the words in words
	 * 4. For the first character, get the range
	 * 5. For all the characters in the word, if any of the word is in another range, mark flag as false and break
	 * 6. Only when flag is true, add into list
	 * 7. Continue steps 4-6 for all the words in given array
	 * 8. Return the output as array
	 * 
	 */	
	
	private String[] keyboardRows(String[] words) {
		int currVal = 0;
        List<String> lst = new ArrayList<>();
        char currChar = 0;
        boolean flag = true;
        for(int i=0;i<words.length;i++){       
            currChar = Character.isUpperCase(words[i].charAt(0)) ? Character.toLowerCase(words[i].charAt(0)) : words[i].charAt(0);
            currVal = decideRow(currChar);
            flag = true;
            for(int j=1;j<words[i].length();j++){
                currChar = Character.isUpperCase(words[i].charAt(j)) ? Character.toLowerCase(words[i].charAt(j)) : words[i].charAt(j);
                if(decideRow(currChar) != currVal) {
                    flag = false;
                    break;
                }
            }
            if(flag) lst.add(words[i]);
        }
        
    String[] output = new String[lst.size()];
    for(int i=0;i<lst.size();i++){
        output[i] = lst.get(i);
    }
    return output;
	}
	
	public int decideRow(char ch){
        String topRow = "qwertyuiop";
        String midRow = "asdfghjkl";
        if(topRow.contains(ch+"")) return 1;
        else if(midRow.contains(ch+"")) return 2;
        else return 3;
    }
	
	private String[] keyboardRows_WithoutConvertingIntoUpperCase(String[] words) {
		int currVal = 0;
        List<String> lst = new ArrayList<>();
        char currChar = 0;
        boolean flag = true;
        for(int i=0;i<words.length;i++){       
            currChar = words[i].charAt(0);
            currVal = decideRow2(currChar);
            flag = true;
            for(int j=1;j<words[i].length();j++){
                currChar = words[i].charAt(j);
                if(decideRow2(currChar) != currVal) {
                    flag = false;
                    break;
                }
            }
            if(flag) lst.add(words[i]);
        }
        
    String[] output = new String[lst.size()];
    for(int i=0;i<lst.size();i++){
        output[i] = lst.get(i);
    }
    return output;
	}
	
	public int decideRow2(char ch){
        String topRow = "qwertyuiopQWERTYUIOP";
        String midRow = "asdfghjklASDFGHJKL";
        if(topRow.contains(ch+"")) return 1;
        else if(midRow.contains(ch+"")) return 2;
        else return 3;
    }
}
