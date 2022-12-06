package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;
// For the solution to work, execute in Leetcode
public class P07_SLL_MergeTwoSortedLists_21 {
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
			System.out.println(head.value);
			head = head.next;
		}
		
	}
	
	public Node addAll(int[] val){
		Node temp = null;
		head = null;
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
	 * Edge case: If one of the lists is null, return the other list
	 * 
	 * 1. Traverse through each list at the same time
	 * 2. Compare the current values in list1 and list2. Whichever is smaller, add into mergedList and move the node to next
	 * 3. Continue till both lists are not null
	 * 4. When one list becomes null, add all the remaining nodes of another list into the merged list
	 * 5. Return the merged list
	 * 
	 * Recursion:
	 * 
	 * 1. Call the helperMethod with initial parameters
	 * 2. Breaking point inside helper method: When list1 or list2 is null, return head
	 * 3. Call the helperMethod recursively from the helperMethod in the return statement
	 * 
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr1 = {1,2,4};
		int[] arr2 = {1,3,4};
		printVals(mergeLists_Recursive((addAll(arr1)),addAll(arr2)));
	}
	
	@Test
	public void edge() {
		int[] arr1 = {};
		int[] arr2 = {};
		printVals(mergeLists_Recursive((addAll(arr1)),addAll(arr2)));	
	}
	
	@Test
	public void edge2() {
		int[] arr1 = {};
		int[] arr2 = {0};
		printVals(mergeLists_Recursive((addAll(arr1)),addAll(arr2)));
	}

	private Node mergeLists(Node list1, Node list2) {
	        Node head = new Node();
	        Node tail = head;
	        if(list1==null) return list2;
	        if(list2==null) return list1;
	        while(list1!=null && list2 !=null){
	            if(list1.value < list2.value){
	                tail.next = list1;
	                list1 = list1.next;
	            } else {
	                tail.next = list2;
	                list2 = list2.next;
	            }
	            //printMethod(head);
	            tail = tail.next;      
	            if(list1==null)
	                tail.next = list2;
	            else if (list2==null)
	                tail.next = list1;
	        }
	        return head.next;
	}
	
	private Node mergeLists_Recursive(Node list1, Node list2) {
		Node head = new Node();
        Node tail = head;
        if(list1==null) return list2;
        if(list2==null) return list1;
        
        return helperMethod(list1, list2,head,tail).next;
	}
	
	public Node helperMethod(Node list1, Node list2,Node head, Node tail){
        if(list1 ==null || list2 ==null) return head;
            if(list1.value < list2.value){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            //printMethod(head);
            tail = tail.next;      
            if(list1==null)
                tail.next = list2;
            else if (list2==null)
                tail.next = list1;
        return helperMethod(list1, list2,head,tail);
    }

}
