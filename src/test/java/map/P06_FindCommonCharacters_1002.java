package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class P06_FindCommonCharacters_1002 {

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
		String[] words = {"bella","label","roller"};
		List<String> output = Arrays.asList("e","l","l");
		Assert.assertEquals(commoncharacters_betterApproach(words), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		String[] words = {"car","carrac","a"};
		List<String> output = Arrays.asList("a");
		Assert.assertEquals(commoncharacters_betterApproach(words), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String[] words = {"abc","def","ghi"};
		List<String> output = new ArrayList<>();
		Assert.assertEquals(commoncharacters_betterApproach(words), output);
	}
	
	@Test
	public void positive2() {
		//Negative Test Data
		String[] words = {"cool","lock","cook"};
		List<String> output = Arrays.asList("c","o");
		Assert.assertEquals(commoncharacters_betterApproach(words), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two ascii arrays of size 26
	 * 2. Create pointers left=0 and right=words[0].length()-1
	 * 3. Add the values of all the characters available in words[0]
	 * 4. Traverse from words[1] till length of words. Everytime, reset the values of ascii2 to 0
	 * 5. For each word, add the characters into ascii2
	 * 6. Compare ascii1 and ascii2 and add the minimum into ascii1
	 * 7. Continue till step 4 is true
	 * 8. Create a list for output
	 * 9. For each index in ascii1, get the value. while the value>0, add the character into arraylist
	 * 10. Return the list.
	 * 
	 * -- Better Approach --
	 * 
	 * 1. Create two ascii arrays of size 26
	 * 2. Create pointers left=0 and right=words[0].length()-1
	 * 3. Fill ascii1 with value 101
	 * 4. Traverse from words[0] till length of words. Everytime, fill ascii2 with 0
	 * 5. For each word, add the characters into ascii2
	 * 6. Compare ascii1 and ascii2 and add the minimum into ascii1
	 * 7. Continue till step 4 is true
	 * 8. Create a list for output
	 * 9. For each index in ascii1, get the value. while the value>0, add the character into arraylist
	 * 10. Return the list.
	 * 
	 */	
	
	private List<String> commoncharacters(String[] words) {
		int[] ascii1 = new int[26];
        int[] ascii2 = new int[26];
        int left=0,right=words[0].length()-1;
        while(left<=right){
            ascii1[words[0].charAt(left++)-'a']++;
            if(left<right) ascii1[words[0].charAt(right--)-'a']++;
        }
        for(int i=0;i<words.length;i++){
            left=0;
            right=words[i].length()-1;
            Arrays.fill(ascii2,0);
            while(left<=right){
                ascii2[words[i].charAt(left++)-'a']++;
                if(left<right) ascii2[words[i].charAt(right--)-'a']++;
            }
            
            for(int k=0;k<ascii1.length;k++){
                ascii1[k] = Math.min(ascii1[k],ascii2[k]);
            }
        }
        //System.out.println(Arrays.toString(ascii1));
        List<String> lst = new ArrayList<>();
        for(int p=0;p<ascii1.length;p++){
                int count = ascii1[p];
                while(count>0){
                    lst.add((char) (p+'a') + "");
                    count--;
                }
        }
        return lst;
	}
	
	private List<String> commoncharacters_betterApproach(String[] words) {
		int[] ascii1 = new int[26];
        int[] ascii2 = new int[26];
        int left=0,right=0;
        Arrays.fill(ascii1, 101); // Since the maximum size given in the range 1<words[i].length<=100
        for(int i=0;i<words.length;i++){
            left=0;
            right=words[i].length()-1;
            Arrays.fill(ascii2,0);
            while(left<=right){
                ascii2[words[i].charAt(left++)-'a']++;
                if(left<right) ascii2[words[i].charAt(right--)-'a']++;
            }
            
            for(int k=0;k<ascii1.length;k++){
                ascii1[k] = Math.min(ascii1[k],ascii2[k]);
            }
        }
        //System.out.println(Arrays.toString(ascii1));
        List<String> lst = new ArrayList<>();
        for(int p=0;p<ascii1.length;p++){
                int count = ascii1[p];
                while(count>0){
                    lst.add((char) (p+'a') + "");
                    count--;
                }
        }
        return lst;
	}

	
}
