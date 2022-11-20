package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class P16_UncommonWordsFromTwoSentences_884 {

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
		String s1 = "this apple is sweet";
		String s2 = "this apple is sour";
		String[] output = {"sweet","sour"};
		Assert.assertEquals(uncommonWords_SingleMap(s1,s2), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s1 = "apple apple";
		String s2 = "banana";
		String[] output = {"banana"};
		Assert.assertEquals(uncommonWords_SingleMap(s1,s2), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s1 = "this";
		String s2 = "apple";
		String[] output = {"apple","this"};
		Assert.assertEquals(uncommonWords_SingleMap(s1,s2), output);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String s1 = "this";
		String s2 = "this";
		String[] output = {};
		Assert.assertEquals(uncommonWords_SingleMap(s1,s2), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Method 1 --
	 * 
	 * 1. Create two HashMaps
	 * 2. Split the strings using space
	 * 3. Add the elements of s1 into hashMap1
	 * 4. Add the elements of s2 into hashMap2
	 * 5. Iterate through the keys of each hashMap
	 * 6. If a key has only one occurrence in a map and not available in another map, add into list
	 * 7. Convert the list into array and return the output
	 * 
	 * -- Method 2--
	 * 
	 * 1. Create one hashmap
	 * 2. Split the strings using space
	 * 3. Add the strings of s1 and s2 into same hashmap
	 * 4. When any character is found to have only one occcurrence, add into list
	 * 5. Convert the list into array and return the output
	 * 
	 */	
	
	public String[] uncommonWords(String s1, String s2) {
	       Map<String,Integer> hMap1 = new HashMap<>();
	       Map<String,Integer> hMap2 = new HashMap<>();
	    
	        String[] s1Array = s1.split(" ");
	        String[] s2Array = s2.split(" ");
	        List<String> lst = new ArrayList<>();
	        for(int i=0;i<s1Array.length;i++){
	            hMap1.put(s1Array[i],hMap1.getOrDefault(s1Array[i],0)+1);
	        }
	        
	        for(int i=0;i<s2Array.length;i++){
	            hMap2.put(s2Array[i],hMap2.getOrDefault(s2Array[i],0)+1);
	        }
	        
	        Iterator<String> itr1 = hMap1.keySet().iterator();
	        Iterator<String> itr2 = hMap2.keySet().iterator();
	        
	        String currString = "";
	        while(itr1.hasNext()){
	            currString = itr1.next();
	            if(hMap1.get(currString)==1 && (!hMap2.containsKey(currString))) lst.add(currString);
	        }
	        
	        while(itr2.hasNext()){
	            currString = itr2.next();
	            if(hMap2.get(currString)==1 && (!hMap1.containsKey(currString))) lst.add(currString);
	        }
	        String[] out = new String[lst.size()];
	        for(int i=0;i<out.length;i++){
	            out[i] = lst.get(i);
	        }
	        return out;
	    }
	
	public String[] uncommonWords_SingleMap(String s1, String s2) {
	       Map<String,Integer> hMap = new HashMap<>();
	    
	        String[] s1Array = s1.split(" ");
	        String[] s2Array = s2.split(" ");
	        List<String> lst = new ArrayList<>();
	        for(int i=0;i<s1Array.length;i++){
	            hMap.put(s1Array[i],hMap.getOrDefault(s1Array[i],0)+1);
	        }
	        
	        for(int i=0;i<s2Array.length;i++){
	            hMap.put(s2Array[i],hMap.getOrDefault(s2Array[i],0)+1);
	        }
	        
	        Iterator<String> itr = hMap.keySet().iterator();
	        
	        String currString = "";
	        while(itr.hasNext()){
	            currString = itr.next();
	            if(hMap.get(currString)==1) {
	            	lst.add(currString);
	            }
	        }
	        
	        String[] out = new String[lst.size()];
	        for(int i=0;i<out.length;i++){
	            out[i] = lst.get(i);
	        }
	        return out;
	    }
}
