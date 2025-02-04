package MidtermDoublyLinkedListActivity;

public class ListNode {
	//CLASSFIELDS
	private String lastName;
	private String firstName;
	private ListNode next;
	private ListNode previous;
	
	//CONSTRUCTOR
	public ListNode() {
		this.lastName = "Dela Cruz";
		this.firstName = "Juan";
		this.next = null;
		this.previous = null;
	}

	public ListNode(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.next = null;
		this.previous = null;
	}
	
	//SETTERS AND GETTERS
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public void setPrevious(ListNode previous) {
		this.previous = previous;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public ListNode getNext() {
		return this.next;
	}
	
	public ListNode getPrevious() {
		return this.previous;
	}
}
