package LaboratoryExam_Finals;
//Rioveros, Justine Ken
//Sta. Ana, Juliana Louise
//8/1/24
//2IT-C

import java.util.Scanner;

/*
write a program that creates BST using linked list based on the user input, given the pointer to the root of a
BST and a key K, return the number of nodes having a key values greater than, less than, or equal to K,
use the recursive method counting the visited nodes in the BST as possible
*/

public class Main {

	public static void main(String[] args) {
		BinarySearchTree searchTree = new BinarySearchTree();
		Scanner scan = new Scanner(System.in);

		// enter the size
		System.out.print("Enter Size: ");
		int size = scan.nextInt();

		// inserting nodes
		for (int count = 0; count < size; count++) {
			System.out.print("Enter node " + (count + 1) + ": ");
			int data = scan.nextInt();
			searchTree.insert(data);
		}

		// displaying the requirements
		System.out.println("\nNodes that greater than root: ");
		System.out.println(searchTree.TotalGreaterThanNodes());

		System.out.println("\nNodes that less than root: ");
		System.out.println(searchTree.TotalLessThanNodes());

		System.out.println("\nNodes that equals to root: ");
		System.out.println(searchTree.TotalEqualNodes());

		System.out.println("\n");
		searchTree.inorder();
	}

}
