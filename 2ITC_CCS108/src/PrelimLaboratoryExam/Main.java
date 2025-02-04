package PrelimLaboratoryExam;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// List to Save the Accounts
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.println("BDO");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a new account with name only");
            System.out.println("2. Create a new account with name and initial balance");
            System.out.println("3. Deposit to an account");
            System.out.println("4. Withdraw from an account");
            System.out.println("5. View account details");
            System.out.println("6. Exit");

            System.out.print("Please select a menu item (1-6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder's name: ");
                    scanner.nextLine();  // Consume the newline character
                    String name = scanner.nextLine();
                    BankAccount account1 = new BankAccount(name);
                    accounts.add(account1);
                    System.out.println("Account created successfully.");
                    System.out.println(account1);
                    break;
                case 2:
                    System.out.print("Enter account holder's name: ");
                    scanner.nextLine();  
                    String name2 = scanner.nextLine();
                    System.out.print("Enter initial balance: $");
                    double initialBalance = scanner.nextDouble();
                    BankAccount account2 = new BankAccount(name2, initialBalance);
                    accounts.add(account2);
                    System.out.println("Account created successfully.");
                    System.out.println(account2);
                    break;
                case 3:
                    // Deposit
                    System.out.print("Enter account number to deposit to: ");
                    int accountNumber3 = scanner.nextInt();
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    // Find the account and deposit the amount
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == accountNumber3) {
                            account.deposit(depositAmount);
                            System.out.println("Deposit successful.");
                            System.out.println(account);
                            break;
                        }
                    }
                    break;
                case 4:
                    // Withdraw
                    System.out.print("Enter account number to withdraw from: ");
                    int accountNumber4 = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    // Find the account and withdraw the amount
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == accountNumber4) {
                            account.withdraw(withdrawalAmount);
                            System.out.println("Withdrawal successful.");
                            System.out.println(account);
                            break;
                        }
                    }
                    break;
                case 5:
                    // View account details
                    System.out.print("Enter account number to view details: ");
                    int accountNumber5 = scanner.nextInt();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == accountNumber5) {
                            System.out.println(account);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid menu item (1-6).");
            }
        }
    }
}