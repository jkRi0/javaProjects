package LinkedList;

public class LinkedList {
	//CLASSFIELDS
	private Node head;
	private Node tail;
	private int size = 0;
	
	//GETTER AND SETTERS
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	
	
	//METHODS
	
	//FOR SINGULAR
	public void AddNode(Node node) {
		if(head == null) {
			head = node;
			this.size++;
		}else {
			Node currentNode = head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
			this.size++;
		}
	}
	
	public void DisplayData() {
		Node currentNode = head;
		while(currentNode!=null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
	
	//FOR CIRCULAR with DOUBLY
	public void CircularAddNode(Node node) {
		if (head == null) {
            head = node;
            tail = node;
            head.setNext(head);
            head.setPrevious(head);
            this.size++;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != head) {
                currentNode = currentNode.getNext();
            }
            // SET THE NEW NODE PREVIOUS LINK WITH CURRENT NODE ADDRESS
            node.setPrevious(currentNode);

            // SET THE CURRENT NODE LINK WITH NEW NODE ADDRESS
            currentNode.setNext(node);

            // LINK THE NEW NODE TO THE HEAD NODE
            node.setNext(head);

            // SET THE NEW NODE AS TAIL NODE
            tail = node;

            // SET THE HEAD NODE PREVIOUS LINK WTIH THE TAIL ADDRESS
            head.setPrevious(tail);

            this.size++;

        }
	}
	
	public void DisplayCircularList() {
		if (head == null) {
            System.out.println("\nThe list is empty!");
        } else {
            System.out.println("\n***The list***");
            System.out.println("NODES\tADDRESSES (Next)\t\tADDRESSES (Prev)");
            
            //TRAVERSING HEAD TO TAIL
            Node currentNode = head;
            do {
                System.out.println(" "+currentNode.getData() + "\t" + currentNode.getNext() + "\t\t" + currentNode.getPrevious());
                currentNode = currentNode.getNext();
            } while (currentNode != head);

            // *****************************************************
            System.out.println("\n***List in Reverse***");
            System.out.println("NODES\tADDRESSES (Next)\t\tADDRESSES (Prev)");

            //TRAVERSING TAIL TO HEAD
            Node currentNode2 = tail;
            do {
                System.out.println(" "+currentNode2.getData() + "\t" + currentNode2.getNext() + "\t\t" + currentNode2.getPrevious());
                currentNode2 = currentNode2.getPrevious();
            } while (currentNode2 != tail);
            
            System.out.println("\nSize: " + this.size + "\n");
        }
	}
	
	public Node SearchNumber(int numberToSearch, boolean ascending) {
        Node foundNode = null;
        Node current = head;

        //VALIDATE IF THE LIST IS EMPTY
        if (this.size == 0) {
            System.out.println("The list is empty.");
        }
        
        //FUNCTION FOR SEARCHING IN ASCENDING ORDER
        if (ascending) {
            do {
                if (current.getData() == numberToSearch) {
                    foundNode = current;
                    break;
                }
                current = current.getNext();
            } while (current != head);
        } 
        
        //FUNCTION FOR SEARCHING IN DESCENDING ORDER
        else {
            do {
                if (current.getData() == numberToSearch) {
                    foundNode = current;
                    break;
                }
                current = current.getPrevious();
            } while (current != head);
        }
        
        //VALIDATE IF THE NODE WAS NOT FOUND
        if (foundNode == null) {
            System.out.println("Number not found in the list.");
        }
        return foundNode;
    }
	
	public void FindTheHighestOdd() {
		Node currentNode = head;
		//HEAD DATA AS DEFAULT HIGHEST
		int highest = Integer.MIN_VALUE; 
		
		while(currentNode != null) {
			//FIND THE ODD DATA
			if(currentNode.getData() % 2 != 0) {
				//FIND THE HIGHEST DATA
				if(currentNode.getData() > highest) {
					highest = currentNode.getData();
				}
			}
			//GET THE ADDRESS OF THE NEXT NODE
			currentNode = currentNode.getNext();
		}
		
		if(highest != Integer.MIN_VALUE) {
			System.out.println("Highest odd: " + highest);
		}else {
			System.out.println("No odd number found!");
		}
	}
	
	public void FindDuplicate() {
		// currentNode as first Object
		Node currentNode = head;
		boolean duplicate = false;

		while (currentNode != null) {
			// checker as second Object
			Node checker = currentNode.getNext();
			while (checker != null) {
				//
				if (currentNode.getData() == checker.getData()) {
					System.out.println("Duplicate found: " + currentNode.getData());
					duplicate = true;
					break;
				}
				checker = checker.getNext();
			}
			currentNode = currentNode.getNext();
		}

		if (!duplicate) {
			System.out.println("No duplicate has been found!");
			System.exit(0);
		}
	}
	
	public void InsertBeginning(Node node) {
		if(head == null) {
			head = node;
            tail = node;
            head.setNext(head);
            head.setPrevious(head);
            this.size++;
		}else {
			Node currentNode = head;
			
			//SET THE NEXT LINK OF NEW NODE WITH THE HEAD ADDRESS
			node.setNext(currentNode);
			
			//SET THE PREVIOUS LINK OF NEW NODE WITH THE TAIL ADDRESS
			node.setPrevious(tail);
			
			//SET THE PREVIOUS LINK OF HEAD WITH THE NEW NODE ADDRESS
			currentNode.setPrevious(node);
			
			//SET THE TAIL NECT LINK WITH THE NEW NODE, TO CREATE A CIRCULAR LIST
			tail.setNext(node);
			
			//SET THE NEW NODE AS HEAD
			head = node;
			
			this.size++;
		}
	}
	
	public void InsertAtPosition(Node node, int position) {
		if(position == 1) {
			this.InsertBeginning(node);
			
		}else if(head == null) {
			head = node;
            tail = node;
            head.setNext(head);
            head.setPrevious(head);
            this.size++;
		}else {
			int counter = 1;
			Node pointer = head;
			Node pointer2;
		
			//GET THE NODE BEFORE THE SELECTED POSITION, AND SET AS POINTER 2
			while(counter != position-1) {
				pointer = pointer.getNext();
				counter++;
			}
			pointer2 = pointer;
			
			//SET THE NEW NODE PREVIOUS LINK WITH POINTER ADDRESS
			node.setPrevious(pointer);
			
			//SET THE NEW NODE LINK WITH THE NEXT NODE OF POINTER
			pointer = pointer.getNext();
			node.setNext(pointer);
			
			//LINK THE POINTER 2 WITH THE NEW NODE
			pointer2.setNext(node);
			
			//SET THE POINTER'S PREVIOUS LINK WITH NEW NODE ADDRESS
			pointer.setPrevious(node);
			
			this.size++;
		}
	}
	
	public void RemoveBeginning() {
		if(this.size > 1) {
			Node tempHead = head;
			Node currentNode = head;
			
			//GET THE NODE AFTER THE HEAD
			currentNode = currentNode.getNext();
			
			//SET THE NODE AFTER THE HEAD AS NEW HEAD
			head = currentNode;
			
			//SET THE TAIL NEXT LINK WITH THE NEW HEAD ADDRESS
			tail.setNext(head);
			
			//SET THE HEAD PREVIOUS LINK WITH THE TAIL ADDRESS
			head.setPrevious(tail);
			
			//REMOVE THE TEMPORARY HEAD THAT HAS THE VALUE OF ORIGINAL HEAD
			tempHead = null;
		
			this.size--;
		}else if(this.size == 1){
			//DELETE THE HEAD
			head = null;
			this.size--;
		}else {
			System.out.println("\n***The list was already empty!***");
		}
	}
	
	public void RemoveAtPosition(int position) {
		if(position == 1) {
			this.RemoveBeginning();
			
		}else if(this.size > 1){
			int counter = 1;
			Node currentNode = head;
			Node pointer;
			Node removeNode;
		
			//TRAVERSING FOR POINTER, TO FIND THE NODE BEFORE THE NODE OF SELECTED POSITION
			while(counter != position-1) {
				currentNode = currentNode.getNext();
				counter++;
			}
			
			//SET THE POINTER AS TEMPORARY NODE
			pointer = currentNode;
			
			//GET THE NODE OF SELECTED POSITION
			currentNode = currentNode.getNext();
			removeNode = currentNode;
			
			//REMOVE THE NODE, WITH THE SELECTED POSITION
			removeNode = null;
			
			//SET THE POINTER NEXT LINK WITH THE ADDRESS OF NODE AFTER THE SELECTED NODE POSITION
			currentNode = currentNode.getNext();
			pointer.setNext(currentNode);
			
			//SET THE CURRENT NODE PREVIOUS LINK WITH THE POINTER ADDRESS
			currentNode.setPrevious(pointer);
			
			this.size--;
			
		}else if(this.size == 1){
			//DELETE THE HEAD
			head = null;
			this.size--;
		}else {
			System.out.println("\n***The list was already empty!***");
		}
	}

	public void RemoveEnd() {
		if(this.size > 1) {
			Node currentNode = tail;
			Node newTail;
			
			//GET THE NODE BEFORE THE TAIL NODE
			currentNode = currentNode.getPrevious();
			
			//SET THE NEW TAIL NODE
			newTail = currentNode;
			
			//REMOVE THE ORIGINAL TAIL NODE
			tail = null;
			
			//SET THE NEW TAIL
			tail = newTail;
			
			//SET THE NEW TAIL NODE NEXT LINK WITH THE HEAD ADDRESS
			tail.setNext(head);
			
			//SET THE PREVIOUS LINK OF HEAD WITH THE NEW TAIL ADDRESS
			head.setPrevious(tail);		
			this.size--;
		}else if(this.size == 1){
			//DELETE THE HEAD
			head = null;
			this.size--;
		}else {
			System.out.println("\n***The list was already empty!***");
		}
	}
}




