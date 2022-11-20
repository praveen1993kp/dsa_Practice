package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class S01_ValidParantheses_20 {

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
		String s = "{}";
		boolean output = true;
		Assert.assertEquals(isValidPalindrome_WithoutHashMap(s), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		String s = "[[}}";
		boolean output = false;
		Assert.assertEquals(isValidPalindrome_WithoutHashMap(s), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String s = "[";
		boolean output = false;
		Assert.assertEquals(isValidPalindrome_WithoutHashMap(s), output);
	}
	
	@Test
	public void positive2() {
		//Edge Case Test Data
		String s = "{[()()()({})]}";
		boolean output = true;
		Assert.assertEquals(isValidPalindrome_WithoutHashMap(s), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "[[}";
		boolean output = false;
		Assert.assertEquals(isValidPalindrome_WithoutHashMap(s), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Using HashMap --
	 * 
	 * If the length of s is odd, return false
	 * 1. Create a hashMap and add all the closing braces as key and opening braces as value
	 * 2. When opening bracket is found, add into stack
	 * 3. When closing bracket is found,
	 * 		i) If stack is empty, return false
	 * 		ii) Else check if the peek element matches the opening bracket of current closing bracket
	 * 				i) If matches, pop the element
	 * 				ii) If doesn't match, return false
	 * 4. After all traversing is done, return if stack is empty
	 * 
	 * -- Without HashMap --
	 * 
	 * 1. If the length of s is odd, return false
	 * 2. When opening bracket is found, add into stack
	 * 3. When closing bracket is found,
	 * 		i) If stack is empty, return false
	 * 		ii) Else check if the peek element matches the opening bracket of current closing bracket
	 * 				i) If matches, pop the element
	 * 				ii) If doesn't match, return false
	 * 4. After all traversing is done, return if stack is empty
	 * 
	 * 
	 */	
	
	private boolean isValidPalindrome(String s) {
		if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> hMap = new HashMap<>();
        hMap.put(')','(');
        hMap.put('}','{');
        hMap.put(']','[');
        
        for(char ch : s.toCharArray()){
            if(hMap.containsKey(ch)){
                if(stack.isEmpty()) return false;
                if(stack.peek()==hMap.get(ch)) 
                    stack.pop();
                else return false;
            } else stack.push(ch);
        }
		return stack.isEmpty();
	}
	
	private boolean isValidPalindrome_WithoutHashMap(String s) {
		if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch==')' || ch=='}' || ch==']'){
                if(stack.isEmpty()) return false;
                else {
                    int val = stack.peek();
                    if ((ch==')' && val=='(') || (ch=='}' && val=='{') || (ch==']' && val=='['))
                        stack.pop();
                    else return false;
                }     
            } else stack.push(ch);
        }
        return stack.isEmpty();
	}
}
