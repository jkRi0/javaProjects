package MidtermLaboratory_ArrayImplementation;
/*

Rioveros, Justine Ken D.
Sta. Ana, Juliana Louise M.
November 16, 2023
2IT-C

*/

import java.util.Scanner;

public class StackMenu {
    private Stack stack;
    private Scanner scanner = new Scanner(System.in);

    public StackMenu(int size) {
        stack = new Stack(size);
    }

    public void MainMenu() {
        String input = "";
        do {
            System.out.println("\n[I,i] - Input an Element (Push Operation)");
            System.out.println("[V,v] - View the List");
            System.out.println("[D,d] - Delete an Element (Pop Operation)");
            System.out.println("[R,r] - Retrieve an Element (Peek Operation)");
            System.out.println("[X,x] - Exit on the Menu");
            System.out.print("Enter your operation: ");
            input = scanner.nextLine();
            switch (input) {
                case "I", "i":
                    System.out.print("Enter a number to push: ");
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        if (!stack.isFull()) {
                            stack.push(number);
                            System.out.println("\nThe number " + number + " was succesfully pushed.");
                            scanner.nextLine();
                        } else {
                            System.out.println("\nThe stack is full.");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("\nInvalid input, please try again!");
                        MainMenu();
                    }
                    break;
                case "V", "v":
                    if (!stack.isEmpty()) {
                        stack.printStack();
                    } else {
                        System.out.println("\nThe stack is empty.");
                    }
                    break;
                case "D", "d":
                    if (!stack.isEmpty()) {
                        System.out.println("\nThe number " + stack.peek() + " was successfully popped");
                        stack.pop();
                    } else {
                        System.out.println("\nThe stack is empty.");
                    }
                    break;
                case "R", "r":
                    if (!stack.isEmpty()) {
                        System.out.println("\nThe top number is: " + stack.peek());
                    } else {
                        System.out.println("\nThe stack is empty.");
                    }

                    break;
                default:
                    System.out.println(!input.equalsIgnoreCase("x") ? "\nInvalid input, please try again!"
                            : "The program terminated...");
            }// END OF SWITCH
        } while (!input.equalsIgnoreCase("X"));
    }
}
