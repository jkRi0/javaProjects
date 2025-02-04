package LaboratoryExam_Finals;

//Rioveros, Justine Ken
//Sta. Ana, Juliana Louise
//8/1/24
//2IT-C

public class Node {

	// FOR TREE
	private int key;
	private Node left;
	private Node right;

	// FOR DUPLICATES
	private int data;
	private Node next;

	// CONSTRUCTORS
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public Node() {
		this.data = 0;
		this.next = null;
	}

	public Node(double data) {
		this.data = (int) data;
		this.next = null;
	}

	// GETTERS AND SETTERS
	public int getKey() {
		return key;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	// FOR DUPLICATES
	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
