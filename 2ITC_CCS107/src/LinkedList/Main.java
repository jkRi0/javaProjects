package LinkedList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		Node node = new Node();
		
		System.out.print("Enter the size of the list: ");
		//VALIDATE THE USER INPUT IF ITS AN INTEGER OR OTHER DATA TYPE
		if(scan.hasNextInt()) {
			int size = scan.nextInt();
			for(int count=0; count<size; count++) {
				
				boolean itsInteger = false;
				while(itsInteger != true){
					scan.nextLine();  //fill the scanner temporarily
					
					System.out.print("Enter a number for position "+(count+1)+": ");
					//VALIDATE THE USER INPUT IF ITS AN INTEGER OR OTHER DATA TYPE
					if(scan.hasNextInt()) {
						int integer = scan.nextInt();
						//ADD THE INTEGER TO A NODE
						list.CircularAddNode(new Node(integer));
						itsInteger = true;
					}else {
						System.out.println("\nThe program only accept integers!\n");
					}
				}
			}
		
			//list.FindTheHighestOdd();
			//list.FindDuplicate();
			list.DisplayCircularList();
			PromptMenus(list);
		}else {
			System.out.println("\nThe program only accept integers!\n");
			main(null);  //recursion to meet the needs for user input
		}
		
	}
	
	public static void PromptMenus(LinkedList list) {
		Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter [1] to insert a data");
        System.out.println("Enter [2] to delete a data");
        System.out.println("Enter [3] to search a number");
        System.out.println("Enter [4] to view the list");
        System.out.println("Enter [5] to exit the program");
        System.out.print("Enter your choice: ");
        String chosen = scan.nextLine();
        if (chosen.equals("1")) {
            ValidatePosition(chosen, list);

        } else if (chosen.equals("2")) {
            ValidatePosition(chosen, list);

        } else if (chosen.equals("3")) {
            ChooseOrder(list);
        	
        } else if (chosen.equals("4")) {
            list.DisplayCircularList();
            PromptMenus(list);

        } else if (chosen.equals("5")) {
            System.out.println("\nThe Program ended!");
            System.exit(0);
        } else {
            System.out.println("\nNone of the option!");
            PromptMenus(list);
        }
	}
	
	public static void ChooseOrder(LinkedList list) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n Enter [1] to search in ascending order");
        System.out.println(" Enter [2] to search in descending order");
        System.out.print(" Enter your choice: ");
        String chosen2 = scan.nextLine();
        boolean ascending = false;
        if(chosen2.equals("1")) {
            ascending = true;
        }else if(chosen2.equals("2")) {
            ascending = false;
        }else {
            System.out.println("\nNone of the option!");
            ChooseOrder(list);
        }
        
        System.out.print(" Enter the number to search for: ");
        if(scan.hasNextInt()) {
        	int numberToSearch = scan.nextInt();
            Node foundNode = list.SearchNumber(numberToSearch, ascending);
            if (foundNode != null) {
            	System.out.println("Number found: " + foundNode.getData());
                PromptMenus(list);
            }else {
            	PromptMenus(list);
            }
        } else {
            System.out.println("\nInvalid input. Please enter a valid integer.");
            PromptMenus(list);
        }
	}
	
	public static void ValidatePosition(String chosen, LinkedList list) {
		Scanner scan=new Scanner(System.in);
		System.out.println("\n Enter [1] if its at the beginning");
		System.out.println(" Enter [2] if its at the specific position");
		System.out.println(" Enter [3] if its at the end");
		System.out.println(" Enter [4] to exit the program");
		System.out.print(" Enter your choice: ");
		String chosen2=scan.nextLine();
		
		//AT THE BEGINNING
		if(chosen2.equals("1")) {
			// 1.1 - INSERT
			if(chosen.equals("1")) {
				System.out.print(" Enter the integer: ");
				//VALIDATE THE USER INPUT IF ITS AN INTEGER OR OTHER DATA TYPE
				if(scan.hasNextInt()) {
					int integer = scan.nextInt();
					list.InsertBeginning(new Node(integer));
					list.DisplayCircularList();
					PromptMenus(list);
				}else {
					System.out.println("\nThe program only accept integers!");
					PromptMenus(list);
				}
			}
			// 1.2 - REMOVE
			else if(chosen.equals("2")) {
				list.RemoveBeginning();
				list.DisplayCircularList();
				PromptMenus(list);
			}
		}
		//AT THE SPECIFIC POSITION
		else if(chosen2.equals("2")) {
			System.out.print(" Enter a position from 1 to " + list.getSize() + ": ");
			int position = scan.nextInt();
			//VALIDATE THE ENTERED POSITION
			if(position > 0 && position <= list.getSize()) {
				// 2.1 - INSERT
				if(chosen.equals("1")) {
					System.out.print(" Enter the integer: ");
					//VALIDATE THE USER INPUT IF ITS AN INTEGER OR OTHER DATA TYPE
					if(scan.hasNextInt()) {
						int integer = scan.nextInt();
						list.InsertAtPosition(new Node(integer), position);
						list.DisplayCircularList();
						PromptMenus(list);
					}else {
						System.out.println("\nThe program only accept integers!");
						PromptMenus(list);
					}
				}
				// 2.2 - REMOVE
				else if(chosen.equals("2")) {
					list.RemoveAtPosition(position);
					list.DisplayCircularList();
					PromptMenus(list);
				}
			}else {
				System.out.println("\nEntered position was not found!");
				ValidatePosition(chosen, list);
			}
		}
		//AT THE END
		else if(chosen2.equals("3")) {
			// 3.1 - INSERT
			if(chosen.equals("1")) {
				System.out.print(" Enter the integer: ");
				//VALIDATE THE USER INPUT IF ITS AN INTEGER OR OTHER DATA TYPE
				if(scan.hasNextInt()) {
					int integer = scan.nextInt();
					list.CircularAddNode(new Node(integer));
					list.DisplayCircularList();
					PromptMenus(list);
				}else {
					System.out.println("\nThe program only accept integers!");
					PromptMenus(list);
				}
			}
			// 3.2 - REMOVE
			else if(chosen.equals("2")) {
				list.RemoveEnd();
				list.DisplayCircularList();
				PromptMenus(list);
			}
		}
		//EXIT THE PROGRAM, AND INPUT VALIDATION
		else if(chosen2.equals("4")) {
			System.out.println("\nThe Program ended!");
			System.exit(0);
		}else {
			System.out.println("\nNone of the option!");
			PromptMenus(list);
		}
	}
}
