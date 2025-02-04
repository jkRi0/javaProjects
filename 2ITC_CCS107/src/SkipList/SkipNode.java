package SkipList;

public class SkipNode {
    // Storage for the node data
    private int data;
    // Storage for the address of the next node
    private SkipNode next;
    // Storage for the address of the bottom node
    private Node bottom;

    // A no-argument constructor that creates a node with default values
    public SkipNode() {
        data = 0;
        next = null;
        bottom = null;
    }

    // Get and set methods for data
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    // Get and set methods for the next node
    public SkipNode getNext() {
        return next;
    }

    public void setNext(SkipNode next) {
        this.next = next;
    }

    // Get and set methods for the bottom node
    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }
}
