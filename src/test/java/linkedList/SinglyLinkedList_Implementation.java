package linkedList;

import org.junit.Test;

public class SinglyLinkedList_Implementation {
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
	
	public void removeFirst() {
		if(head==null) tail = null;
		head = head.next;
		length--;
	}
	
	public void printVals(Node head) {
		while(head!=null) {
			System.out.println(head.value);
			head = head.next;
		}
		
	}
	
	public void removeFromIndex(int index) {
		Node val1 = head;
		Node val2 = head.next;
		int currLen = 0;
		if(val1!=null) currLen++;
		while(currLen!=index) {
			val1 = val2;
			val2 = val2.next;
			currLen++;
		}
		val1.next = val2.next;
		length--;
		printVals(head);
	}
	
	public void removeVal(int val) {
		Node val1 = head.next;
		Node val2 = val1;
		while(val2.next != null) {
			if(val1.value==val) {
				val1.next = val2.next;
			}
			val1 = val2;
			val2 = val1.next;
		}
		printVals(head);
		
	}
	
	public void set(int index,int val) {
		int currLen = 0;
		Node temp = head;
		Node prev = head.next;
		while(currLen != index) {
			prev = temp;
			temp = temp.next;
			currLen++;
		}
		temp.value = val;
		prev.next = temp;
		printVals(head);
	}
	
	public int get(int index) {
		int currLen=0;
		Node temp = head;
		while(currLen!=index) {
			temp = temp.next;
			currLen++;
		}
		System.out.println(temp.value);
		return temp.value;
	}
	
	public int indexOf(int val) {
		int currLen = 0;
		Node temp = head;
		while(temp!=null) {
			if(temp.value == val) {
				System.out.println("First Index " + currLen);
				return currLen;
			}
			currLen++;
			temp = temp.next;
		}
		System.out.println("First Index " + -1);
		return -1;
	}
	
	public int lastIndexOf(int val) {
		int currLen = 0;
		int lastIndex = -1;
		Node temp = head;
		while(temp!=null) {
			if(temp.value == val) {
				if(currLen > lastIndex) {
					lastIndex = currLen;
				}	
			}
			currLen++;
			temp = temp.next;
		}
		System.out.println("Last Index "+ lastIndex);
		return lastIndex;
	}
	
	
	
	@Test
	public void example1() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		//System.out.println(get(3));
		//set(2,10);
		//get(2);
		//removeFromIndex(2);
		indexOf(10);
		lastIndexOf(10);
		//removeVal(3);
	}
	
	@Test
	public void example2() {
		int[] input = {};
		for(int curr : input) {
			add(curr);
		}
		//System.out.println(get(3));
		//set(2,10);
		//get(2);
		//removeFromIndex(2);
		indexOf(10);
		lastIndexOf(10);
		//removeVal(3);
	}
	
	@Test
	public void example3() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		//System.out.println(get(3));
		//set(2,10);
		//get(2);
		//removeFromIndex(2);
		indexOf(2);
		lastIndexOf(2);
		//removeVal(3);
	}
	
}
