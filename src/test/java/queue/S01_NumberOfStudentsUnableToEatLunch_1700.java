package queue;

import java.util.ArrayDeque;

import org.junit.Test;

import junit.framework.Assert;

public class S01_NumberOfStudentsUnableToEatLunch_1700 {

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
		int[] students = {1,1,0,0};
		int[] sandwiches = {0,1,0,1};
		int output = 0;
		Assert.assertEquals(noOfStudents(students,sandwiches), output);
	}
	
	@Test
	public void positive2() {
		//Positive Case Test Data
		int[] students = {1,1,1,0,0,1};
		int[] sandwiches = {1,0,0,0,1,1};
		int output = 3;
		Assert.assertEquals(noOfStudents(students,sandwiches), output);
	}
	
	@Test
	public void edge() {
		//Negative Test Data
		int[] students = {1};
		int[] sandwiches = {0};
		int output = 1;
		Assert.assertEquals(noOfStudents(students,sandwiches), output);
	}
	
	@Test
	public void edge2() {
		//Negative Test Data
		int[] students = {1};
		int[] sandwiches = {1};
		int output = 0;
		Assert.assertEquals(noOfStudents(students,sandwiches), output);
	}
	
	@Test
	public void negative() {
		//Negative Test Data
		int[] students = {1,1,1,1};
		int[] sandwiches = {0,0,0,0};
		int output = 1;
		Assert.assertEquals(noOfStudents(students,sandwiches), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Add all the students into queue
	 * 2. Create variables i to find current sandwiches index, swaps to see how many swapped in queue and flag=true to see if any match found while swapping
	 * 3. Traverse while i<sandwiches.length 
	 * 4. If match found, pop from queue and increment i
	 * 5. Else, take first element from queue and offer at the last. continue till swaps < length-i
	 * 6. If any match found which swapping, break the swapping and continue to the outer loop
	 * 7. If no match found and swaps exceeds length-i, return length-i
	 * 8. Return 0 by default
	 * 
	 * Time: O(n^2)
	 * Space: O(1)
	 * 
	 * -- Optimized Solution --
	 * 
	 * 1. Add all the students into queue
	 * 2. Create variables i=0 and swaps=0;
	 * 3. Traverse while swaps<deque.size()
	 * 4. If deque peek and sandwiches[i] matches, pop and increment i
	 * 5. Else, pop the first element and offer into the deque at the end. Increment swaps
	 * 6. return the size of deque at the end
	 * 
	 * Time: O(n^2)
	 * Space: O(1)
	 * 
	 * 
	 */	
	
	private int noOfStudents(int[] students, int[] sandwiches) {
		ArrayDeque<Integer> deque = new ArrayDeque();
        for(int i=0;i<students.length;i++){
            deque.offer(students[i]);
        }
        
        int i=0;
        int swaps = 0;
        boolean flag=true;
        while(i<sandwiches.length){
            if(sandwiches[i]==deque.peek()){
                deque.pop();
                i++;
            } else{
                flag = false;
                swaps=sandwiches.length-i;
                while(swaps >=0){
                    if(deque.peek()==sandwiches[i]){
                        flag = true;
                        break;
                    } else {
                        int val = deque.pop();
                        deque.offer(val);
                        swaps--;
                    }   
                    //System.out.println(deque);
                }
            }
            if(!flag) return sandwiches.length-i;
        }  
        return 0;
	}

	
	private int noOfStudents_Optimized(int[] students, int[] sandwiches) {
		ArrayDeque<Integer> deque = new ArrayDeque();
        for(int i=0;i<students.length;i++){
            deque.offer(students[i]);
        }
        
        int i=0;
        int swaps = 0;
        while(swaps<deque.size()) {
        	if(deque.peek() == sandwiches[i]) {
        		deque.pop();
        		swaps = 0;
        		i++;
        	} else {
        		deque.offer(deque.pop());
        		swaps++;
        	}
        }    
        return deque.size();
	}
	
}
