package stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class S02_BaseBallGame_682 {

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
		String[] ops = {"5","2","C","D","+"};
		int output = 30;
		Assert.assertEquals(output, scoreCalculation(ops));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		int output = 27;
		Assert.assertEquals(output, scoreCalculation(ops));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[] ops = {"1"};
		int output = 1;
		Assert.assertEquals(output, scoreCalculation(ops));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a stack
	 * 2. Traverse through the given string array
	 * 3. If the current string is D, double the value of peek
	 * 4. If the current string is C, pop the value
	 * 5. If the current string is +, 
	 * 		i) pop the latest value
	 * 		ii) sum peek plus pop
	 * 		iii) push popped value into stack
	 * 		iv) push sum into stack
	 * 6. Else, push the Integer value of current string in stack
	 * 7. After traversing through all the values of operations, add each value into sum by popping up from stack
	 * 8. return the sum
	 * 
	 * 
	 */	
	
	private int scoreCalculation(String[] operations) {
		Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("D")){
                stack.push(stack.peek() * 2);
            } else if (operations[i].equals("C")){
                stack.pop();
            } else if (operations[i].equals("+")){
                Integer tempVal = stack.pop();
                Integer currVal = stack.peek() + tempVal;
                stack.push(tempVal);
                stack.push(currVal);
            } else stack.push(Integer.valueOf(operations[i]));
        }
        
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
	}

}
