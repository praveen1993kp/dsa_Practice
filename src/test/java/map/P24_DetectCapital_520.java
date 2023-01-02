package map;

import org.junit.Test;

import junit.framework.Assert;

public class P24_DetectCapital_520 {

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
		String s = "USA";
		boolean output = true;
		Assert.assertEquals(detectCapital(s), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "U";
		boolean output = true;
		Assert.assertEquals(detectCapital(s), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "UsA";
		boolean output = false;
		Assert.assertEquals(detectCapital(s), output);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String s = "India";
		boolean output = true;
		Assert.assertEquals(detectCapital(s), output);
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		String s = "india";
		boolean output = true;
		Assert.assertEquals(detectCapital(s), output);
	}

	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Check if first character is lower case. If so, check if all the further characters are lower alone
	 * 2. Check if first character is upper case
	 * 		2a. If next character is capital, check if all the further characters are capital
	 * 		2b. If next character is lower, check if all the further characters are lower.
	 * 3. If any condition is violated, return false. return true by default
	 * 
	 * -- Better solution --
	 * 
	 * 1. If first character and second are capital, all should be capital. If not, return false
	 * 2. Else, all the characters startinc from 1st index should be lower
	 * 3. return true by default
	 * 
	 */	
	
	public boolean detectCapital_Approach1(String word) {
        if(word.length()==1) return true;
        if(Character.isLowerCase(word.charAt(0))){
            for(int i=1;i<word.length();i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        } else {
            if(Character.isLowerCase(word.charAt(1))){
                for(int i=2;i<word.length();i++){
                    if(Character.isUpperCase(word.charAt(i))) return false;
                }
            } else {
                for(int i=2;i<word.length();i++){
                    if(Character.isLowerCase(word.charAt(i))) return false;
                }
            }
        }
        return true;
    }
	
	public boolean detectCapital_Approach2(String word) {
        if(word.length()==1) return true;

        return (word.charAt(0) < 97 && word.charAt(1) <97) ? detectCase(word,false) : detectCase(word,true);
    }

    public boolean detectCase(String word,boolean flag){
        if(flag){
            for(int i=1;i<word.length();i++){
                if(word.charAt(i) < 97) return false;
            }
        } else {
            for(int i=2;i<word.length();i++){
                    if(word.charAt(i) >=97) return false;
                }
        }
        return true;     
    }
	
	public boolean detectCapital(String word) {
        if(word.length()==1) return true;
        
        if(isCapital(word.charAt(0)) && isCapital(word.charAt(1))){
            for(int i=2;i<word.length();i++)
                if(!isCapital(word.charAt(i))) return false;
        } else {
            for(int i=1;i<word.length();i++)
                if(isCapital(word.charAt(i))) return false;
        } 
        return true;
    }

    public boolean isCapital(char ch){
        return ch-'A' < 26;
    }
}
