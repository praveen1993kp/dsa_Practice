package slidingWindow_Array;

import org.junit.Test;

public class P01_LongestPalindromicSubsequence_5 {

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
		String s = "babad";
		String output = "aba";
		System.out.println(longestPalindrome_expandFromCentre(s));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "sort";
		String output = "s";
		System.out.println(longestPalindrome_expandFromCentre(s));
	}
	
	@Test
	public void example4() {
		//Edge Case Test Data
		String s = "cbba";
		String output = "bb";
		System.out.println(longestPalindrome_expandFromCentre(s));
	}
	
	@Test
	public void example5() {
		//Edge Case Test Data
		String s = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
		String output = "bb";
		System.out.println(longestPalindrome_expandFromCentre(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "racescar";
		String output = "racecar";
		System.out.println(longestPalindrome_expandFromCentre(s));
	}
	
	@Test
	public void example6() {
		//Edge Case Test Data
		String s = "a1b2b1a";
		String output = "bb";
		System.out.println(longestPalindrome_expandFromCentre(s));
	}
	
	@Test
	public void example7() {
		//Edge Case Test Data
		String s = "aaaa";
		String output = "aaaa";
		System.out.println(longestPalindrome_expandFromCentre(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force:
	 * 
	 * 1. Create two loops
	 * 2. For every character in i, check if the character till j is a palindrome
	 * 3. If palindrome, calculate the maxLength
	 * 4. Return the maxLength
	 * 
	 * Expand From Centre:
	 * 
	 * 1. If s is null or length of s is less than 1, return empty string
	 * 2. Create pointers left=0 and right = 0
	 * 3. Traverse through the given string
	 * 4. Calculate the maximum length of substring returned for the current position 
	 * 5. Calculate the maximum length of substring for both scenarios (racecar & abba)
	 * 6. Get the maximum length from step 5
	 * 7. Calculate the maximum length and if it is greater than current length, assign pointers accordingly
	 * 8. Return the substring between pointer1 and pointer2+1
	 */	
	
	public String longestPalindrome_Bruteforce(String s) {
		int maxLength = -1;
        int p1 = 0,p2=0;
        for(int i=0;i<s.length();i++){
            int pointer=i+1;
            while(pointer<s.length()){
                while(pointer<s.length()-1 && s.charAt(pointer)!=s.charAt(i)) pointer++;
            if (isPalindrome(s,i,pointer)){
            	if(pointer-i > maxLength) {
            		maxLength = Math.max(pointer-i,maxLength);  
                    p1=i;
                    p2=pointer;
            	}       
            }     
            pointer++;
            }   
        }
     return s.substring(p1,p2+1); 
	}
	
	public boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
	
	
	
	public String longestPalindrome_expandFromCentre(String s) {
		if(s==null || s.length() < 1) return "";
		int left=0,right=0;
		
		for(int i=0;i<s.length();i++) {
			int len1 = expandFromCentre(s,i,i);
			int len2 = expandFromCentre(s, i, i+1);
			int len = Math.max(len1, len2);
			
			if(len>right-left) {
				left = i - (len-1)/2;
				right = i + len/2;
			}
		}
		return s.substring(left,right+1);
	}
	
	public int expandFromCentre(String s, int left, int right){        
        while(left>=0 && right< s.length() && s.charAt(left) == s.charAt(right)) {
        	left--;
        	right++;
        }
         return right-left-1;
    }
}
