package finalsProject;

import java.util.List;
import java.util.Scanner;
public abstract class ManagementSystem{
	
	//ONLY USED IN INPUT VALIDATION, TO PREVENT FROM ENTERING INVALID ASCII CHARACTERS
	public double ValidateInputNumber(Scanner scan) {
		if(scan.hasNextDouble())			//IF THE SCANNER HAS DOUBLE DATA TYPE
			return scan.nextDouble();
		else if(scan.hasNextInt())			//IF THE SCANNER HAS INTEGER DATA TYPE
			return (double)scan.nextInt();
		else								//ELSE, IT IS LETTERS OR SPECIAL CHARACTER
			System.out.println("Invalid input, please try again.");
		return 0.0;
    }
	
	//ABSTRACT METHODS
	public abstract void AddToList();
    public abstract void ViewTheList();
    public abstract void UpdateOnTheList();
    public abstract void RemoveFromTheList();
}
