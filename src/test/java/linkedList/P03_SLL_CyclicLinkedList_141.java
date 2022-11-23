package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;
// For the solution to work, execut in Leetcode
public class P03_SLL_CyclicLinkedList_141 {
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
	
	public boolean cyclicLinkedList(Node node) {
		Set<Node> hSet = new HashSet<>();
        Node temp = head;
        while(temp != null){
            if(!hSet.add(temp)) return true;
            temp = temp.next;
        }
		return false;
	}
	
	/*
	 * Pseudo Code
	 * 
	 * 1. Create a hashset to store nodes
	 * 2. For each node in head, store it in set
	 * 3. When same node is found again, return true
	 * 4. Return false by default
	 * 
	 * 
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr = {3,2,0,-4};
		Assert.assertEquals(cyclicLinkedList(addAll(arr)), true);
	}
	
	@Test
	public void edge() {
		int[] arr = {1};
		Assert.assertEquals(cyclicLinkedList(addAll(arr)), true);	
	}
	
	@Test
	public void edge2() {
		int[] arr = {1,2};
		Assert.assertEquals(cyclicLinkedList(addAll(arr)), true);	
	}
	
}
