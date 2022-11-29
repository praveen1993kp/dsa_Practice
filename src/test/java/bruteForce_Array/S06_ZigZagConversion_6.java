package bruteForce_Array;

import org.junit.Test;

import junit.framework.Assert;

public class S06_ZigZagConversion_6 {

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
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String out = "PAHNAPLSIIGYIR";
		Assert.assertEquals(zigZagConversion(s,numRows), out);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "PAYPALISHIRING";
		int numRows = 4;
		String out = "PINALSIGYAHRPI";
		Assert.assertEquals(zigZagConversion(s,numRows), out);
	}
	
	@Test
	public void edge1() {
		//Negative Test Data
		String s = "PAYPALISHIRING";
		int numRows = 1;
		String out = "PAYPALISHIRING";
		Assert.assertEquals(zigZagConversion(s,numRows), out);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		String s = "PAYPALISHIRING";
		int numRows = 35;
		String out = "PAYPALISHIRING";
		Assert.assertEquals(zigZagConversion(s,numRows), out);
	}
	
	@Test
	public void edge3() {
		//Negative Test Data
		String s = "P";
		int numRows = 1;
		String out = "PAYPALISHIRING";
		Assert.assertEquals(zigZagConversion(s,numRows), out);
	}

	

	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Edge case: If length of s ==1 return s
	 * Edge case: If numRows==1 return s
	 * Edge case: If numRows > s.length() return s
	 * 
	 * 1. Create a flag to mark increment or decrement. Create a variable to mention current row
	 * 2. Create an array to hold Strings at given index
	 * 3. Traverse through each character in s and append the character at specified index
	 * 4. When row reaches numRows, start decrementing it and when row reaches 1, start incrementing
	 * 5. Increment/decrement rows based on condition 4
	 * 6. Add all the Strings from each array index and append to form output string
	 * 
	 */	
	
	private String zigZagConversion(String s, int numRows) {
		if(s.length()==1 || numRows==1 || numRows>s.length()) return s;
        int row=0; //When row is initialized as 1, flag conditions should be 1 and numRows. Array indices also to be updated
        boolean increment = true;
        String[] values = new String[numRows];
        for(int i=0;i<s.length();i++){
            if(values[row]==null) values[row] = "";
            values[row] = values[row] + s.charAt(i);

            if(row==numRows-1) 
                increment = false;
            
            if(row==0)
                increment = true;
            
            if(increment) row++;
            else row--;
        }
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<numRows;i++){
        sb.append(values[i]);
    }
		return sb.toString();
	}
}
