package sortingMethods;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class S06_SortThePeople_2418 {

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
		String[] names = {"Mary","John","Emma"};
		int[] heights = {180,165,170};
		String[] output = {"Mary","Emma","John"};
		Assert.assertEquals(sortThePeople(names,heights), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String[] names = {"Alice","Bob","Bob"};
		int[] heights = {155,185,150};
		String[] output = {"Bob","Alice","Bob"};
		Assert.assertEquals(sortThePeople(names,heights), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[] names = {"Alice"};
		int[] heights = {155};
		String[] output = {"Alice"};
		Assert.assertEquals(sortThePeople(names,heights), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Method 1 - Using additional arrays --
	 * 
	 * 1. Get the values of heights into another array
	 * 2. Create an empty array to hold names after sorting
	 * 3. Sort the values of sortedHeights
	 * 4. Traverse through each value of sortedHeights and when the value matches with heights, add the names at that index into output string array
	 * 5. Continue step 4 for all the heights in sortedHeights
	 * 6. return the output string array
	 * 
	 * -- Method 2 - Using hashMap --
	 * 
	 * 1. Create a hashMap
	 * 2. Add heights as key and names as values
	 * 3. Sort the heights array. (Using any of the sort methods)
	 * 4. For each value in heights, get its value from hashmap and add into names index (Note that descending order is required)
	 * 5. return names
	 * 
	 */	
	
	public String[] sortThePeople(String[] names,int[] heights) {
		int[] sortedHeights = Arrays.copyOf(heights,heights.length);
        String[] outputNames = new String[heights.length];
        for(int i=0;i<sortedHeights.length;i++){
            for(int j=i+1;j<sortedHeights.length;j++){
                if(sortedHeights[i] < sortedHeights[j]) {
                    int temp = sortedHeights[i];
                    sortedHeights[i] = sortedHeights[j];
                    sortedHeights[j] = temp;
                }
            }
        }
        for(int i=0;i<sortedHeights.length;i++){
            for(int j=0;j<heights.length;j++){
                if(sortedHeights[i]==heights[j]){
                    outputNames[i] = names[j];
                    break;
                }
            }
        }
        return outputNames;
    }
	
	public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> hMap = new HashMap<>();
        for(int i=0;i<heights.length;i++)
            hMap.put(heights[i],names[i]);
        
        Arrays.sort(heights);
        int index = 0;
        for(int i=heights.length-1;i>=0;i--)
            names[index++] = hMap.get(heights[i]);
        
        return names;
    }
	
}
