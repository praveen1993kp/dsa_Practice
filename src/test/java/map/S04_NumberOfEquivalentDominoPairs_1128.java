package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class S04_NumberOfEquivalentDominoPairs_1128 {

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
		int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
		int output = 1;
		Assert.assertEquals(dominoPairs_hashMap(dominoes), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int[][] dominoes = {{1,2},{2,1},{3,4},{5,6},{1,2}};
		int output = 3;
		Assert.assertEquals(dominoPairs_hashMap(dominoes), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int[][] dominoes = {{1,2},{2,3},{3,3},{3,2},{2,1},{2,3},{2,3}};
		int output = 7;
		Assert.assertEquals(dominoPairs_hashMap(dominoes), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[][] dominoes = {{1,2},{3,1},{3,4},{5,6}};
		int output = 0;
		Assert.assertEquals(dominoPairs_hashMap(dominoes), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
 	 * 1. Create counter=0
	 * 1. Traverse through an outer loop
	 * 2. Store variables of dominoes[i][0] and dominoes[i][1] as currVal1 and currVal2
	 * 3. Check if currVal1 and currVal2 are equal to (dominoes[j][0] and dominoes[j][1]) and (dominoes[j][1] and dominoes[j][0]). If so, increment the counter
	 * 4. Continue till i<dominoes.length-1
	 * 5. Return the counter
	 * 
	 */	
	
	private int dominoPairs(int[][] dominoes) {
		int counter=0;
		for(int i=0;i<dominoes.length-1;i++){
			for(int j=i+1;j<dominoes.length;j++){
				if((dominoes[i][0]==dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) || (dominoes[i][0]==dominoes[j][1] && dominoes[i][1] == dominoes[j][0]))
					counter++;
			}
		}
		return counter;
	}
	
	private int dominoPairs_hashMap(int[][] dominoes){
		int pairs = 0;
		Map<String,Integer> hMap = new HashMap<>();
	    
	    for(int i=0;i<dominoes.length;i++){
	        if(dominoes[i][0] > dominoes[i][1]){
	            int temp = dominoes[i][0];
	            dominoes[i][0] = dominoes[i][1];
	            dominoes[i][1] = temp;
	        }
	    }
	        
	    for(int i=0;i<dominoes.length;i++){
	        String str1 = dominoes[i][0] + "-" + dominoes[i][1];
		    hMap.put(str1,hMap.getOrDefault(str1,0)+1);
		}
	        
		Iterator<Integer> eachVal = hMap.values().iterator();
		
		while(eachVal.hasNext()){ //If value is 1, it will adjust itself during 1*0/2
			int currVal = eachVal.next();
			pairs += currVal * (currVal-1)/2;
		}
		
	    return pairs;
	}
	
	private int dominoPairs_hashMap2(int[][] dominoes){
		int pairs = 0;
		Map<String,Integer> hMap = new HashMap<>();
	        
	    for(int i=0;i<dominoes.length;i++){
		int currVal1 = dominoes[i][0];
		int currVal2 = dominoes[i][1];
	    String str1 = currVal1 + "-" + currVal2;
	    String str2 = currVal2 + "-" + currVal1;
		    if(hMap.containsKey(str1)) hMap.put(str1,hMap.getOrDefault(str1,0)+1);
			else if (hMap.containsKey(str2)) hMap.put(str2,hMap.getOrDefault(str2,0)+1);
			else hMap.put(str1,1);	
		}
	        
		Iterator<Integer> eachVal = hMap.values().iterator();
		
		while(eachVal.hasNext()){
			int currVal = eachVal.next();
			if(currVal>1){
				pairs += currVal * (currVal-1)/2;
			}
		}
		
	    return pairs;
	}
}
