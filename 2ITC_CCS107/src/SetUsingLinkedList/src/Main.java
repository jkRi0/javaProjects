package SetUsingLinkedList.src;
/*
 Rioveros, Justine Ken 
 Sta. Ana, Juliana Louise 
 Dec. 11, 2023
 2IT-C
 */

import java.util.Scanner;
public class Main {
	
	public static void main(String []args) {
		Scanner scan=new Scanner(System.in);
		LinkedList myList=new LinkedList();
		System.out.print("Enter the linked list size: ");
		int size = scan.nextInt();
		for(int count=0; count<size; count++) {
			System.out.print("Insert element: ");
			int element = scan.nextInt();
			myList.add(element);
		}
		scan.nextLine();
		
		
		while(true) {
			System.out.println("\nChoose an option");
			System.out.println("[1] Add element");
			System.out.println("[2] Display elements");
			System.out.println("[3] Exit");
			System.out.print("Enter: ");
			String input = scan.nextLine();
			if(input.equals("1")) {
				System.out.print("Enter element: ");
				int element = scan.nextInt();
				scan.nextLine();
				
				if(!myList.contains(element)) {
					myList.add(element);
					System.out.println("\nThe "+element+" has been added");
				}else
					System.out.println("\nThe "+element+" is already on the list");
				
			}else if(input.equals("2")) {
				System.out.println("\nThe List:");
				myList.DisplayList();
			}else if(input.equals("3")) {
				System.out.println("\nThe program has been terminated");
				System.exit(0);
			}else {
				System.out.println("\nInvalid Input, please try again");
			}
		
		}
	}
}
