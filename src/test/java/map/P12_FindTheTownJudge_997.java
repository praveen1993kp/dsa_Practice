package map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class P12_FindTheTownJudge_997 {

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
		int n=2;
		int[][] trust = {{1,2}};
		int output = 2;
		Assert.assertEquals(findTheJudge(n,trust), output);
	}
	
	@Test
	public void positive2() {
		//Positive Test Data
		int n=2;
		int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		int output = 2;
		Assert.assertEquals(findTheJudge(n,trust), output);
	}
	
	@Test
	public void edge() {
		//Edge Case Test Data
		int n=1;
		int[][] trust = {};
		int output = 1;
		Assert.assertEquals(findTheJudge(n,trust), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int n = 3;
		int[][] trust = {{1,3},{2,3},{3,1}};
		int output = -1;
		Assert.assertEquals(findTheJudge(n,trust), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * -- Brute Force --
	 * 
	 * Edge case: If n==1, return 1 (As judge will be the only person, returning min value from given constraints)
	 * 1. Create variables maxTrust and maxVal = 0. Create a hashMap
	 * 2. Traverse through the length of trust
	 * 3. Add all the [i][1] elements into hashmap and increment the count
	 * 4. When maxTrust less than the value of current key in hashmap, update the maxTrust and maxVal
	 * 5. Traverse through the trust array and see if maxVal is available in trust[i][0]
	 * 6. If so, return -1
	 * 7. If maxTrust length == n-1, return maxVal. Else return -1
	 * 
	 * 
	 * -- Using Ascii --
	 * 
	 * Edge case: If n==1, return 1 (As judge will be the only person, returning min value from given constraints)
	 * 1. Create two ascii arrays of each size 1001
	 * 2. Add the occurrence of all the [i][0] elements into ascii1 and [i][1] elements into ascii2
	 * 3. Traverse through ascii2 and if the occurrence of any element matches n-1 and the element has no entry in ascii1, return the element
	 * 4. If no such element is found, return -1
	 * 
	 */	
	
	private int findTheJudge(int n, int[][] trust) {
		if(n==1) return 1;
        int maxTrust = 0,maxVal=0;
        Map<Integer,Integer> hMap = new HashMap<>();
        for(int i=0;i<trust.length;i++){
            hMap.put(trust[i][1],hMap.getOrDefault(trust[i][1],0)+1);
            if(hMap.get(trust[i][1])> maxTrust) {
                maxTrust = hMap.get(trust[i][1]);
                maxVal = trust[i][1];
            }
            //System.out.println(hMap);
            System.out.println(maxTrust);
        }
        for(int j=0;j<trust.length;j++){
            if(trust[j][0]==maxVal) return -1;
        }
        
    return maxTrust==n-1 ? maxVal : -1;
	}
	
	private int findTheJudge_ascii(int n, int[][] trust) {
		if(n==1) return 1;
        int[] ascii1 = new int[1001];
        int[] ascii2 = new int[1001];
        
        for(int i=0;i<trust.length;i++){
            ascii1[trust[i][0]]++;
            ascii2[trust[i][1]]++;
        }
        
        for(int i=0;i<ascii2.length;i++)
            if(ascii2[i]==n-1 && ascii1[i]==0) return i;
        
        return -1;
	}

	
}
