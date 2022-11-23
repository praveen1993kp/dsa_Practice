package linkedList;

import org.junit.Test;

import junit.framework.Assert;
import linkedList.SinglyLL_SongPlayList.PlayListNode;

public class P02_SLL_PalindromeLinkedList_234 {
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
	
	public boolean palindromeList(Node node) {
		Node temp = head;
        Node tail = temp.next;
       
     while(head != null){   
         temp = head;
         tail = temp.next;
         
         if(tail == null) return true;
        while(tail.next != null){
            temp = tail;
            tail = tail.next;
        }
        if(tail.value != head.value) return false;
        head = head.next;
        temp.next = null;
    }
        return true;
	}
	
	
	public boolean isPalindrome(Node head) {
		if(head==null || head.next==null) return true;
        Node head2 = head;
        Node reverse = null;
        int length = 0;
        while(head != null){
            length++;
            reverse = addFirst(reverse,head.value);
            head = head.next;
        }
        while(length > length/2){
            if(head2.value != reverse.value) return false;
            length--;
            head2 = head2.next;
            reverse = reverse.next;
        }
        return true;
	}
	
	public Node addFirst(Node head,int val){
        Node node = new Node(val);
        Node temp = head;
        head = node;
        head.next = temp;
        return head;
    } 

	/*
	 * Pseudo Code
	 * 
	 * 1. Traverse while head not equal to null
	 * 2. Take head as temp and next of temp as tail
	 * 3. Edge case: If tail equals null, return true (single element i.e. head)
	 * 4. Traverse and find the last element
	 * 5. Check if the last element is same as head. If not, return false
	 * 6. Reset head to head.next
	 * 7. Repeat steps 2-6 till head becomes null or head.next is null
	 * 9. Return true by default
	 * 
	 * -- Method 2 --
	 * 
	 * 1. Reverse the given head and store it in another node (Using addFirst method)
	 * 2. Calculate the length of the list while reversing
	 * 3. After all the elements are reversed, traverse for length > length/2 and head != null
	 * 4. If head2 value and reverse value are not same, return false
	 * 5. Decrease the length for each iteration and assign head2 and reverse to next node
	 * 6. Continue steps 4-6 and return true if a list passes all the iterations
	 * 
	 */
	
	//Test Data
	
	@Test
	public void positive() {
		int[] arr = {1,2,2,1};
		Assert.assertEquals(isPalindrome(addAll(arr)), true);
	}
	
	@Test
	public void edge() {
		int[] arr = {1};
		Assert.assertEquals(isPalindrome(addAll(arr)), true);	
	}
	
	@Test
	public void edge2() {
		int[] arr = {1,0,1};
		Assert.assertEquals(isPalindrome(addAll(arr)), true);	
	}
	
	@Test
	public void edge3() {
		int[] arr = {1,1,1,1};
		Assert.assertEquals(isPalindrome(addAll(arr)), true);	
	}
	
	@Test
	public void negative() {
		int[] arr = {1,2,3,4,1};
		Assert.assertEquals(isPalindrome(addAll(arr)), false);	
	}
	
}
