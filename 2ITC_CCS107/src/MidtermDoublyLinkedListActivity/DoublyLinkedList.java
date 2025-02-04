package MidtermDoublyLinkedListActivity;

public class DoublyLinkedList {
	//CLASSFIELDS
	private ListNode head;
	
	//GETTERS AND SETTERS
	public ListNode getHead() {
		return this.head;
	}
	
	public void setHead(ListNode head) {
		this.head = head;
	}
	
	//METHODS
	public void addNode(ListNode listNode) {
		if(this.head == null) {
			this.head = listNode;
		}else {
			ListNode thisNode = head;
			while(thisNode.getNext() != null) {
				thisNode = thisNode.getNext();
			}
			thisNode.setNext(listNode);
			listNode.setPrevious(thisNode);
		}
	}
	
	public void DisplayNames() {
		ListNode thisNode = head;
		System.out.println("\nTHE LIST: ");
		while(thisNode != null) {
			System.out.println(thisNode.getLastName()+", "+thisNode.getFirstName()+"     \t"+thisNode.getNext()+"\t"+thisNode.getPrevious());
			//GET THE NEXT NODE IF ITS NOT NULL
			if(thisNode.getNext() != null) {
				thisNode = thisNode.getNext();
			}else {
				break;
			}
		}
		
		//PRINT THE NAMES IN REVERSE
		System.out.println("\nREVERSE LIST: ");
		while(thisNode != null) {
			System.out.println(thisNode.getLastName()+", "+thisNode.getFirstName());
			thisNode = thisNode.getPrevious();
		}
		
		
		//*****************************************************************
		System.out.println("\n");
		ListNode node = head;
		System.out.println(node.getLastName()+"  \t"+node);
		
		node = node.getNext();
		node = node.getNext();
		System.out.println(node.getLastName()+"  \t"+node);
		
		System.out.println("\n");
		ListNode temp = node;
		node = node.getPrevious();
		temp = node;
		System.out.println(node.getLastName()+"  \t"+node);
		System.out.println(temp.getLastName()+"  \t"+temp);
		System.out.println("\n");
		
		
		
		ListNode thisNode2 = head;
		System.out.println("\n+++++++++++++++++++++++++++++++++++");
		while(thisNode2 != null) {
			System.out.println(thisNode2.getLastName()+", "+thisNode2.getFirstName()+"     \t"+thisNode2.getNext()+"\t"+thisNode2.getPrevious());
			//GET THE NEXT NODE IF ITS NOT NULL
			if(thisNode2.getNext() != null) {
				thisNode2 = thisNode2.getNext();
			}else {
				break;
			}
		}
		//******************************************************************
	}
	
	public void RemoveSecondNode() {
		ListNode thisNode = head;
		ListNode tempNode;
		
		//STORE THE SECOND NODE IN TEMPORARY NODE
		thisNode = thisNode.getNext();
		tempNode = thisNode;
		
		//LINK THE HEAD TO THE THIRD NODE
		thisNode = thisNode.getNext();
		this.head.setNext(thisNode);
		thisNode.setPrevious(this.head);
		
		//REMOVE THE SECOND NODE
		tempNode = null;
	}
}
