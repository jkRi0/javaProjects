package SkipList;

public class LinkedList {
    // Storage for the address of the first node
    private Node head;

    // Get method for the first node
    public Node getHead() {
        return head;
    }

    // Set method for the first node
    public void setHead(Node head) {
        this.head = head;
    }

    // Method for adding a new node
    public void addNode(Node node) {
        if (head == null)
            head = node;
        else {
            Node currentNode = head;
            while (currentNode.getNext() != null)
                currentNode = currentNode.getNext();
            currentNode.setNext(node);
        }
    }

    // Method for displaying the contents of the linked list
    public void displayList() {
        if (head != null) {
            System.out.print("\nThe values are: ");
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNext();
            }
        } else {
            System.out.print("\nThe list is empty.");
        }
    }

    // Method for getting the length of the linked list
    public int getLength() {
        int counter = 0;
        Node currentNode = head;
        while (currentNode != null) {
            counter++;
            currentNode = currentNode.getNext();
        }
        return counter;
    }

    // Method for sorting the linked list using the Bubble Sort algorithm
    public void bubbleSort() {
        boolean noChanges = true;
        int temp;
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getData() > currentNode.getNext().getData()) {
                temp = currentNode.getData();
                currentNode.setData(currentNode.getNext().getData());
                currentNode.getNext().setData(temp);
                noChanges = false;
            }
            currentNode = currentNode.getNext();
        }
        if (!noChanges) {
            bubbleSort();
        }
    }
}
