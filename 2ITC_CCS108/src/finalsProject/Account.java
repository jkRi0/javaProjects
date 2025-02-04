package finalsProject;

//This class account is use for creating an accounts for the accountManagement.
public class Account {
	//Class fields for the account. 
	private int accountId;
	private String username;
	private String password;
	private boolean isAdmin;
	private AccountManagement accountManagement;
  
	//Constructor for Local account as well as the admin account.
	public Account(int id, String username, String password, boolean isAdmin){
		this.accountId = id;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	//Getter and setters method for account.
	public String getUsername() {
		return this.username;
	}
  
	public String getPassword() {
		return this.password;
	}
  
	public boolean getIsAdmin(){
		return this.isAdmin;
	}

	public int getAccountId(){
		return this.accountId;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
  
	//To be aware of the account management.
	public AccountManagement getAccountManagement(){
		return this.accountManagement;
	}
	
	public void setAccountManagement(AccountManagement accountManagement){
		this.accountManagement = accountManagement;
	}
	
	//For printing the account details.
	public String GetAccountDetails(){
		return "\nACCOUNT ID: " + this.accountId + 
            "\nUSERNAME: " + this.username +
            "\nADMIN: " + this.isAdmin;
	}
}
