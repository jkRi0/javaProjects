package SetUsingLinkedList.src;
/*
 Rioveros, Justine Ken 
 Sta. Ana, Juliana Louise 
 Dec. 11, 2023
 2IT-C
 */


public class LinkedList {
	private Node head;
	private int size;
	
	
	public LinkedList() {
		head=null;
		size=0;
	}
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	//TO ADD ELEMENTS
	public void add(int element) {
		if(!contains(element)) {
			Node newNode = new Node(element);
			if(head==null) {
				head = newNode;
				head.setNext(null);
			}else {
				Node temp=head;
				while(temp.getNext()!=null) {
					temp=temp.getNext();
				}
				temp.setNext(newNode);
			}
			size++;
		}
	}
	
	//TO FIND A ELEMENT
	public boolean contains(int element) {
		Node temp=head;
		while(temp!=null) {
			if(temp.getData()==element) {
				return true;
			}
			temp=temp.getNext();
		}
		
		return false;
	}
	
	//TO DISPLAY ELEMENTS
	public void DisplayList() {
		Node currentNode = head;
		while(currentNode!=null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
			
		}
			
	}
}
