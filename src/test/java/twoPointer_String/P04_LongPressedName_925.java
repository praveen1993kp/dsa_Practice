package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P04_LongPressedName_925 {

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
		String name = "alex";
		String typed = "aaleex";
		Assert.assertEquals(isLongPressedName(name,typed), true);
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		String name = "saeed";
		String typed = "saaed";
		Assert.assertEquals(isLongPressedName(name,typed), false);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		String name = "pr";
		String typed = "prrn";
		Assert.assertEquals(isLongPressedName(name,typed), false);
	}
	
	@Test
	public void negative3() {
		//Negative Test Data
		String name = "praveen";
		String typed = "raaveenp";
		Assert.assertEquals(isLongPressedName(name,typed), false);
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String name = "alex";
		String typed = "aaleexa";
		Assert.assertEquals(isLongPressedName(name,typed), false);
	}
	
	@Test
	public void edge3() {
		//Edge Case Test Data
		String name = "praveen";
		String typed = "praven";
		Assert.assertEquals(isLongPressedName(name,typed), false);
	}
	
	@Test
	public void edge4() {
		//Edge Case Test Data
		String name = "p";
		String typed = "pppp";
		Assert.assertEquals(isLongPressedName(name,typed), true);
	}
	
	@Test
	public void edge5() {
		//Edge Case Test Data
		String name = "praveen";
		String typed = "p";
		Assert.assertEquals(isLongPressedName(name,typed), false);
	}
	
	@Test
	public void edge6() {
		//Edge Case Test Data
		String name = "alex";
		String typed = "alexxr";
		Assert.assertEquals(isLongPressedName(name,typed), false);
	}
	
	
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create two pointers p1=0 and p2 = 0 and char tempVal to store previous left val
	 * 2. Assign the pointers to each of the words' first character
	 * 3. When values at p1 and p2 are equal, increment both pointers and assign tempVal
	 * 4. If not equal, check if the current value at p2 is equal to tempVal
	 * 5. If equal to tempVal, increment right alone
	 * 6. If not equal to tempVal, return false
	 * 7. Traverse for p1<name.length() and p2<typed.length()
	 * 8. When p1 crosses its length, check if all the remaining characters in p2 are tempVal
	 * 9. When p2 crosses its length, and when p1 is within its length, return false
	 * 9. At the end, if we successfully cross both lenghts, return true
	 * 
	 * 
	 */	
	
	private boolean isLongPressedName(String name, String typed) {
		int p1=0,p2=0;
        char tempVal = '0';
        while(p1<name.length() || p2<typed.length()){
            if(p1>=name.length()){
               if(typed.charAt(p2)==tempVal) p2++;
               else return false;
            } else if (p2>=typed.length() && p1<name.length())return false;
              else{
               if(name.charAt(p1)==typed.charAt(p2)){
                tempVal = name.charAt(p1);
                p1++;
                p2++;
                
            } else {
                if(typed.charAt(p2)==tempVal) p2++;
                else return false;
            }     
            }     
                
        }
        return true;
	}

	
}
