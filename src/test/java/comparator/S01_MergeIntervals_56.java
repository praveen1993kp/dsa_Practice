package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class S01_MergeIntervals_56 {

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
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] output = {{1,6},{8,10},{15,18}};
		Assert.assertTrue(Arrays.deepEquals(mergeIntervals(intervals), output));
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		int[][] intervals = {{1,3},{3,6},{6,10},{10,18}};
		int[][] output = {{1,18}};
		Assert.assertTrue(Arrays.deepEquals(mergeIntervals(intervals), output));
	}
	
	@Test
	public void negative() {
		//Negative Case Test Data
		int[][] intervals = {{1,3},{4,6},{7,10},{16,18}};
		int[][] output = {{1,3},{4,6},{7,10},{16,18}};
		Assert.assertTrue(Arrays.deepEquals(mergeIntervals(intervals), output));
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		int[][] intervals = {{1,3}};
		int[][] output = {{1,3}};
		Assert.assertTrue(Arrays.deepEquals(mergeIntervals(intervals), output));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given array using start time as parameter for comparator
	 * 2. Create a list of int array
	 * 3. Get instance of interval[0] in current_Interval
	 * 4. Add current_Interval into list (Shallow copy)
	 * 5. Traverse through each interval
	 * 6. Get the values of current_Start, current_End from current_Interval values
	 * 7. Get the values of next_Start, next_End from interval
	 * 8. Compare if current_End is greater than or equal to next_Start. If so, assign the maximum end value to current_Interval[1]
	 * 9. Else, update current_Interval with current value. Add into list
	 * 10. return list as array
	 * 
	 */	
	
	public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> lst = new ArrayList<>();
        int[] current_Interval = intervals[0];
        lst.add(current_Interval);

        for(int[] interval : intervals){
            int current_start = current_Interval[0];
            int current_end = current_Interval[1];
            int next_start = interval[0];
            int next_end = interval[1];

            if(current_end >= next_start){
                current_Interval[1] = Math.max(current_end,next_end);
            } else {
                current_Interval = interval;
                lst.add(current_Interval);
            }
        }
        return lst.toArray(new int[lst.size()][]);
    }
}
