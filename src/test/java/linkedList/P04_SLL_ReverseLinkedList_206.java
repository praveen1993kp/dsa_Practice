package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;
// For the solution to work, execut in Leetcode
public class P04_SLL_ReverseLinkedList_206 {
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
			System.out.print(head.value + "-");
			head = head.next;
		}
		System.out.println();
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
	 * 1. Create a new node reverse
	 * 2. Traverse for each element in the head and addFirst in the reverse linkedlist
	 * 3. return reverse
	 * 
	 * 
	 * Time: O(n)
	 * Space : O(n)
	 * 
	 * -- Optimized Solution --
	 * 
	 * 1. Traverse using the given node head
	 * 2. Update the first node next value to second value next. If second value next is null, assign first node next value as null
	 * 3. Take the second element in the node and keep it as first node value (head)
	 * 4. Update the head next to current previous head
	 * 5. Repeat the process till second not equal to null
	 * 6. Return the node
	 * 
	 * Time : O(n)
	 * Space : O(1)
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr = {1,2,3,4,5};
		int[] output = {5,4,3,2,1};
		//Assert.assertEquals(reverseLinkedList(addAll(arr)), addAll(output));
		printVals(reverseLinkedList_ConstantSpace(addAll(arr)));
	}
	
	@Test
	public void edge() {
		int[] arr = {1};
		int[] output = {1};
		//Assert.assertEquals(reverseLinkedList(addAll(arr)), addAll(output));	
		printVals(reverseLinkedList_ConstantSpace(addAll(arr)));
	}
	
	@Test
	public void edge2() {
		int[] arr = {};
		int[] output = {};
		//Assert.assertEquals(reverseLinkedList(addAll(arr)), addAll(output));	
		printVals(reverseLinkedList_ConstantSpace(addAll(arr)));
	}
	
	@Test
	public void negative() {
		int[] arr = {1,1,1,1};
		int[] output = {1,1,1,1};
		//Assert.assertEquals(reverseLinkedList(addAll(arr)), addAll(output));	
		printVals(reverseLinkedList_ConstantSpace(addAll(arr)));
	}

	private Node reverseLinkedList(Node head) {
		Node reverse = null;
        while(head != null){
            reverse = addFirst(reverse,head.value);
            head = head.next;
        }
        return reverse;
	}
	
	private Node reverseLinkedList_ConstantSpace(Node head) {
		if(head==null || head.next == null) return head;
		Node a = head;
		Node b = a.next;
		while(b != null) {
			head = addFirst(head,b.value);
			if(b.next != null) a.next = b.next;
			else a.next = null;
			b = b.next;
		}
        return head;
	}

	private Node addFirst(Node head, int value) {
		Node node = new Node(value);
        Node temp = head;
        head = node;
        head.next = temp;
        return head;
	}
	
}
