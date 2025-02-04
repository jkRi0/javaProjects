package SkipList;

public class Node {
    // Storage for the node data
    private int data;
    // Storage for the address of the next node
    private Node next;

    // A no-argument constructor that creates a node with default values
    public Node() {
        data = 0;
        next = null;
    }

    // A constructor that creates a node with initial data specified by the
    // parameter
    public Node(int data) {
        this.data = data;
        next = null;
    }

    // Get and set methods for data
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    // Get and set methods for the next node
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
