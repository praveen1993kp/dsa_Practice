package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class S05_MagazineAndNotes_HR {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Hackerrank:
	 * 
	 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
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
		//Edge Case Test Data
		List<String> m = Arrays.asList("give me one grand today night".split(" "));
		List<String> n = Arrays.asList("give one grand today".split(" "));
		String output = "Yes";
		Assert.assertEquals(areNotesSame(m,n), output);
	}

	@Test
	public void edge() {
		//Edge Case Test Data
		List<String> m = Arrays.asList("two times three is not four".split(" "));
		List<String> n = Arrays.asList("two times two is four".split(" "));
		String output = "No";
		Assert.assertEquals(areNotesSame(m,n), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		List<String> m = Arrays.asList("attack at dawn".split(" "));
		List<String> n = Arrays.asList("Attack at Dawn".split(" "));
		String output = "No";
		Assert.assertEquals(areNotesSame(m,n), output);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		List<String> m = Arrays.asList("at".split(" "));
		List<String> n = Arrays.asList("Attack at Dawn".split(" "));
		String output = "No";
		Assert.assertEquals(areNotesSame(m,n), output);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Edge case: If magazine length is less than notes length, return "No"
	 * 2. Traverse through each word in magazine. If note contains that word, remove from notes
	 * 3. If size of word equals 0, return "Yes" else return "No"
	 * 
	 * O(n^2)
	 * O(1)
	 * 
	 */	
	
	private String magazineAndNotes(List<String> magazine, List<String> notes) {
		int counter=0;
		if(magazine.size() < notes.size()) return "No";
		for(String word : magazine) {
			if(notes.contains(word)){
				counter++;
			}			
		}
		return (notes.size()==counter) ? "Yes" : "No";
	}
	
	
	public String areNotesSame(List<String> m, List<String> n){
		Map<String,Integer> map1 = new HashMap<>();
		Map<String,Integer> map2 = new HashMap<>();
		
		for(int i=0;i<m.size();i++){
			map1.put(m.get(i),map1.getOrDefault(m.get(i),0)+1);
		}
		
		for(int i=0;i<n.size();i++){
			map2.put(n.get(i),map2.getOrDefault(n.get(i),0)+1);
			if(!map1.containsKey(n.get(i))) return "No";
		}
		
		for(int i=0;i<n.size();i++) {	
			if(map1.get(n.get(i)) < map2.get(n.get(i))) return "No";
		}
		return "Yes";
	}
}
