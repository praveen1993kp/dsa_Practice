package linkedList;

import org.junit.Test;

import linkedList.SinglyLL_SongPlayList.PlayListNode;

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
	
	/*
	 * add(int val)
	 * addFirst(int val)
	 * removeFirst()
	 * removeLast()
	 * removeVal(int val)
	 * printVals(Node node)
	 * removeFromIndex(int index)
	 * set(int index, int val)
	 * get(int index)
	 * indexOf(int val)
	 * lastIndexOf(int val)
	 * addAll(int[] arr)
	 * removeAll(int val)
	 * 
	 * 
	 * /
	 */
	
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
			System.out.print(head.value + "-");
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
	
	
	//Removes the first occurrence of a value
	public boolean removeVal(int val) {
		if(head==null) return false;
		Node temp1 = head;
		Node temp2 = temp1.next;
		while(temp2!=null) {
			if(temp1.value==val) {
				head = head.next;
				length--;
				return true;
			}else {
				if(temp2.value==val) {
					temp1.next = temp2.next;
					temp2 = temp2.next;
					length--;
					return true;
				}
			}
		}
		return false;	
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
	
	public void addAll(int[] val){
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
	}
	
	public void removeAll(int val){
		Node first = head;
		Node second = head.next;
		while(first!=null && first.value==val) {
			head = first.next;
			first = head;
			length--;
		}
		if(first != null && first.next != null) second = first.next;
		else second = null;
		while(second != null) {
			while(second!=null && second.value == val) {
				first.next = second.next;
				second = second.next;
			}
			first = second;
			if(second!=null) second = second.next;
		}
	}
	
	
	@Test
	public void example1() {
		int[] input = {1,2,3,2,2,5};
		for(int curr : input) {
			add(curr);
		}
		indexOf(2);
		lastIndexOf(2);
		removeVal(1);
		printVals(head);
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
	public void removeAllTest() {
		int[] arr = {1,1,1,1,1};
		for(int i : arr) {
			add(i);
		}
		removeAll(1);
		printVals(head);
		//54321
	}
	
	@Test
	public void addAllTest() {
		int[] arr = {1,2,2,3,4,2,2,5};
		addAll(arr);
		printVals(head);
	}
	
}
