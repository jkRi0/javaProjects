package TreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	
	public BinaryTree(){
		root = null;
	}
	
	public BinaryTree(Node root){
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/* Given a binary tree, print its nodes according to the
	"bottom-up" postorder traversal. */
	public void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.getLeft());
		// then recur on right subtree
		printPostorder(node.getRight());
		// now deal with the node
		System.out.print(node.getKey() + " ");
	}
	
	/* Given a binary tree, print its nodes in inorder*/
	public void printInorder(Node node) {
		if (node == null)
			return;
		
		/* first recur on left child */
		printInorder(node.getLeft());
		/* then print the data of node */
		System.out.print(node.getKey() + " ");
		/* now recur on right child */
		printInorder(node.getRight());
	}
	
	/* Given a binary tree, print its nodes in preorder*/
	public void printPreorder(Node node) {
		if (node == null)
			return;
		
		/* first print data of node */
		System.out.print(node.getKey() + " ");
		/* then recur on left sutree */
		printPreorder(node.getLeft());
		/* now recur on right subtree */
		printPreorder(node.getRight());
	}

	// Wrappers over above recursive functions
	public void printPostorder() {
		printPostorder(root);
	}
	
	public void printInorder() {
		printInorder(root);
	}
	
	public void printPreorder() {
		printPreorder(root);
	}
	
	public void insert(Node root, int key) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		// Do level order traversal until we find
		// an empty place.
		while (!queue.isEmpty()) {
			root = queue.peek();
			queue.remove();
			if (root.getLeft() == null) {
				root.setLeft(new Node(key));
				break;
			} else
				queue.add(root.getLeft());
			
			if (root.getRight() == null) {
				root.setRight(new Node(key));
				break;
			} else
				queue.add(root.getRight());
		}
	}
	
	
	//******************************************************USING ARRAY AS DATA COLLECTION************************
	public void insertOnArray(Node root, int key) {
		Node[] arr = new Node[0]; 
		arr = this.DynamicArray(arr, root);
		
		while(arr != null) {
			root = arr[0];
			arr = null;
			if (root.getLeft() == null) {
				root.setLeft(new Node(key));
				break;
			} else
				arr = this.DynamicArray(arr, root.getLeft());
			if (root.getRight() == null) {
				root.setRight(new Node(key));
				break;
			} else
				arr = this.DynamicArray(arr, root.getRight());
		}
	}
	
	public Node[] DynamicArray(Node arr[], Node root) {
		Node tempArr[] = new Node[arr.length+1];
		for(int count=0; count<arr.length; count++) {
			tempArr[count]=arr[count];
		}
		tempArr[arr.length]=root;
		
		return tempArr;
		
	}
}




