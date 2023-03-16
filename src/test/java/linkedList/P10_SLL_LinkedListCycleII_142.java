package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;
// For the solution to work, execute in Leetcode
public class P10_SLL_LinkedListCycleII_142 {
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
		System.out.println(cyclicLinkedList(addAll(arr)));
		//Assert.assertEquals(cyclicLinkedList(addAll(arr)), true);
	}
	
	@Test
	public void edge() {
		int[] arr = {1};
		System.out.println(cyclicLinkedList(addAll(arr)));
		//Assert.assertEquals(cyclicLinkedList(addAll(arr)), true);	
	}
	
	@Test
	public void edge2() {
		int[] arr = {1,2};
		System.out.println(cyclicLinkedList(addAll(arr)));
		//Assert.assertEquals(cyclicLinkedList(addAll(arr)), true);	
	}
	
	public Node cyclicLinkedList(Node head) {
        Node currentNode = head;
        if(head==null) return null;
        Set<Node> uniqueListNodes = new HashSet<>();

        while(currentNode.next != null){
            if(uniqueListNodes.contains(currentNode)) return currentNode;
            uniqueListNodes.add(currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }
	
}
