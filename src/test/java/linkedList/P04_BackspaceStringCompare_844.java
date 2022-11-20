package linkedList;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLinkedList_Implementation.Node;

public class P04_BackspaceStringCompare_844 {
	
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
	 * 
	 * 
	 */

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
