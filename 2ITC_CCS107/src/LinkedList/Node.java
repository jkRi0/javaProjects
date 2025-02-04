package LinkedList;

public class Node {
	//CLASSFIELDS
	private int data;
	private Node next;
	private Node previous;
	
	
	//CONSTRUCTORS
	public Node() {
		data = 0;
		next = null;
	}
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
	
	//GETTERS AND SETTERS
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}
