package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P05_UniqueEmailAddresses_929 {

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
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		int output = 2;
		Assert.assertEquals(uniqueEmails(emails), output);
	}
	
	@Test
	public void edge1() {
		//Edge Case Test Data
		String[] emails = {"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemaildavid@lee.tcode.com"};
		int output = 3;
		Assert.assertEquals(uniqueEmails(emails), output);
		
	}
	
	@Test
	public void edge2() {
		//Edge Case Test Data
		String[] emails = {"test.e.m.a.i...l+al+ex@leetcode.com",".test.e.mail+++bob.cathy@gmail.com","testemaildavid+++@lee.tcode.com"};
		int output = 3;
		Assert.assertEquals(uniqueEmails(emails), output);
		
	}
	
	@Test
	public void negative() {
		//Edge Case Test Data
		String[] emails = {"testemailalex@leetcode.com","testemailbobcathy@leetcode.com","testemaildavid@lee.tcode.com"};
		int output = 3;
		Assert.assertEquals(uniqueEmails(emails), output);
		
	}
	
	@Test
	public void negative2() {
		//Negative Test Data
		String[] emails = {".a@gmail.com","b@leetcode.com","a@gmail.com","b.+@gmail.com"};
		int output = 3;
		Assert.assertEquals(uniqueEmails(emails), output);
	}
	
	@Test
	public void negative3() {
		//Negative Test Data
		String[] emails = {"a@gmail.com",};
		int output = 1;
		Assert.assertEquals(uniqueEmails(emails), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Using replace and indexOf methods --
	 * 
	 * 1. Traverse through the given array emails
	 * 2. For each emails[i] String, split using @
	 * 3. Replace all . in the local name with ""
	 * 4. Get the index of + 
	 * 5. Get the substring till the index returned from step 4
	 * 6. Append result from step 5 with domain name
	 * 7. Add the result of step 6 into hashmap
	 * 8. Count the number of keys in hashmap and return it
	 * 
	 * -- Without using split, replace and indexOf methods
	 * 
	 * 1. Create a set to accomodate string
	 * 2. Traverse through the given array
	 * 3. Get the current String
	 * 4. Create flag as false
	 * 5. Traverse again through the current string
	 * 		-- If current string is . continue
	 * 		-- If current string is + make the flag as true
	 * 		-- If current string is not @ and flag is false, append it to a string
	 * 		-- If flag is @, get the index and break
	 * 6. Append output string + substring from @
	 * 7. Return the count of set
	 * 
	 */	
	
	private int uniqueEmails(String[] emails) {
		Map<String,Integer> validEmails = new HashMap<>();
	       for(int i=0;i<emails.length;i++){
	           String[] str = emails[i].split("@");
	           String currString = str[0].replace(".","");
	           int index = currString.indexOf('+');
	           System.out.println(index);
	           String localName = (index>0 ? currString.substring(0,index) : currString) + str[1];
	           validEmails.put(localName,validEmails.getOrDefault(localName,0)+1);
	       }
	        //System.out.println(validEmails.toString());
	        return validEmails.keySet().size();
	}
	
	private int uniqueEmails_withoutInBuiltMethods(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
        for(int i=0;i<emails.length;i++){
            String currString = emails[i];
            boolean flag = false;
            String output = "";
            int index = 0;
            for(int j=0;j<currString.length();j++){
                if(currString.charAt(j)=='.') continue;
                else if(currString.charAt(j)=='+') flag = true;
                else if(currString.charAt(j)!='@') {
                    if(!flag)
                        output += currString.charAt(j);
                } else {
                    index = j;
                    break;
                }
            }
            uniqueEmails.add(output + currString.substring(index));
        }
        //System.out.println(uniqueEmails.toString());
        return uniqueEmails.size();
	}

	
}
