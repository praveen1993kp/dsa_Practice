package stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class S04_FinalPricesWithASpecialDiscountInShop_1475 {

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
		int[] prices = {8,4,6,2,3};
		int[] answer = {4,2,4,2,3};
		Assert.assertArrayEquals(finalPrices_stack(prices), answer);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[] prices = {8,4,6,8,7};
		int[] answer = {4,4,6,1,7};
		Assert.assertArrayEquals(finalPrices_stack(prices), answer);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		int[] prices = {8};
		int[] answer = {8};
		Assert.assertArrayEquals(finalPrices_stack(prices), answer);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] prices = {8,1};
		int[] answer = {7,1};
		Assert.assertArrayEquals(finalPrices_stack(prices), answer);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] prices = {4,6,7,8,9};
		int[] answer = {4,6,7,8,9};
		Assert.assertArrayEquals(finalPrices_stack(prices), answer);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		int[] prices = {4,6,7,8,9,0};
		int[] answer = {4,6,7,8,9,0};
		Assert.assertArrayEquals(finalPrices_stack(prices), answer);
	}
	
	@Test
	public void negative3() {
		//Negative Test Data
		int[] prices = {2,2,2,2,2};
		int[] answer = {0,0,0,0,2};
		Assert.assertArrayEquals(finalPrices_stack(prices), answer);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 1. Traverse through the elements of prices array
	 * 2. For each element in prices, when any of the consecutive elements is less than or equal to prices[i], find the difference and add into the array index i
	 * 3. Break the loop when <= value is found
	 * 4. Continue for all the elements in prices
	 * 5. Return prices
	 * 
	 * -- Stack --
	 * 1. Create a stack
	 * 2. Traverse through the elements of prices array
	 * 3. While stack is not empty and prices[i] is less than or equal to value in stack.peek, add it in the array
	 * 4. By default, push the index into stack
	 * 5. Return the array
	 * 
	 */	
	
	private int[] finalPrices(int[] prices) {
		for(int i=0;i<prices.length;i++){
			for(int j=i+1;j<prices.length;j++){
				if(prices[j] <= prices[i]){
					prices[i] -= prices[j];
					break;
				}
			}
		}
		return prices;
	}
	
	private int[] finalPrices_stack(int[] prices) {
		Stack<Integer> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                prices[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return prices;
	}

	
}
