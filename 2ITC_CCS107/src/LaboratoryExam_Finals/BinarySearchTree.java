package LaboratoryExam_Finals;
//Rioveros, Justine Ken
//Sta. Ana, Juliana Louise
//8/1/24
//2IT-C

public class BinarySearchTree {
    // classfields
    private Node root;
    private Node head;

    // constructors
    public BinarySearchTree() {
        root = null;
    }

    // METHODS
    public void insert(int key) {
        root = insertNode(root, key);
    }

    public Node insertNode(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        // less than root
        if (key < root.getKey()) {
            root.setLeft(insertNode(root.getLeft(), key));
        }
        // greater than root
        else if (key > root.getKey()) {
            root.setRight(insertNode(root.getRight(), key));
        }
        // equal root
        else {
        	if(head==null)
        		head = new Node(key);
        	else
        		this.AddDuplicate(key);
        }
        return root;
    }

    public void AddDuplicate(int key) {
        Node newNode = new Node(key);
        Node currentNode = head;
        while (currentNode.getNext() != null)
            currentNode = currentNode.getNext();
        currentNode.setNext(newNode);
    }

    public int TotalGreaterThanNodes() {
        return CountGreaterThan(root, 0);

    }

    public int TotalLessThanNodes() {
        return CountLessThan(root, 0);

    }

    public int TotalEqualNodes() {
        return CountEquals(head, 0);

    }

    // RECURSION FOR COUNTING

    private int CountGreaterThan(Node root, int count) {
    	Node temp = this.root;
    	System.out.println("okay");
    	
    	
        if (root.getKey() > temp.getKey() && root != null) {
        	// COUNT THE NODES THAT IS GREATER THAN THE ROOT
            System.out.println("---"+root.getKey());
            return CountGreaterThan(root.getRight(), count++)+1;
        }else
        	return 0;
    }

    public int CountLessThan(Node root, int count) {
    	Node temp = this.root;
    	System.out.println("okay");
    	
    	
    	if (root.getKey() < temp.getKey() && root != null) {
        	// COUNT THE NODES THAT IS LESS THAN THE ROOT
            System.out.println("---"+root.getKey());
            return CountLessThan(root.getLeft(), count++)+1;
        }else
        	return 0;
    }

    public int CountEquals(Node currentNode, int count) {
        if (currentNode != null) {
            return CountEquals(currentNode.getNext(), count)+1;
        } else
            return 0;

    }

    void inorder() {
        inorderRec(root, 0);
    }

    void inorderRec(Node root, int count) {
        Node temp = this.root;
        if (root != null) {
            inorderRec(root.getLeft(),count++);
            inorderRec(root.getRight(),count++);
            System.out.println(root.getKey() + " > " + temp.getKey()+"\t"+count);

        }
    }

}
