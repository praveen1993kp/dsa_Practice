package linkedList;

import org.junit.Test;

public class P01_RemoveDuplicatesFromSortedList_83 {
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
	
	@Test
	public void example1() {
		int[] input = {1,2,3,4,5};
		for(int curr : input) {
			add(curr);
		}
		
	}
	
}
