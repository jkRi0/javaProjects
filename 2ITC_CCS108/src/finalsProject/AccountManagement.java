package finalsProject;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
//Responsible for creating, saving, editing, and logging in of accounts.
public class AccountManagement extends ManagementSystem{
	//CLASSFIELDS
	private Scanner scan=new Scanner(System.in);
    private List <Account> accountList = new ArrayList<Account>();
    private int accountCounter = 1000;
    private int key = 12345;
    private boolean isLogged = false;	//TO DETERMINE IF SOMEONE LOGGED'S AN ACCOUNT
    private int loggedAccountId;		//SAVE THE USER ACCOUNT ID WHO LOGGED INTO THE SYSTEM

    //GETTERS AND SETTERS
    public List<Account> getAccountList() {
		return accountList;
	}
    
    public int getKey() {
    	return this.key;
    }
    
    public boolean getIsLogged() {
    	return this.isLogged;
    }
    
    public int getLoggedAccountId() {
    	return this.loggedAccountId;
    }
    
    public void setIsLogged(boolean isLogged) {
    	this.isLogged = isLogged;
    }
    
    public void setKey(int key) {
    	this.key = key;
    }
	
    public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
    
	//Responsible for logging in as well as creating new accounts.
    public void LoginAccount() {
    	while(true) {
    		System.out.println("\n[1]Login, [2]Register, [3]Exit");
    		System.out.print("Enter option: ");
    		String input = this.scan.nextLine();
    		//Prompt the user to enter user name and password for logging in if there is account saved in the list.
    		if(input.equals("1")) {
    			System.out.print("Enter username: ");
    			String username = this.scan.nextLine();
    			System.out.print("Enter password: ");
    			String password = this.scan.nextLine();
    			//CHECKS THE LIST OF ACCOUNT BEFORE VERIFICATION
    			if(!this.accountList.isEmpty()) {
    				//VERIFICATION OF LOGGED USER ACCOUNT
    				for(Account account : this.accountList) {
    					//IF THE USERNAME AND PASSWORD IS EQUAL TO THE SAVED ACCOUNT
    					if(account.getUsername().equals(username) && 
    					account.getPassword().equals(password)) {
    						this.isLogged = true;	//CONFIRMATION THAT IS SOMEONE LOG'S IN INTO THE SYSTEM 
    						this.loggedAccountId = account.getAccountId();	//SAVED THE ACCOUNT IF WHO LOGGED IN
    						return;
    					}
    				}
    				if(!this.isLogged)
    					System.out.println("\nIncorrect details, please try again");
    			}else
    				System.out.println("\nNo saved accounts");
    		}else if(input.equals("2")) {
    			this.AddToList();
    		}else if(input.equals("3")) {
    			System.out.println("\nThe program has been terminated!");
    			System.exit(1);
    		}else 
    			System.out.println("\nInvalid input, please try again");
    	}
    }
    
    //Use to create an account for either local or admin account.
    public void AddToList() {
    	while(true) {
    		System.out.println("\n[1]Local account, [2]Admin account, [3]Back");
    		System.out.print("Enter option: ");
    		String input = this.scan.nextLine();
    		if(input.equals("3"))
    			return;
    		//Prompt the user to enter user name and password for saving the account to the list.
    		System.out.print("Enter username: ");
    		String username = this.scan.nextLine();
    		System.out.print("Enter password: ");
    		String password = this.scan.nextLine();
    		//The user name and password cannot be duplicated.
    		for(Account account : this.accountList) {
    			if(username.equals(account.getUsername())&&password.equals(account.getPassword())) {
    				System.out.println("The username and password is already taken");
    				return;
    			}	
    		}
    		
    		if(!username.equals("")&&!password.equals("")) {
    			//Responsible for creating the local account.
    			if(input.equals("1")) {
    				//CREATION OF OBJECT AND ADDING TO THE LIST OF ACCOUNT
    				Account objAccount = new Account(this.accountCounter, username, password, false);
    				accountList.add(objAccount);
    				//TO GET AWARE OF ITS WHOLE
    				objAccount.setAccountManagement(this);   
    				this.accountCounter++;
    				System.out.println("Account was successfully created");
    			//Responsible for creating the admin account.
    			}else if(input.equals("2")) {
    				System.out.print("Enter the key to create the admin account: ");
    				int key = this.scan.nextInt();
    				this.scan.nextLine();
    				if(key == this.key){
    					Account objAccount = new Account(this.accountCounter, username, password, true);
    					accountList.add(objAccount);
    					objAccount.setAccountManagement(this);   
    					this.accountCounter++;
    					System.out.println("Account was successfully created");
    				}else
    					System.out.println("Invalid Registration!");
    			}else 
    				System.out.println("\nChoose at the given account type");
    		}
    	}
    }
    
    //To View the list of account that has been saved.
    public void ViewTheList(){
    	if(this.accountList.size()!=0) {
    		for(Account account:this.accountList)
    			System.out.println(account.GetAccountDetails());
    		System.out.println();
    	}else
    		System.out.println("List is empty");
        
    }
    
    //For changing access key for admin.
    public void UpdateOnTheList() {
    	while(true) {
    		System.out.println("\n[1]Change access key   [2]Edit account  [3]Back");
    		System.out.print("Enter option: ");
    		String input = this.scan.nextLine();
    		//FOR EDITING THE ACCESS KEY FOR CREATING AN ADMIN ACCOUNT
    		if(input.equals("1")) {
    			System.out.print("Enter current key: ");
    			int currentKey = (int)super.ValidateInputNumber(scan);
    			//ENTERED CURRECT KEY VERIFICATION
    			if(currentKey==0) {
    				this.scan.nextLine();
    				return;
    			}else {
    				if(currentKey==this.key) {
    					System.out.print("Enter new key: ");
    					int newKey = (int)super.ValidateInputNumber(scan);
    					//ENTERED NEW KEY VERIFICATION
    					if(currentKey==0) {
    						this.scan.nextLine();
    						return;
    					}else {
    						this.key = newKey;
    						this.scan.nextLine();
    						System.out.println("The key was successfully changed");
    					}
    				}else {
    					System.out.println("Incorrect entered key");
    					this.scan.nextLine();
    				}
    					
    			}
    		//For editing the selected account user name and password.
    		}else if(input.equals("2")) {
    			boolean isOnTheList = false;
    			System.out.print("Account ID: ");
    			int id=(int)super.ValidateInputNumber(this.scan);
    			for(Account account:this.accountList) {
    				if(account.getAccountId()==id) {
    					this.scan.nextLine();
    					isOnTheList = true;
    					while(true) {
    						System.out.println("[1] Edit username");
    						System.out.println("[2] Edit password");
    						System.out.println("[3] Back");
    						System.out.print("Enter option: ");
    						String input2=scan.nextLine();
    						if(input2.equals("1")) {
    							System.out.print("New username: ");
    							String newName=scan.nextLine();
    							account.setUsername(newName);	
    							System.out.println("The username was successfully changed");
    						}else if(input2.equals("2")) {
    							System.out.print("Enter current password: ");
    							String oldPass = scan.nextLine();
    							//VERIFICATION FOR EDITING AN ACCOUNT PASSWORD
    							if(oldPass.equals(account.getPassword())) {
    								System.out.print("Enter new password: ");
    								String newPass = scan.nextLine();
    								account.setPassword(newPass);
    								System.out.println("The password was successfully changed");
    							}else 
    								System.out.println("Incorrect current password!");
    						}else if(input2.equals("3")) 
    							return;
    						else 
    							System.out.println("Invalid input, please try again.");
    					}//END OF WHILE LOOP
    				}//END OF IF STATEMENT
    			}//END OF FOR LOOP
    			if(!isOnTheList) {
    				System.out.println("The entered account ID was not on the list");
    				this.scan.nextLine();
    			}
    				
    		}else if(input.equals("3"))
    			return;
    		else//END OF INPUT OPTION VALIDATION
    			System.out.println("Invalid input, please try again");
    	}//END OF WHILE LOOP
    }//END OF METHOD
    
    //Responsible for deleting a selected account.
	public void RemoveFromTheList() {
    	System.out.print("Account ID: ");
    	int id=(int)super.ValidateInputNumber(this.scan);
    	this.scan.nextLine();
    	boolean isOnTheList = false;
    	//TRAVERSING THROUGH THE LIST
    	for(Account account:this.accountList) {
    		//IF THE ENTERED ID WAS ON THE LIST
    		if(account.getAccountId()==id) {
    			isOnTheList = true;
    			this.accountList.remove(account);
    			System.out.println("The account was successfully removed");
    			return;
    		}
    	}
    	if(!isOnTheList)
    		System.out.println("The entered account ID was not on the list");
    }
}
