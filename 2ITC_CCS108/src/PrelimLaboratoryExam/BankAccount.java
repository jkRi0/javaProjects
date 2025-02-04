package PrelimLaboratoryExam;

class BankAccount {
   	 	// Instance variable
	    private int accountNumber;
	    private String accountHolder;
	    private double balance;

	    //Static variable
	    private static int nextAccountNumber = 1000;
	    
	    // Constructor with name only
	    public BankAccount(String accountHolder) {
	        this.accountNumber = nextAccountNumber++;
	        this.accountHolder = accountHolder;
	        this.balance = 0.0;	 
	    }
	    
	    // Constructor with name and initial balance
	    public BankAccount(String accountHolder, double initialBalance) {
	        this.accountNumber = nextAccountNumber++;
	        this.accountHolder = accountHolder;
	        this.balance = initialBalance;
	    }
	    
	    // Getters
	    public int getAccountNumber() {
	        return accountNumber;
	    }

	    // Deposit method
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposit of $" + amount + " successful.");
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    // Withdraw method
	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal of $" + amount + " successful.");
	        } else {
	            System.out.println("Invalid withdrawal amount or insufficient funds.");
	        }
	    }

	    // toString method
	    @Override
	    public String toString() {
	        return "Account Number: " + accountNumber +
	                "\nAccount Holder: " + accountHolder +
	                "\nBalance: $" + balance;
		}	    
	}

