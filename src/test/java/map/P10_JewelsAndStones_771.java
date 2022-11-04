package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P10_JewelsAndStones_771 {

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
		String jewels = "aA";
		String stones = "aAAbbbb";
		int output = 3;
		Assert.assertEquals(jewelsAndStones_usingAscii(jewels,stones), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		String jewels = "aBcDeFg";
		String stones = "g";
		int output = 1;
		Assert.assertEquals(jewelsAndStones_usingAscii(jewels,stones), output);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String jewels = "a";
		String stones = "A";
		int output = 0;
		Assert.assertEquals(jewelsAndStones_usingAscii(jewels,stones), output);
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		String jewels = "s";
		String stones = "sSs";
		int output = 2;
		Assert.assertEquals(jewelsAndStones_usingAscii(jewels,stones), output);
	}
	
	@Test
	public void edge4() {
		//Edge Case Test Data
		String jewels = "bcd";
		String stones = "cba";
		int output = 2;
		Assert.assertEquals(jewelsAndStones_usingAscii(jewels,stones), output);
	}
	
	@Test
	public void negative1() {
		//Negative Test Data
		String jewels = "ABCD";
		String stones = "abcd";
		int output = 0;
		Assert.assertEquals(jewelsAndStones_usingAscii(jewels,stones), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		String jewels = "abcd";
		String stones = "efgh";
		int output = 0;
		Assert.assertEquals(jewelsAndStones_usingAscii(jewels,stones), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create counter = 0
	 * 2. Create two for loops starting from i=0 and j=0
	 * 3. If values from jewels[i] and stones[j] are equal, increment the counter
	 * 4. Return the counter
	 * 
	 * --- Two Pointer ---
	 * 
	 * 1. Convert given Strings into character arrays
	 * 2. Sort the array
	 * 3. Create pointer left=0 and right=0
	 * 4. If the value at jewels < stones, increment left
	 * 5. If the value at stones < jewels, increment right
	 * 5. If the values are same, increment the counter and increment stones  //Value at jewels can occur again
	 * 6. When jewels crosses its length or right crosses its length, return the counter
	 * 
	 * 
	 * -- Using Set -- // Can be done with two sets also
	 * 
	 * 1. Create a set
	 * 2. Add the characters of jewels into set
	 * 3. For each character in stones, if it is already available in set, increment the counter
	 * 4. Return the counter
	 * 
	 * -- Using Contains Method --
	 * 
	 * 1. Create counter = 0
	 * 2. Traverse through stones
	 * 3. If the character at stones casted as a string, is available in jewels, increment the counter
	 * 4. Return the counter
	 * 
	 * -- Using Map --
	 * 
	 * 1. Create a hashMap for Character,Integer
	 * 2. Add all the characters of jewels into hMap with value as 0
	 * 3. Traverse through the stones and if the character is already available in hMap, increment the value
	 * 4. After traversing is done for all the characters of stones, traverse through entryset and increment the counter based on values
	 * 5. Return the counter
	 * 
	 * -- Using Ascii --
	 * 
	 * 1. Create an ascii array of size 128
	 * 2. For each character in jewels, increment the array value for the respective index
	 * 3. Traverse through stones and if the index of same character in array is not zero, increment counter
	 * 4. Return the counter
	 * 
	 * 
	 */	
	

	private int jewelsAndStones(String jewels, String stones) {
		int counter = 0;
        for(int i=0;i<jewels.length();i++){
            for(int j=0;j<stones.length();j++){
                if(jewels.charAt(i) == stones.charAt(j)) counter++;
            }
        }
        return counter;
	}
	
	private int jewelsAndStones_twoPointer(String jewels, String stones) {
		int counter = 0;
        int p1=0,p2=0;
        char[] jewelsChar = jewels.toCharArray();
        char[] stonesChar = stones.toCharArray();
        Arrays.sort(jewelsChar);
        Arrays.sort(stonesChar);
        while(p1<jewelsChar.length && p2 < stonesChar.length) {
        	System.out.println(jewelsChar[p1] < stonesChar[p2]);
        	if(jewelsChar[p1] == stonesChar[p2]) {
        		counter++;
        		p2++;
        	} else if (jewelsChar[p1] < stonesChar[p2]) p1++;
        	else p2++;
        }
        return counter;
	}
	
	private int jewelsAndStones_usingSet(String jewels, String stones) {
		int counter = 0;
        Set<Character> jewelsStones = new HashSet<>();
        for(int i=0;i<jewels.length();i++) {
        	jewelsStones.add(jewels.charAt(i));
        }
        
        for(int j=0;j<stones.length();j++) {
        	if(jewelsStones.contains(stones.charAt(j))) counter++;
        }
        return counter;
	}
	
	private int jewelsAndStones_usingContainsMethod(String jewels, String stones) {
		int counter = 0;
        
		for(int i=0;i<stones.length();i++) 
			if(jewels.contains(stones.charAt(i) + "")) counter++;
		
		return counter;
	}
	
	private int jewelsAndStones_usingMap(String jewels, String stones) {
		Map<Character,Integer> hMap = new HashMap<>(); 
		for(int i=0;i<jewels.length();i++) {
			hMap.put(jewels.charAt(i), 0);
		}
		
		for(int j=0;j<stones.length();j++) {
			if(hMap.containsKey(stones.charAt(j))) {
				hMap.put(stones.charAt(j), hMap.get(stones.charAt(j))+1);
			}
				
		}
		//System.out.println(hMap);
		int counter = 0;
		for(Entry<Character,Integer> entry : hMap.entrySet()) {
			counter += entry.getValue();
		}
		return counter;
	}
	
	private int jewelsAndStones_usingAscii(String jewels, String stones) {
		int[] ascii = new int[128];
		for(int i=0;i<jewels.length();i++) {
			ascii[jewels.charAt(i)]++;
		}
		int counter = 0;
		for(int j=0;j<stones.length();j++) {
			if(ascii[stones.charAt(j)]!=0) counter++;
		}
		return counter;
	}
	
	
}
