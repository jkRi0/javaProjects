package MidtermLaboratory_ArrayImplementation;
/*

Rioveros, Justine Ken D.
Sta. Ana, Juliana Louise M.
November 16, 2023
2IT-C

*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int size = 0;
        if (scan.hasNextInt()) {
            size = scan.nextInt();
            System.out.println("\nThe array with size " + size + " has been created.");
        } else {
            System.out.println("\nInvalid input, please try again!");
            main(null);
        }

        // SET THE ARRAY SIZE
        StackMenu stackMenu = new StackMenu(size);
        stackMenu.MainMenu();
    }
}

