package SetUsingLinkedList.src;

/*
 Rioveros, Justine Ken 
 Sta. Ana, Juliana Louise 
 Dec. 11, 2023
 2IT-C
 */


public class Node {
	private int data;
	private Node next;
	
	public Node() {
		this.data=0;
		this.next=null;
	}
	
	public Node(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}
