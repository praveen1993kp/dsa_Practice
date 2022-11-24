package linkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;
// For the solution to work, execute in Leetcode
public class P05_SLL_RightRotateList_142 {
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
	 * -- In-Place Swapping --
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * Edge case: If k=0 or head=null, return head
	 * 1. If edge case doesn't meet, increase the length
	 * 2. Store head in a temp listnode
	 * 3. Traverse through the whole listnode and find the length
	 * 4. For handling k>length scenarios, update k as k%length
	 * 5. Traverse through all the nodes in given head. If currentLength < k, then move the current node value to tail
	 * 6. Continue till currentLength<k. Reassign head after every swap
	 * 7. Return the head node after all the iterations are done
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr = {1,2,3,4,5};
		int k = 2;
		int[] output = {4,5,1,2,3};
		Assert.assertEquals(rotateList(addAll(arr),k), addAll(arr));
	}
	
	@Test
	public void edge() {
		int[] arr = {1};
		int k = 2;
		int[] output = {1};
		Assert.assertEquals(rotateList(addAll(arr),k), addAll(arr));	
	}
	
	@Test
	public void edge2() {
		int[] arr = {1,2};
		int k = 3;
		int[] output = {2,1};
		Assert.assertEquals(rotateList(addAll(arr),k), addAll(arr));	
	}
	
	@Test
	public void edge3() {
		int[] arr = {0,1,2};
		int k = 4;
		int[] output = {2,0,1};
		Assert.assertEquals(rotateList(addAll(arr),k), addAll(arr));	
	}
	
	@Test
	public void negative() {
		int[] arr = {1,2,3,4,5};
		int k = 0;
		int[] output = {1,2,3,4,5};
		Assert.assertEquals(rotateList(addAll(arr),k), addAll(arr));	
	}
	
	@Test
	public void negative2() {
		int[] arr = {};
		int k = 3;
		int[] output = {};
		Assert.assertEquals(rotateList(addAll(arr),k), addAll(arr));	
	}

	private Object rotateList(Node addAll, int k) {
		if(k==0 || head==null || head.next==null) return head;   
        else length++;
        Node tail = head;
        
        while(tail.next != null){
            length++;
            tail = tail.next;
        }
        
        k = k%length;
        Node temp = head;
        Node node = null;
        int currLen = 0;
            while(currLen < length-k) {
                currLen++;
                node = new Node(temp.value);
                tail.next = node;
                tail = tail.next;
                head = head.next;
                temp = temp.next;
            }
            
        return head;
	}
	
}
