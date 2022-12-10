package sortingMethods;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class S01_SelectionSort {

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
		int[] nums = {5,4,3,2,1};
		int[] output = {1,2,3,4,5};
		int[] descendingOutput = {5,4,3,2,1};
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort_descending(nums), descendingOutput));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-5,4,3,2,1};
		int[] output = {-5,1,2,3,4};
		int[] descendingOutput = {4,3,2,1,-5};
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort_descending(nums), descendingOutput));
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums = {-5,1,2,-5,-5};
		int[] output = {-5,-5,-5,1,2};
		int[] descendingOutput = {2,1,-5,-5,-5};
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort_descending(nums), descendingOutput));
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] nums = {-5};
		int[] output = {-5};
		int[] descendingOutput = {-5};
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort_descending(nums), descendingOutput));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int[] output = {1,2,3};
		int[] descendingOutput = {3,2,1};
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_SelectionSort_descending(nums), descendingOutput));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse using two loops
	 * 2. Take minimum index as current element index
	 * 3. Traverse from next element and update minimum index
	 * 4. Swap the values between current and minimum index
	 * 5. Continue for all the elements till length-1
	 * 6. return nums
	 * 
	 * -- Descending --
	 * 
	 * 1. Traverse through two loops
	 * 2. Take max value as current index value
	 * 3. Traverse through i+1 and see if there is any value greater than max. Then reassign max index
	 * 4. Once all elements are traversed, do swapping
	 * 5. Continue for all the elements till n-1
	 * 6. return nums
	 * 
	 * 
	 */	
	
	public int[] sortArray_SelectionSort(int[] nums) {
		int temp = 0;
		for(int i=0;i<nums.length;i++) {
			int min = i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[min] > nums[j]) min = j;	
			}
			temp = nums[i];
			nums[i] = nums[min];
			nums[min] = temp;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	public int[] sortArray_SelectionSort_descending(int[] nums) {
		int temp = 0;
		for(int i=0;i<nums.length;i++) {
			int max = i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[max] < nums[j]) max = j;	
			}
			temp = nums[i];
			nums[i] = nums[max];
			nums[max] = temp;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
