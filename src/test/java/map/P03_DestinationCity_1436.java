package map;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

public class P03_DestinationCity_1436 {

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
	public void positive1() {
		//Positive Test Data
		String[][] paths = {{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
		String output = "Sao Paulo";
		Assert.assertEquals(destinationCity_Map(paths), output);
	}
	
	@Test
	public void positive2() {
		//Edge Case Test Data
		String[][] paths = {{"London","Paris"},{"Sao Paulo","Lima"},{"Lima","Sao Paulo"}};
		String output = "Paris";
		Assert.assertEquals(destinationCity_Map(paths), output);
	}
	
	@Test
	public void edge() {
		//Negative Test Data
		String[][] paths = {{"A","Z"}};
		String output = "Z";
		Assert.assertEquals(destinationCity_Map(paths), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		String[][] paths = {{"A","z"},{"C","B"},{"Z","C"}};
		String output = "z";
		Assert.assertEquals(destinationCity_Map(paths), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * 1. Traverse using two loops
	 * 2. For every first element of the pairs[i][1] array, check if there is any matching pairs[i+1][0] is available
	 * 3. If not available, return the element
	 * 
	 * -- Using HashMap --
	 * 
	 * 1. Create a hashMap with String,String as generics
	 * 2. Traverse through the given input and add pairs[i][0] as key and pairs[i][1] as value
	 * 3. Create an iterator for hashmap values
	 * 4. If any of the values not available in hashMap keys, return the value
	 * 
	 * 
	 */	
	
	private String destinationCity(String[][] paths) {
		String outputVal = "";
		for(int i=0;i<paths.length;i++) {
			int counter = 0;
			for(int j=0;j<paths.length;j++) {
				//System.out.println(paths[i][1]);
				//System.out.println(paths[j][0]);
				if(paths[i][1] == paths[j][0]) {
					counter++;
				} else outputVal = paths[i][1];
			}
			if(counter<1) return outputVal;
		}
		return "";
	}
	
	private String destinationCity_Map(String[][] paths) {
		HashMap<String,String> hMap = new HashMap<>();
		for(int i=0;i<paths.length;i++) {
			hMap.put(paths[i][0], paths[i][1]);
		}
		Iterator<String> lst = hMap.values().iterator();
		while(lst.hasNext()) {
			String val = lst.next();
			if(!hMap.containsKey(val)) return val;
		}
		return "";
	}
}
