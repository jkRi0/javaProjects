package finalsWeek14_CompositionLecture;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		int asd = scan.hasNextInt()? scan.nextInt():0;
		scan.nextLine();
		
		System.out.print(asd+" asdasdasd: ");
		String sdf=scan.nextLine(); 
		
		System.out.print(sdf+" asdasdasd: ");
		int dfg=scan.nextInt(); 
		
		System.out.print(dfg+" asdasdasd: ");
		String fgh=scan.nextLine(); 
		
		System.out.println("\n");
		
		//creating a new House object
		House houseObj1 = new House(1, "Calamba");
		//adding Room objects, in our example, 2 objects
		houseObj1.AddRoom("room",Integer.parseInt("2"),2);
		//printing the details of the house including its Room objects
		System.out.println(houseObj1.GetFullDetails());
		
		
	}

}
