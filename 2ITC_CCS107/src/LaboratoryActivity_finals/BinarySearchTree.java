package LaboratoryActivity_finals;

public class BinarySearchTree {

	private Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void insert(int key) {
		this.root = insertNode(this.root, key);
	}
	
	public Node insertNode(Node root, int key) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		
		if(key < root.getKey())
			root.setLeft(insertNode(root.getLeft(), key));
		else if(key > root.getKey()) 
			root.setRight(insertNode(root.getRight(), key));
			
		return root;
	}
	
	public void search(int key) {
		Node temp = searchNode(this.root, key);
		if(temp != null)
			System.out.print("\n"+key+" was found in the tree.");
		else
			System.out.print("\n"+key+" does not exists in the tree.");
		
	}
	
	public Node searchNode(Node root, int key) {
		if(root == null || root.getKey() == key)
			return root;
		
		if(root.getKey() > key) 
			return searchNode(root.getLeft(), key);
		
		return searchNode(root.getRight(), key);
	}
	
	public void printInorder(Node node) {
		if(node == null)
			return; 
		
		printInorder(node.getLeft());
		System.out.print(node.getKey()+" ");
		printInorder(node.getRight());
	}
	
	public void printPreOrder(Node node) {
		if(node == null)
			return; 
		System.out.print(node.getKey()+" ");
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
	}
	
	public void printPostOrder(Node node) {
		if(node == null)
			return; 
		
		printPostOrder(node.getLeft());
		printPostOrder(node.getRight());
		System.out.print(node.getKey()+" ");
		
	}
}

