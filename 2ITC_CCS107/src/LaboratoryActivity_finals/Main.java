package LaboratoryActivity_finals;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		BinarySearchTree searchTree = new BinarySearchTree();
		Scanner scan = new Scanner(System.in);
		System.out.println("Type (exit) to stop inserting");
		System.out.println("Insert integer number, to continue.");
		while(true) {
			System.out.print("input: ");
			if(scan.hasNextInt()) {
				int number = scan.nextInt();
				searchTree.insert(number);
				scan.nextLine();
			}else if(scan.hasNextLine()){
				String input = scan.nextLine(); 
				if(input.equalsIgnoreCase("exit")) {
					
					break;
				}else {
					System.out.println("Please integer only!");
				}
			}
			
		}
		
		while(true) {
			System.out.println("\n\n1. Search");
			System.out.println("2. Print in Inorder");
			System.out.println("3. Print in Preorder");
			System.out.println("4. Print in PostOrder");
			System.out.println("5. Exit");
			System.out.print("Choose a function: ");
			String input=scan.nextLine();
			switch(input) {
			case "1":
				System.out.print("Enter a number to search: ");
				int number = scan.nextInt();
				searchTree.search(number);
				scan.nextLine();
				break;
			case "2":
				System.out.println("\nInorder traversal of binary tree is:");
				searchTree.printInorder(searchTree.getRoot());
				break;
			case "3":
				System.out.println("\nPreOrder traversal of binary tree is:");
				searchTree.printPreOrder(searchTree.getRoot());
				break;
			case "4":
				System.out.println("\nPostOrder traversal of binary tree is:");
				searchTree.printPostOrder(searchTree.getRoot());
				break;
			case "5":
				System.out.println("\nThe program terminated");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, please try again!");
				
			}
		}
	}

}
