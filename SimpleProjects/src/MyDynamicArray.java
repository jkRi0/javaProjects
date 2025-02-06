import java.util.Arrays;
import java.util.Scanner;

public class MyDynamicArray {
	static Scanner scan = new Scanner(System.in);
	static String []arr = new String[1];
	static String []temp = new String[0];
	static String []temp1 = new String[1];
	static int arrSize = 1;
	
	//*********************************Dynamic Array?****************************
	//NEW ARRAY WITH INCREMENTED SIZE
	public static void NewArrSize() {
		arr = new String[arrSize];
		arrSize++;
	}
	
	//STORING NEW ELEMENTS TO A NEW ARRAY WITH INCREMENTED SIZE
	public static void CreateNewArray(String userInput) {
		for(int count = 0; count<arr.length; count++) {
			if(count<temp.length) {
				arr[count] = temp[count];
			}else {
				arr[count] = userInput;
			}
		}
	}
	
	//TRANSFER ARRAY ELEMENTS TO TEMPORARY ARRAY
	public static void TemporaryTransfer() {
		temp = arr;
	}
	//***************************************************************************
	
	public static void InsertValueToIndex(String value, int index) {
		temp1 = new String[arr.length-index];
		//GET THE ELEMENTS FROM SELECTED INDEX AND THE REST
		for(int count=0; count<arr.length; count++) {
			if(count >= index) {
				temp1[count-index] = arr[count];
			}
		}
		
		TemporaryTransfer();
		arr = new String[temp.length+1];
		
		//INSERTING VALUE TO THE INCREMENTED SIZE ARRAY
		for(int count=0; count<arr.length; count++) {
			if(count == index) {
				arr[count] = value;
			}else if(count > index) {
				arr[count] = temp1[count-(index+1)];
			}else {
				arr[count] = temp[count];
			}
		}
		Menu();
	}
	
	public static void InsertValueToLast(String value) {
		TemporaryTransfer();
		arr = new String[temp.length+1];
		for(int count=0; count<arr.length; count++) {
			if(count == arr.length-1) {
				arr[count] = value;
			}else {
				arr[count] = temp[count];
			}
		}
		Menu();
	}
	
	public static void RemoveByValue(String value) {
		TemporaryTransfer();
		int index=0;
		
		//GET THE INDEX OF VALUE
		for(int count=0; count<arr.length; count++) {
			if(arr[count].equals(value)) {
				index = count;
			}
		}
		arr = new String[temp.length-1];
		
		//GET THE ELEMENTS FROM VALUE AND THE REST
		temp1 = new String[(temp.length-index)-1];
		for(int count=0; count<temp.length; count++) {
			if(count > index) {
				temp1[(count-index)-1] = temp[count];
			}
		}
		
		//TRANSFERING ELEMENTS TO A NEW DECREMENTED SIZE ARRAY
		for(int count=0; count<arr.length; count++) {
			if(count >= index) {
				arr[count] = temp1[count-index];
			}else {
				arr[count] = temp[count];
			}
		}
		Menu();
	}
	
	public static void RemoveByIndex(int index) {
		
	}
	
	public static void ChooseAgain() {
		System.out.println("choose again!");
	}
	
	//ENTRY POINT
	public static void main(String[]args) {
		/* REQUIREMENTS:
		enter infinite times
		input 3 zero's to stop
		add to array, beside an specific index or at the last index
		remove element on array, value or specific index
		*/
		while(true) {
			System.out.print("Enter value: ");
			String input = scan.nextLine();
			//SENTINEL
			if(input.equals("000")) {
				break;
			}
			
			NewArrSize();
			CreateNewArray(input);
			TemporaryTransfer();
		}
		Menu();
	}
	
	public static void Menu() {
		scan = new Scanner(System.in);
		System.out.println(Arrays.toString(arr));
		System.out.println("\n(1) add another element\n(2) remove element\n(3) exit program");
		System.out.print("Your choice: ");
		String input = scan.nextLine();
		if(input.equals("1")) {
			Menu1();
		}else if(input.equals("2")) {
			Menu2();
		}else if(input.equals("3")) {
			System.exit(0);
		}else {
			ChooseAgain();
			Menu();
		}
	}
	
	public static void Menu1() {
		System.out.println("\n(1) insert to index\n(2) insert to last\n(3) exit program");
		System.out.print("Your choice: ");
		String input = scan.nextLine();
		if(input.equals("1")) {
			System.out.print("Enter Value: ");
			String input1 = scan.nextLine();
			System.out.print("Insert to index: ");
			int input2 = scan.nextInt();
			if(input2 > 0 && input2 < arr.length) {
				InsertValueToIndex(input1, input2);
			}else {
				ChooseAgain();
				Menu1();
			}
		}else if(input.equals("2")) {
			System.out.print("Enter Value: ");
			String input1 = scan.nextLine();
			InsertValueToLast(input1);
		}else if(input.equals("3")) {
			System.exit(0);
		}else {
			ChooseAgain();
			Menu1();
		}
	}
	
	public static void Menu2() {
		System.out.println("\n(1) specific value\n(2) specific index\n(3) exit program");
		System.out.print("Your choice: ");
		String input = scan.nextLine();
		if(input.equals("1")) {
			System.out.print("Enter the value to be remove: ");
			String input1 = scan.nextLine();
			RemoveByValue(input1);
		}else if(input.equals("2")) {
			System.out.print("Enter the index of element to be remove: ");
			int input2 = scan.nextInt();
			RemoveByIndex(input2);
		}else if(input.equals("3")) {
			System.exit(0);
		}else {
			ChooseAgain();
			Menu2();
		}
	}
}
