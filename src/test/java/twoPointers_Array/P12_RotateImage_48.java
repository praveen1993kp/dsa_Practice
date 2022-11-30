package twoPointers_Array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P12_RotateImage_48 {

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
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] output = {{7,4,1},{8,5,2},{9,6,3}};
		Assert.assertTrue(Arrays.deepEquals(rotateImage(matrix), output));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		int[][] output = {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
		Assert.assertTrue(Arrays.deepEquals(rotateImage(matrix), output));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[][] matrix = {{5}};
		int[][] output = {{5}};
		Assert.assertTrue(Arrays.deepEquals(rotateImage(matrix), output));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. For each array in matrix, reverse the elements of matrix[i]
	 * 2. Create 4 pointers l1,l2=0 and r1,r2=matrix.length-1
	 * 3. Swap the last values of each matrix[i] and place it along the matrix[0]
	 * 4. When current element is reached, reset the pointers and start the step 3 from second last element and matrix[1]
	 * 5. Continue till l1<r1
	 * 6. Return matrix
	 * 
	 */	
	
	public int[][] rotateImage(int[][] matrix) {
		int len=matrix.length-1;
        for(int i=0;i<=len;i++){
            int left=0,right=len;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = temp;
            }
        }
        int l1=0,l2=0;
        int r1=len,r2=len;
        
        while(l1<r1){
            int temp = matrix[l1][l2];
            matrix[l1][l2] = matrix[r1][r2];
            matrix[r1][r2] = temp;
            l2++;
            r1--;
            
            if(l1==r1) {
                l1++;
                l2=0;
                r1=len;
                r2--;
            }
        }
        return matrix;
	}
}
