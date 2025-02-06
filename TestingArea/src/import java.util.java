import java.util.Scanner;

public class TestingArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N from the user
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        // Initialize an array to store the numbers
        int[] numbers = new int[n];

        // Read N integers and store them in the array
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        while (true) {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Sum");
            System.out.println("2. Average");
            System.out.println("3. Difference");
            System.out.println("4. Exit");

            // Get the user's choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Calculate and display the sum of the elements
                int total = 0;
                for (int num : numbers) {
                    total += num;
                }
                System.out.println("Sum of elements: " + total);
            } else if (choice == 2) {
                // Calculate and display the average of the elements
                int total = 0;
                for (int num : numbers) {
                    total += num;
                }
                double average = (double) total / n;
                System.out.println("Average of elements: " + average);
            } else if (choice == 3) {
                // Calculate and display the difference between max and min
                int max = numbers[0];
                int min = numbers[0];
                for (int num : numbers) {
                    if (num > max) {
                        max = num;
                    }
                    if (num < min) {
                        min = num;
                    }
                }
                int difference = max - min;
                System.out.println("Difference between highest and lowest: " + difference);
            } else if (choice == 4) {
                // Exit the program
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option (1-4).");
            }
        }

        // Close the scanner
        scanner.close();
    }
}