package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;
// For the solution to work, execute in Leetcode
public class P08_SLL_RemoveLinkedListElements_203 {
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
	 * 1. Take instances of head and head.next as temp1 and next1
	 * 2. If next1.val == val, point temp1.next as next1.next
	 * 3. If repointing is done, move next1 alone
	 * 4. else, move temp1 too
	 * 5. Traverse till next1 != null
	 * 6. return head
	 * 
	 * -- Recursion --
	 * 1. Take node instances in the method
	 * 2. Call the helper method with required parameters
	 * 3. Breaking point : When current element is null, return head
	 * 4. After the operations are completed, call the helper method again using updated parameters
	 * 5. return head
	 * 
	 * 
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr = {1,2,6,3,4,5,6};
		int val = 6;
		int[] output = {1,2,3,4,5};
		Assert.assertEquals(removeTargetElement_Recursion(addAll(arr),val), addAll(output));
	}
	
	@Test
	public void edge() {
		int[] arr = {};
		int val = 6;
		int[] output = {};
		Assert.assertEquals(removeTargetElement_Recursion(addAll(arr),val), addAll(output));	
	}
	
	@Test
	public void edge2() {
		int[] arr = {1};
		int val = 1;
		int[] output = {};
		Assert.assertEquals(removeTargetElement_Recursion(addAll(arr),val), addAll(output));
	}
	
	@Test
	public void negative() {
		int[] arr = {2};
		int val = 1;
		int[] output = {2};
		Assert.assertEquals(removeTargetElement_Recursion(addAll(arr),val), addAll(output));	
	}
	
	@Test
	public void negative2() {
		int[] arr = {2,2,2,2};
		int val = 2;
		int[] output = {};
		Assert.assertEquals(removeTargetElement_Recursion(addAll(arr),val), addAll(output));	
	}


	private Object removeTargetElement(Node addAll, int val) {
		Node temp1 = head;
        Node next1 = head;
        
        while(next1 != null){
            if(next1.value==val){
                if(temp1==next1){
                    head = temp1 = next1 = next1.next;
                } else {
                    temp1.next = next1.next;
                    next1 = next1.next;
                }
            } else {
                temp1 = next1;
                next1 = next1.next;
            }
        }
        return head;
	}
	
	// Code is same as that of above but since next1 = next1.next is happening for all conditions, keeping it as generic statement
	private Object removeTargetElement_SlightlyOptimized(Node head, int val) {
		Node temp1 = head;
        Node next1 = head;
        
        while(next1 != null){
            if(next1.value==val){
                if(temp1==next1){
                    head = temp1 = next1.next;
                } else {
                    temp1.next = next1.next;
                }
            } else {
                temp1 = next1;   
            }
            next1 = next1.next;
        }
        return head;
	}
	
	private Node removeTargetElement_Recursion(Node addAll, int val) {
		Node temp1 = head;
        Node next1 = head;
        
        printVals (recursion(head,temp1,next1,val));
        return recursion(head,temp1,next1,val);
	}
	
	public Node recursion(Node head, Node temp1, Node next1,int val){
        if(next1 == null) return head;
            if(next1.value==val)
                if(temp1==next1) head = temp1 = next1.next;
                else temp1.next = next1.next;
            else temp1 = next1;
    
        return recursion(head,temp1,next1.next,val);
    }
	
}
