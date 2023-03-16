package linkedList;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import junit.framework.Assert;
// For the solution to work, execute in Leetcode
public class P09_SLL_MiddleOfTheLinkedList_876 {
	Node head;
	Node tail;
	int length;
	public class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
			next = null;
		}
	}
	
	public void add(int val) {
		Node temp = new Node(val);
		if(head==null) {	
			head = tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
		length++;
	}
	
	public void printVals(Node head) {
		while(head!=null) {
			System.out.println(head.value);
			head = head.next;
		}
		
	}
	
	public Node addAll(int[] val){
		Node temp = null;
		for(int i : val) {
			temp = new Node(i);
			if(head==null) {
				head = tail = temp;
			}else {
				tail.next = temp;
				tail = temp;
			}
			length++;
		}
		return head;
	}
	
	/*
	 * Pseudo Code
	 * 
	 * 1. Create an arraylist 
	 * 2. Till head reaches null, Add all the nodes into list
	 * 3. Get the middle value by using the length of the list
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr = {1,2,6,3,4,5,6};
		int[] output = {1,2,3,4,5};
		Assert.assertEquals(middleNode(addAll(arr)), addAll(output));
	}
	
	@Test
	public void edge() {
		int[] arr = {};
		int[] output = {};
		Assert.assertEquals(middleNode(addAll(arr)), addAll(output));	
	}
	
	@Test
	public void edge2() {
		int[] arr = {1};
		int[] output = {};
		Assert.assertEquals(middleNode(addAll(arr)), addAll(output));
	}
	
	@Test
	public void negative() {
		int[] arr = {2};
		int[] output = {2};
		Assert.assertEquals(middleNode(addAll(arr)), addAll(output));	
	}
	
	@Test
	public void negative2() {
		int[] arr = {2,3,4,5};
		int[] output = {};
		Assert.assertEquals(middleNode(addAll(arr)), addAll(output));	
	}


	public Node middleNode(Node head) {
        Map<Integer,Node> nodes = new HashMap<>();
        int position = 0;
        while(head != null){
            nodes.put(position,head);
            position++;
            head = head.next;
        }
        return nodes.get(nodes.size()/2);
    }
	
}
