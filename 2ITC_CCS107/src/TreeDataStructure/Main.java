package TreeDataStructure;

import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		Node root = new Node(4);
		BinaryTree tree = new BinaryTree(root);
		tree.insert(root, 7);
		tree.insert(root, 6);
		tree.insert(root, 9);
		tree.insert(root, 2);
//		tree.insertOnArray(root, 11);
//		tree.insertOnArray(root, 7);
//		tree.insertOnArray(root, 9);
//		tree.insertOnArray(root, 15);
//		tree.insertOnArray(root, 8);
//		tree.insertOnArray(root, 13);
//		tree.insertOnArray(root, 12);
		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();
		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();
		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
		
		
//		OUTPUT:
//			
//			Preorder traversal of binary tree is 
//			10 11 9 12 15 7 8 13 
//			Inorder traversal of binary tree is 
//			12 9 11 15 10 8 7 13 
//			Postorder traversal of binary tree is 
//			12 9 15 11 8 13 7 10 
		
		System.out.println("\n");
		
		BinarySearchTree searchTree = new BinarySearchTree();
		searchTree.insert(50);
		searchTree.insert(30);
		searchTree.insert(20);
		searchTree.insert(40);
		searchTree.insert(70);
		searchTree.insert(60);
		searchTree.insert(80);
		
		searchTree.search(50);
		searchTree.search(30);
		searchTree.search(55);

		System.out.println("\n\nInorder traversal of binary tree is:");
		searchTree.printInorder(searchTree.getRoot());
		
//		OUTPUT:
//			
//			50 was found in the tree.
//			30 was found in the tree.
//			55 does not exists in the tree.
//
//			Inorder traversal of binary tree is:
//			20 30 40 50 60 70 80 
	}
 
}
