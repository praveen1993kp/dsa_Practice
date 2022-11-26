package stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class S05_MakeTheStringGreat_1544 {

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
		String s = "leEeetcode";
		String out = "leetcode";
		Assert.assertEquals(makeTheStringGreat(s), out);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		String s = "abBAcC";
		String out = "";
		Assert.assertEquals(makeTheStringGreat(s), out);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String s = "s";
		String out = "s";
		Assert.assertEquals(makeTheStringGreat(s), out);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String s = "aabbcc";
		String out = "aabbcc";
		Assert.assertEquals(makeTheStringGreat(s), out);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * //If length is less than 2, return s
	 * //Create a pointer i=0
	 * //if the stack is empty, push into stack
	 * //If the stack is not empty, check if the current value is counter value of stack.peek
	 * //Traverse and continue till length < s.length()
	 * //Pop all elements and reverse in string buffer
	 * 
	 * Time: O(n)
	 * Space: O(n)
	 * 
	 */	
	
	private String makeTheStringGreat(String s) {
		if(s.length() < 2) return s;
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i))==32) {
                    stack.pop(); 
            } else stack.push(s.charAt(i));
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
	}

	
}
