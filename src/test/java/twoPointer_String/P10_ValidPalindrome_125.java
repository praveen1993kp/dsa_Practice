package twoPointer_String;

import org.junit.Test;

import junit.framework.Assert;

public class P10_ValidPalindrome_125 {

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
		String s = "A man, a plan, a canal: Panama";
		boolean output = true;
		Assert.assertEquals(isPalindrome_TwoPointer(s), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "a A234 5523 #$#%4 aA";
		boolean output = false;
		Assert.assertEquals(isPalindrome_TwoPointer(s), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "2345";
		boolean output = false;
		Assert.assertEquals(isPalindrome_TwoPointer(s), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Pseudo code - Brute force:
	 * 1. Add only characters into stringbuffer
	 * 2. reverse the string and store in another array
	 * 3. Using equalsIgnore case method, check if both the strings are equal
	 * 
	 * Pseudo code - Two pointer:
	 * 1. Create left=0 and right=s.length()-1
	 * 2. If both are Characters or digits, compare both. If not matching, return true
	 * 3. If either is not character/digit, traverse till we find character/digit. Traverse till left<right.
	 * 4. return true by default
	 * 
	 */	
	
	public boolean isPalindrome(String s) {
        StringBuffer str = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                str.append(s.charAt(i));
        }
        return str.toString().equalsIgnoreCase(str.reverse().toString());
    }
	
	public boolean isPalindrome_TwoPointer(String s) {
        int left=0,right=s.length()-1;
        char chLeft=0,chRight=0;
        while(left<right){
            if(Character.isUpperCase(s.charAt(left))) chLeft = Character.toLowerCase(s.charAt(left));
            else chLeft = s.charAt(left);
            if(Character.isUpperCase(s.charAt(right))) chRight = Character.toLowerCase(s.charAt(right));
            else chRight = s.charAt(right);
            if(isCharacterOrDigit(chLeft) && isCharacterOrDigit(chRight)){
                if(chLeft != chRight) return false;
                left++;
                right--;
            } else {
                if(!isCharacterOrDigit(chLeft)) left++;
                if(!isCharacterOrDigit(chRight)) right--;
            }
        }
        return true;
    }

    public boolean isCharacterOrDigit(char ch){
        return (Character.isAlphabetic(ch) || Character.isDigit(ch));
    }
}
