package linkedList;

import org.junit.Test;

import linkedList.SinglyLL_SongPlayList.PlayListNode;
import linkedList.SinglyLinkedList_Implementation.Node;

public class DoublyLinkedList_Implementation {
	Node head;
	Node tail;
	int length;
	public class Node {
		int value;
		Node next;
		Node prev;
		
		public Node(int value) {
			this.value = value;
			next = null;
		}
	}
	
	/*
	 * add(int val) - Done
	 * addFirst(int val) - Done
	 * removeFirst() - Done
	 * removeLast() - Done
	 * removeVal(int val) - Done
	 * printVals(Node node) - Done
	 * removeFromIndex(int index)
	 * set(int index, int val)
	 * get(int index) - Done
	 * indexOf(int val) - Done
	 * lastIndexOf(int val) - Done
	 * addAll(int[] arr) - Done
	 * removeAll(int val) - Done
	 * 
	 * 
	 * 
	 */
	
	//Adds a specific value into the linkedlist
	public void add(int val) {
		Node temp = new Node(val);
		if(head==null) {	
			head = tail = temp;
			head.prev = null;
		} else {
			Node temp2 = tail;
			tail.next = temp;
			tail = temp;
			tail.prev = temp2;
		}
		length++;
	}
	
	// Adds the given value at the front of linkedList
	public void addFirst(int val) {
		Node temp = new Node(val);
		Node tail = head;
		head = temp;
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		length++;
	}
	
	//Removes the first value from the linkedList
	public void removeFirst() {
		if(head==null) tail=null;
		head = head.next;
		head.prev = null;
		length--;
	}
	
	//Removes the last value from the linked list
	public void removeLast() {
		if(head==tail) {
			head = tail = null;
		} else {
			tail.prev.next = null;
			tail = tail.prev;	
		}
		length--;
		
	}
	
	public void printVals(Node head) {
		if(head==null) System.out.println("Nothing to print");
		else {
		while(head!=null) {
			System.out.print(head.value+"-");
			head = head.next;
		}
		System.out.println("--");
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
	
	// Removes the first occurrence of given val
	public boolean removeVal(int val) {
		if(head==null) return false;
		Node temp1 = head;
		Node temp2 = temp1.next;
		while(temp2!=null) {
			if(temp1.value == val) {
				head = head.next;
				head.prev = null;
				length--;
				return true;
			} else {
				if(temp2.value == val) {
					temp1.next = temp2.next;
					temp2 = temp2.next;
					temp2.prev = temp1;
					length--;
					return true;
				}
			}
		}
		return false;
		
	}
	
	public void set(int index,int val) {
		int currLen = 0;
		Node temp1 = head;
		Node temp2 = head.next;
		Node currVal = new Node(val);
		if(index==0) addFirst(val);
		currLen = 1;
		while(currLen != index) {
			temp1 = temp2;
			temp2 = temp2.next;
			currLen++;
		}
		temp2 = currVal;
		currVal = temp2;
		temp1.next = temp2;
		temp2.prev = temp1;
		temp2 = temp2.next;
		currVal = temp2;
		
		
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
	
	public void removeAll(int val){
		Node temp = head;
		Node second = head.next;
		while(temp!=null && temp.value==val) {
			head = temp.next;
			temp = head;
			head.prev = null;
			length--;
		}
		second = temp.next;
		while(second != null) {
			while(second!=null && second.value == val) {
				temp.next = second.next;
				second = second.next;
				second.prev = temp;
				length--;
			}
			temp = second;
			if(second!=null) second = second.next;
		}
	}
	
	public void addAll(int[] val){
		Node temp = null;
		for(int i : val) {
			temp = new Node(i);
			if(head==null) {
				head = tail = temp;
				tail.prev = null;
			}else {	
				Node prevVal = tail;
				tail.next = temp;
				tail = temp;
				tail.prev = prevVal;
			}
			length++;
		}
	}
	
	
	
	@Test
	public void addFirstTest() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		addFirst(10);
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void removeFirstTest() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		removeFirst();
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void removeLastTest() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		removeLast();
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void removeLastTest2() {
		int[] input = {1};
		for(int curr : input) {
			add(curr);
		}
		removeLast();
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void removeValTest() {
		int[] input = {1,2,2,3,4};
		for(int curr : input) {
			add(curr);
		}
		removeVal(2);
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void removeValTest2() {
		int[] input = {1,2,2,3,4};
		for(int curr : input) {
			add(curr);
		}
		removeVal(1);
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void removeValTest3() {
		int[] input = {1};
		for(int curr : input) {
			add(curr);
		}
		removeVal(1);
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void removeValTest4() {
		int[] input = {};
		for(int curr : input) {
			add(curr);
		}
		removeVal(1);
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void setVal1() {
		int[] input = {1,2,3,4,5};
		for(int curr : input) {
			add(curr);
		}
		set(1,10);
		printVals(head);
		System.out.println("-");
	}
	
	@Test
	public void example2() {
		int[] input = {};
		for(int curr : input) {
			add(curr);
		}
		indexOf(10);
		lastIndexOf(10);
	}
	
	@Test
	public void example3() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		indexOf(2);
		lastIndexOf(2);
	}
	
	@Test
	public void removeLastExample() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		removeLast();
	}
	
	@Test
	public void addExample() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		printVals(tail);
		removeLast();
		printVals(tail);
		System.out.println("--");
		printVals(head);
	}
	
	@Test
	public void removeAllTest() {
		int[] arr = {1,2,2,3,4,2,2,5};
		for(int i : arr) {
			add(i);
		}
		removeAll(2);
		printVals(head);
		//54321
	}
	
	@Test
	public void addAllTest() {
		int[] arr = {1,2,2,3,4,2,2,5};
		addAll(arr);
		printVals(head);
		//54321
	}
	
}
