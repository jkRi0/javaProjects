package SkipList;


public class SkipList {
    private SkipNode head;

    public SkipNode getHead() {
        return head;
    }

    public void setHead(SkipNode head) {
        this.head = head;
    }

    public void addNode(SkipNode node) {
        if (head == null) {
            head = node;
        } else {
            SkipNode currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                
            }
            currentNode.setNext(node);
        }
    }

    public void displayList() {
        if (head != null) {
            System.out.print("\nThe values are: ");
            SkipNode currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNext();
            }
        } else
            System.out.print("\nThe list is empty.");

    }
}
