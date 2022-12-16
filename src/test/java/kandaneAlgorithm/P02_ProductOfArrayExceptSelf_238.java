package kandaneAlgorithm;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P02_ProductOfArrayExceptSelf_238 {

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
		int[] nums = {5,1,4,2};
		int[] output = {8,40,10,20};
		Assert.assertTrue(Arrays.equals(product(nums), output));
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		int[] nums = {5};
		int[] output = {1};
		Assert.assertTrue(Arrays.equals(product(nums), output));
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums = {5,1,0,4,2};
		int[] output = {0,0,40,0,0};
		Assert.assertTrue(Arrays.equals(product(nums), output));
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] nums = {0,0,0,1};
		int[] output = {0,0,0,0};
		Assert.assertTrue(Arrays.equals(product(nums), output));
	}
	
	@Test
	public void edge4() {
		//Edge Case Test Data
		int[] nums = {-1,1,0,-3,3};
		int[] output = {0,0,9,0,0};
		Assert.assertTrue(Arrays.equals(product(nums), output));
	}
	
	
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,1,1,1};
		int[] output = {1,1,1,1};
		Assert.assertTrue(Arrays.equals(product(nums), output));
	}
	
	/*
	 * Pseudo code: (Similar to kandane)
	 * 1. Create a product array for output
	 * 2. Fill the array with value 1
	 * 3. Create a variable temp
	 * 4. Traverse through the elements of nums
	 *    a. Update current index value as temp
	 *    b. Product temp with current nums value
	 * 5. Traverse from the end of array after reassigning temp
	 *    a. multiply product[i] with temp
	 *    b. Product temp with current nums value
	 * 6. return product
	 * 
	 */	
	
	public int[] product(int[] nums){
		int[] product = new int[nums.length];
		Arrays.fill(product,1);
		
		int temp = 1;
		
		for(int i=0;i<nums.length;i++){
			product[i] = temp;
			temp *= nums[i];
		}
		
		temp = 1;
		for(int i=nums.length-1;i>=0;i--){
			product[i] *= temp;
			temp *= nums[i];
		}
		System.out.println(Arrays.toString(product));
		return product;
	}
}
