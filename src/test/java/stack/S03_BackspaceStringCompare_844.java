package stack;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLinkedList_Implementation.Node;

public class S03_BackspaceStringCompare_844 {
	
	@Test
	public void example1() {
		String s = "ab#c";
		String t = "ad#t";
		Assert.assertEquals(backSpace(s,t), false);
		
	}
	
	@Test
	public void example2() {
		String s = "ab##";
		String t = "c#d#";
		Assert.assertEquals(backSpace(s,t), true);
	}
	
	@Test
	public void example3() {
		String s = "a#c";
		String t = "b";
		Assert.assertEquals(backSpace(s,t), false);
	}
	
	@Test
	public void example4() {
		String s = "#a";
		String t = "a";
		Assert.assertEquals(backSpace(s,t), true);
	}
	
	@Test
	public void example5() {
		String s = "#";
		String t = "#";
		Assert.assertEquals(backSpace(s,t), true);
	}
	
	@Test
	public void example6() {
		String s = "";
		String t = "";
		Assert.assertEquals(backSpace(s,t), true);
	}
	
	/*
	 * -- Pseudo Code--
	 * 
	 * 1. Create two linkedlists
	 * 2. Keep track of current and previous
	 * 3. If current is #, 
	 * 		If list is not empty, removeLast
	 * 4. Otherwise continue to add elements into respective linkedlists
	 * 5. Compare lists
	 * 
	 * -- Stack --
	 * 
	 * 1. Create two stacks
	 * 2. Keep track of current and previous
	 * 3. If current is #, 
	 * 		If list is not empty, pop
	 * 4. Otherwise continue to add elements into respective stacks
	 * 5. Compare stacks and return the result
	 * 
	 * 
	 * 
	 */
	
	public boolean backSpace_UsingStack(String s, String t) {
		Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(!stack1.isEmpty())
                    stack1.pop();
            } else stack1.push(s.charAt(i));
        }
        
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(!stack2.isEmpty())
                    stack2.pop();
            } else stack2.push(t.charAt(i));
        }
        
        return stack1.equals(stack2);
	}

	public boolean backSpace(String s, String t) {
		LinkedList<Character> lst1 = loadedLinkedList(s);
		LinkedList<Character> lst2 = loadedLinkedList(t);		
		
		return lst1.equals(lst2);
	}
	
	public LinkedList<Character> loadedLinkedList(String s){
		LinkedList<Character> lst = new LinkedList<>();
		for(char c : s.toCharArray()) {
			if(c=='#') {
				if(!lst.isEmpty())
					lst.removeLast();
			} else lst.add(c);
		}
		return lst;
	}
	
	
	
}
