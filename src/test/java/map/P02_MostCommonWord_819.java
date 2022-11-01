package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P02_MostCommonWord_819 {

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
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		String output = "ball";
		Assert.assertEquals(mostCommonword(paragraph,banned), output);
	}
	
	@Test
	public void positive2() {
		//Edge Case Test Data
		String paragraph = "Hi t HIT bob$#%$%# bob ";
		String[] banned = {"hit"};
		String output = "bob";
		Assert.assertEquals(mostCommonword(paragraph,banned), output);
	}
	
	@Test
	public void Edge() {
		//Negative Test Data
		String paragraph = "Bob        ";
		String[] banned = {"bob"};
		String output = "";
		Assert.assertEquals(mostCommonword(paragraph,banned), output);
	}
	
	@Test
	public void edge() {
		//Edge Test Data
		String paragraph = "Bob Hit ball        ";
		String[] banned = {"bob","ball"   }	;
		String output = "hit";
		Assert.assertEquals(mostCommonword(paragraph,banned), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Replace all the characters other than alphabets with space
	 * 2. Split the given paragraph using space and store in a String array
	 * 3. Create a set and store all the banned words in it
	 * 4. Create a map
	 * 5. Traverse through the string array words
	 * 6. If the current word is not "" and not in banned words, add to hashMap
	 * 7. While adding get the count of words and if it is maximum, store the count and string
	 * 8. Return the maximum String
	 * 
	 */	
	
	private String mostCommonword(String paragraph, String[] banned) {
		//Replacing all the special characters with space
        paragraph = paragraph.replaceAll("[^a-zA-z]"," ").toLowerCase();
        String[] str = paragraph.split(" ");
        // Adding all the banned words into Set
        HashSet<String> bannedSet = new HashSet<>();
        for(String s : banned){
            bannedSet.add(s);
        }
        // Adding all the allowed words into hashMap and returning maxWord count
        Map<String,Integer> allowedWords = new HashMap<>();
        int maxCount = 0;
        String maxWord = "";
        for(int i=0;i<str.length;i++){
            if(!bannedSet.contains(str[i]) && !str[i].equals("")){
                allowedWords.put(str[i],allowedWords.getOrDefault(str[i],0)+1);
                if(allowedWords.get(str[i]) > maxCount){
                    maxCount = allowedWords.get(str[i]);
                    maxWord =  str[i];
                }
            }
        }
        
        return maxWord;
	}

}
