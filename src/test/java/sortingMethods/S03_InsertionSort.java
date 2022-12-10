package sortingMethods;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class S03_InsertionSort {

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
		Assert.assertTrue(Arrays.equals(sortArray_InsertionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_BubbleSort_Descending(nums), descendingOutput));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-5,4,3,2,1};
		int[] output = {-5,1,2,3,4};
		int[] descendingOutput = {4,3,2,1,-5};
		Assert.assertTrue(Arrays.equals(sortArray_InsertionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_BubbleSort_Descending(nums), descendingOutput));
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums = {-5,1,2,-5,-5};
		int[] output = {-5,-5,-5,1,2};
		int[] descendingOutput = {2,1,-5,-5,-5};
		Assert.assertTrue(Arrays.equals(sortArray_InsertionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_BubbleSort_Descending(nums), descendingOutput));
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] nums = {-5};
		int[] output = {-5};
		int[] descendingOutput = {-5};
		Assert.assertTrue(Arrays.equals(sortArray_InsertionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_BubbleSort_Descending(nums), descendingOutput));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int[] output = {1,2,3};
		int[] descendingOutput = {3,2,1};
		Assert.assertTrue(Arrays.equals(sortArray_InsertionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_BubbleSort_Descending(nums), descendingOutput));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {3,6,2,1,-7};
		int[] output = {-7,1,2,3,6};
		int[] descendingOutput = {6,3,2,1,-7};
		Assert.assertTrue(Arrays.equals(sortArray_InsertionSort(nums), output));
		Assert.assertTrue(Arrays.equals(sortArray_BubbleSort_Descending(nums), descendingOutput));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Ascending --
	 * 1. Traverse from i=1 till nums.length
	 * 2. If current element less than previous element
	 * 3. Swap the current element till it is less than previous element or till element at index 1
	 * 4. continue for all the elements till nums length
	 * 5. return nums
	 * 
	 * -- Descending --
	 * 1. Traverse from i=1 till nums.length
	 * 2. If current element greater than previous element
	 * 3. Swap the current element till it is greater than previous element or till element at index 1
	 * 4. continue for all the elements till nums length
	 * 5. return nums
	 * 
	 * 
	 */	
	
	public int[] sortArray_InsertionSort(int[] nums) {
		int index=0,temp=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i] < nums[i-1]) {
				index = i;
				while(index>0 && nums[index] < nums[index-1]) {
					temp = nums[index];
					nums[index] = nums[index-1];
					nums[index-1] = temp;
					index--;
				}
			}
		}
		return nums;
	}
	
	public int[] sortArray_BubbleSort_Descending(int[] nums) {
		int index=0,temp=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i] > nums[i-1]) {
				index = i;
				while(index>0 && nums[index] > nums[index-1]) {
					temp = nums[index];
					nums[index] = nums[index-1];
					nums[index-1] = temp;
					index--;
				}
			}
		}
		return nums;
	}
	
	
}
