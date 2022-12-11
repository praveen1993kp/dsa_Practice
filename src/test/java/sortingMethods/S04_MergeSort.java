package sortingMethods;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class S04_MergeSort {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * https://github.com/TestLeafSDET/SDET_3_2022/blob/master/src/main/java/week9/day17/MergeSort.java
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
		//Assert.assertTrue(Arrays.equals(mergeSort(nums), output));
		mergeSort(nums);
		
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-5,4,3,2,1};
		int[] output = {-5,1,2,3,4};
		int[] descendingOutput = {4,3,2,1,-5};
		//Assert.assertTrue(Arrays.equals(mergeSort(nums), output));
		//Assert.assertTrue(Arrays.equals(sortArray_method2(nums), descendingOutput));
		mergeSort(nums);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[] nums = {-5,1,2,-5,-5};
		int[] output = {-5,-5,-5,1,2};
		int[] descendingOutput = {2,1,-5,-5,-5};
		//Assert.assertTrue(Arrays.equals(mergeSort(nums), output));
		//Assert.assertTrue(Arrays.equals(sortArray_method2(nums), descendingOutput));
		mergeSort(nums);
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		int[] nums = {-5};
		int[] output = {-5};
		int[] descendingOutput = {-5};
		//Assert.assertTrue(Arrays.equals(mergeSort(nums), output));
		//Assert.assertTrue(Arrays.equals(sortArray_method2(nums), descendingOutput));
		mergeSort(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int[] output = {1,2,3};
		int[] descendingOutput = {3,2,1};
		//Assert.assertTrue(Arrays.equals(mergeSort(nums), output));
		//Assert.assertTrue(Arrays.equals(sortArray_method2(nums), descendingOutput));
		mergeSort(nums);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse using two loops
	 * 2. For each element in i, if any of the consecutive element is lesser, swap them
	 * 3. Continue till length of nums
	 * 4. Increment i and continue steps 2-3 till length ofnums
	 * 5. return nums
	 * 
	 */	
	
	
	
	public void sortArray_mergeSort(int[] nums,int start,int end) {
		if(start<end) {
			int mid = (start+end)/2;
			
			sortArray_mergeSort(nums,start,mid);
			sortArray_mergeSort(nums,mid+1,nums.length-1);
			merge(nums,start,mid,end);
		}
		
	}
	
	void merge(int[] input, int start, int mid, int end){
        int temp[] = new int[end-start+1];

        int leftArrayIndex = start, rightArrayIndex = mid+1, tempArrayIndex = 0;

        while( leftArrayIndex <= mid && rightArrayIndex <= end){
            if(input[leftArrayIndex] < input[rightArrayIndex])
                temp[tempArrayIndex++] = input[leftArrayIndex++];
            else
                temp[tempArrayIndex++] = input[rightArrayIndex++];
        }

        while(leftArrayIndex <= mid)
            temp[tempArrayIndex++] = input[leftArrayIndex++];

        while(rightArrayIndex <= end)
            temp[tempArrayIndex++] = input[rightArrayIndex++];


        for(int i =start; i<=end;i++){
            input[i] = temp[i-start];
        }
    }
	
	public void mergeSort(int[] nums) {
		 sortArray_mergeSort(nums,0,nums.length-1);
		 System.out.println(Arrays.toString(nums));
	}
	
	
}
