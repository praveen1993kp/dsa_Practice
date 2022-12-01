package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;
// For the solution to work, execute in Leetcode
public class P06_SLL_IntersectionOfTwoLinkedLists_160 {
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
		
		public Node() {
			
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
		System.out.println("--");
	}
	
	public void printNodes(Node head) {
		while(head!=null) {
			System.out.print(head + "-");
			head = head.next;
		}
		System.out.println("--");
	}
	
	public Node addAll(int[] val){
		head = null;
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
	
	public Node[] createLists(int[] arr1,int[] arr2, int skipA, int skipB) {
		Node headA = null;
		Node tailA = headA;
		
		Node headB = null;
		Node tailB = headB;
		
		for(int i : arr1) {
			add(i);			
		}
		headA = head;
		tailA = headA;
		for(int i=0;i<skipA;i++) {
			tailA = tailA.next; 
		}
		
		for(int i=0;i<skipB;i++) {
			Node temp = new Node(arr2[i]);
			if(headB==null) {	
				headB = tailB = temp;
			} else {
				tailB.next = temp;
				tailB = temp;
			}
		}
		tailB.next = tailA;
		
		Node[] nodes = new Node[2];
		nodes[0] = headA;
		nodes[1] = headB;
		return nodes;
		
	}
	
	/*
	 * Pseudo Code
	 * 
	 * -- Create Input Lists --
	 * 
	 * 
	 * 1. Create nodes headA and tailA for first array and headB and tailB for second array
	 * 2. Add all the arr1 elements into the list. Find the elements starting from skipA
	 * 3. Add elements of arr2 into list2, only upto skipB length
	 * 4. Assign tailB as tailA
	 * 
	 * 
	 * -- Get Intersection Node --
	 * 1. Create a set to accommodate nodes
	 * 2. Assign two nodes temp1 and temp2 as headA and headB respectively
	 * 3. Add all the nodes of headA into set
	 * 4. Try to add all the nodes of headB into set and whenever it doesn't get added, return the node
	 * 
	 * Time: O(n)
	 * Space: O(n)
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr1 = {4,1,8,4,5};
		int[] arr2 = {5,6,1,8,4,5};
		int skipA = 2;
		int skipB = 3;
		printVals(intersection(createLists(arr1,arr2,skipA,skipB)));
		
	}
	
	
	public Node intersection(Node[] nodes) {
		Node temp1 = nodes[0];
		Node temp2 = nodes[1];
		Set<Node> hSet = new HashSet<>();
        while(temp1 != null){
            hSet.add(temp1);
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            if(!hSet.add(temp2)) return temp2;
            temp2 = temp2.next;
        }
        
        return null;
	}
}
