package finalsProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	static Scanner scan = new Scanner(System.in);
	//Static instances for creating object of every management. 
	static ManagementSystem []management = new ManagementSystem[3];
	static AccountManagement objAM = new AccountManagement();
	static SalesManagement objSM = new SalesManagement();
	static InventoryManagement objIM = new InventoryManagement();
	static Report objReport = new Report();
	//LIST OF OBJECT FOR PRODUCTS, TO HAVE ITS OWN INDEPENDENT LIFE CYCLE
	static List<Product> productList = new ArrayList<Product>();
	static int productIdCounter = 100;
	
    public static void main(String []args) {
    	//POLYMORPHIC ARRAY FOR UPCASTING
    	management[0] = Main.objAM;
    	management[1] = Main.objSM;
    	management[2] = Main.objIM;
    	//TO GET AWARE OF ONE CLASS WITH ANOTHER
    	Main.objSM.setInventoryManagement(objIM);
    	Main.objReport.setInventory(objIM);
    	Main.objReport.setSales(objSM);
    	
    	Main.LoggingIn();
    }
    
    public static void LoggingIn() {
    	System.out.println("\n********************************************");
    	System.out.println("v1.2     ______    _______    ________");
    	System.out.println("	/ __  /   / ___  /   / ______/");
    	System.out.println("       / /_/ /   / /  / /   / /_____  ");
    	System.out.println("      / ____/   / /  / /   /_____  /  ");
    	System.out.println("     / /       / /  / /         / /   ");
    	System.out.println("    / /       / /__/ /   ______/ /    ");
    	System.out.println("   /_/       /______/   /_______/     ");
    	System.out.println("\nWelcome to Point of Sale Management System ");
    	System.out.println("********************************************");
    	
    	
    	objAM.setIsLogged(false);	//SET IF THERE IS A LOGGED ACCOUNT TO FALSE AS DEFAULT
    	objAM.LoginAccount();		//LOG IN OR REGISTER AN ACCOUNT
    	if(objAM.getIsLogged()) {	//IF THERE WAS ANY LOGGED ACCOUNT, PROCEED TO VERIFICATION
    		//TRAVERSE TO THE LIST OF USER ACCOUNTS
    		for(Account account : objAM.getAccountList()) {
    			//CHECKS THE LOGGED ACCOUNT IF ITS ON THE LIST OF USER ACCOUNTS
    			if(account.getAccountId()==objAM.getLoggedAccountId()) {
    				//VALIDATE THE USER ACCOUNT IF ITS ADMIN OR LOCAL ACCOUNT
    				if(!account.getIsAdmin())
    					//IF ITS LOCAL ACCOUNT, PROCEED TO PROMPT THE LIMITED MENU'S OF THE APPLICATION
    					Main.DisplayLocalAccountMenu(management[1]);
    				else
    					//IF ITS ADMIN ACCOUNT, PROCCED TO PROMPT THE ENTIRE MENU'S OF THE APPLICATION
    					Main.DisplayAdminAccountMenu();
    			}
    		}
    	}
    }
    
    //DISPLAY THE LIMITED MENU'S FOR LOCAL ACCOUNT
    public static void DisplayLocalAccountMenu(ManagementSystem management) {
    	while(true) {
    		System.out.println("\n--------------------------------------------");
    		System.out.println("[1]Add Transaction, [2]View products, [3]Log out");
    		System.out.print("Enter option: ");
    		String input = Main.scan.nextLine();
    		if(input.equals("1")) {
    			management.AddToList();
    		}else if(input.equals("2")) {
    			Main.objIM.ViewTheList();;
    		}else if(input.equals("3")) {
    			Main.LoggingIn();
    		}else {
    			System.out.println("\nInvalid input, please try again.");
    		}
    	}
    }
    
    //DISPLAY THE MANAGEMENT MENU'S FOR ADMIN ACCOUNT
    public static void DisplayAdminAccountMenu() {
    	while(true) {
    		System.out.println("\n--------------------------------------------");
    		System.out.println("[1]Account Management    [2]Sales Management  ");
    		System.out.println("[3]Inventory Management  [4]Report  [5]Log out");
    		System.out.print("Enter option: ");
    		String input = Main.scan.nextLine();
    		if(input.equals("1")) {
    			Main.DisplaySubMenu(management[0], "Account Management","account");
    		}else if(input.equals("2")) {
    			Main.DisplaySubMenu(management[1], "Sales Management","transaction");
    		}else if(input.equals("3")) {
    			Main.DisplaySubMenu(management[2], "Inventory Management","product");
    		}else if(input.equals("4")) {
    			Main.objReport.ProductSoldReport();
    		}else if(input.equals("5")) {
    			Main.LoggingIn();
    		}else {
    			System.out.println("\nInvalid input, please try again.");
    		}
    	}
    }
    
    //DISPLAY THE SUB MENU'S FOR EACH MANAGEMENET
    public static void DisplaySubMenu(ManagementSystem management, String pageHeader, String title) {
    	while(true) {
    		System.out.println("\n---------------"+pageHeader+"---------------");
    		System.out.println("~For managing "+title+" data's\n");
    		System.out.println("[1]Add new "+title+"\t[2]View "+title+"s");
    		System.out.println("[3]Update "+title+"\t[4]Remove "+title+"\t[5]Back");
    		System.out.print("Enter option: ");
    		String input = Main.scan.nextLine();
    		if(input.equals("1")) {
    			//INSTANCE-OF WAS ONLY USED, WHEN CREATING OR LISTING A NEW PRODUCT
    			if(management instanceof InventoryManagement) {
    				System.out.print("Enter product name: ");
    				String name = Main.scan.nextLine();
    				System.out.print("Enter product price: ");
    				double price = Main.scan.hasNextDouble()? Main.scan.nextDouble():0.0;
    										/*PREVENTING TO ENTER AN INVALID ASCII CHARACTERS*/ 
    				Main.scan.nextLine();  	//CONSUME THE NON-STRING INPUT AS A NEXT LINE
    				System.out.print("Enter product stocks: ");
    				int stocks = Main.scan.hasNextInt()? Main.scan.nextInt():0;
    				
    				//THE CREATED OBJECT WAS ADDED TO THE LIST
    				Product objProduct = new Product(Main.productIdCounter, name, price, stocks);
    				objProduct.setInventoryManagement(Main.objIM);  //TO GET AWARE OF ITS WHOLE
    				Main.objIM.AddToList(objProduct);  //ADDING OF PRODUCT FOR THE LIST INSIDE THE INVENTORY
    				Main.productList.add(objProduct);  //FOR PRODUCT INDEPENDENT LIFE CYCLE
    				
    				Main.productIdCounter++;
    				Main.scan.nextLine();
    				
    				/*NO CANCELLATION FOR PRODUCT CREATION. HOWEVER, IT CAN BE EDITED OR DELETED*/
    			}else {
    				management.AddToList();
    				
    				if(management instanceof SalesManagement) {
    					//UPDATING THE LIST OF PRODUCT
    					//THIS WAS ONLY USED WHEN ADDING A TRANSACTION IN SALES MANAGEMENT
    					//BECAUSE OF UPDATING THE QUANTITY OF PRODUCTS FOR EVERY TRANSACTION
    					Main.productList = Main.objIM.getProductList();
    				}
    			}
    		}else if(input.equals("2")) {
    			System.out.println("\n***THE LIST***");
    			management.ViewTheList();
    		}else if(input.equals("3")) {
    			management.UpdateOnTheList();
    			
    			if(management instanceof InventoryManagement) {
					//WHEN UPDATING THE LIST OF PRODUCT
					//THE LIST IN MAIN CLASS MUST ALSO UPDATE FOR INDEPENDENT LIFE CYCLE
					Main.productList = Main.objIM.getProductList();
				}
    		}else if(input.equals("4")) {
    			management.RemoveFromTheList();
    			
    			if(management instanceof InventoryManagement) {
    				//UPDATING THE LIST OF PRODUCT IN THE MAIN CLASS
					Main.productList = Main.objIM.getProductList();
				}
    		}else if(input.equals("5")) {
    			return;
    		}else {
    			System.out.println("\nInvalid input, please try again.");
    		}
    	}
    }
}

