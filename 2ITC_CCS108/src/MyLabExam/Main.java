package MyLabExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//	NOTE: Provide a pre-defined.list ofBooks and DVDs (at least 3 each) 
//	available for transactions. Make sure to
//	use the id class fields with unique values as way to select the items 
//	for borrowing and returning. Do not rely on
//	using the index of the item from the list to make the List structure dynamic.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		List <LibraryItem> itemList = new ArrayList<>();
		itemList.add(new Book(100, "Mathematics", "Juan Dela Cruz"));
		itemList.add(new Book(101, "Science", "Juan Dela Cruz"));
		itemList.add(new Book(100, "Data Structure", "Juan Dela Cruz"));
		itemList.add(new DVD(200, "Contemporary Arts", "Juan Dela Cruz"));
		itemList.add(new DVD(201, "HCI", "Juan Dela Cruz"));
		itemList.add(new DVD(202, "Computer Programming", "Juan Dela Cruz"));
		
		
		User objUser1 = new LibraryUser("James");
		
		while(true) {
			System.out.println("[1] Display available items");
			System.out.println("[2] Borrow an item");
			System.out.println("[3] Return an item");
			System.out.println("[4] Quit the system");
			System.out.print("Perform operation: ");
			String operation = scan.nextLine();
			switch(operation) {
			case "1":
				for(int count=0; count<itemList.size(); count++) {
					if(itemList.get(count).getCheckedOutStatus()!=null) {
						if(itemList.get(count) instanceof Book) {
							System.out.println("\nBOOK: "+itemList.get(count).getTitle());
						}else
							System.out.println("\nDVD: "+itemList.get(count).getTitle());
					}
				}
				
				break;
			case "2":
				if(itemList.size()!=0) {
					System.out.print("\nEnter Item ID: ");
					
					if(scan.hasNextInt()) {
						int input = scan.nextInt();
						for(int count1=0; count1<itemList.size(); count1++) {
							if(itemList.get(count1).getId()==input) {
								itemList.get(count1).setCheckedOutStatus(objUser1);
							}
						}
					}else
						System.out.println("\nPlease enter integer value");
				}else
					System.out.println("The list of item is empty");
				break;
			case "3":
				
				
				break;
			case "4":
				System.out.println("Program terminated...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option, please try again");
			}
		}
	}
}