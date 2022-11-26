package stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class S06_CrawlerLogFolder_1598 {

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
		String[] logs = {"d1/","d2/","../","d21/","./"};
		int output = 2;
		Assert.assertEquals(findMinOperations_UsingStack(logs), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String[] logs = {"d1/","d2/","../","../","./"};
		int output = 0;
		Assert.assertEquals(findMinOperations_UsingStack(logs), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String[] logs = {"../","../","../","./"};
		int output = 0;
		Assert.assertEquals(findMinOperations_UsingStack(logs), output);
	}
	
	@Test
	public void negative() {
		//Edge Case Test Data
		String[] logs = {"../","../","../","./"};
		int output = 0;
		Assert.assertEquals(findMinOperations_UsingStack(logs), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Approach 1 -- (Without Stack)
	 * 1. Create counter=0
	 * 2. Traverse through each element in logs
	 * 3. If ../ is found, and counter is not 0, decrement counter
	 * 4. Else if string is not ./, increment the counter
	 * 5. return counter.
	 * 
	 * Time: O(n)
	 * Space: O(n)
	 * 
	 * -- Approach 2 -- (Using stack)
	 * 1. Create stack
	 * 2. Traverse through each element in logs
	 * 3. If ../ is found, and stack is not empty, pop from stack
	 * 4. Else if string is not ./, increment the counter
	 * 5. return the stack size.
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 */	
	
	private int findMinOperations_UsingStack(String[] logs) {
		Stack<String> stack = new Stack<>();
        int i=0;
        while(i<logs.length){
            if(logs[i].equals("../")){
                if(!stack.isEmpty()) stack.pop();
            } else if (!logs[i].equals("./")){
                stack.push(logs[i]);
            }
            i++;
        }
        return stack.size();
	}
	
	private int findMinOperations_WithoutStack(String[] logs) {
		int i=0;
        int counter=0;
        while(i<logs.length){
            if(logs[i].equals("../")) {
                if(counter!=0) counter--;
            } else if (!logs[i].equals("./")) counter++;
            i++;
        }
		return counter;
	}

	
}
