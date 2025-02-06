import java.util.Random;
import java.util.Scanner;

public class BingoGame {
	static Scanner scan=new Scanner(System.in);
	static String [][]arr=new String[6][7];
	static Random RNDM=new Random();
	
	public static void main(String[] args) {
		//STORING OF ELEMENT FOR VISUALIZATION
		for(int count=0; count<arr.length; count++) {
    		for(int count1=0; count1<arr[count].length; count1++) {
        		arr[count][count1]="0";
        	}
    	}
		
		System.out.println("[1] Play the game"+"\n[2] Exit the game");
		System.out.print("Action: ");
		String choice=scan.nextLine();
		if(choice.equals("1")) {
			StartPlaying();
		}else if(choice.equals("2")){
			System.err.println("Program has been terminated!");
			System.exit(0);
		}else {
			System.err.println("Invalid choice, please try again!");
			main(null);
		}
	}
	
	public static void StartPlaying() {
		while(true) {
			ShowTable();
			
			//PLAYER'S MOVE
			System.out.print("Choose a column to place, from 1 to 7: ");
			if(scan.hasNextInt()) {
				int chosenColumn=scan.nextInt();
				if(chosenColumn>0&&chosenColumn<8) {
					//PLACING OF PIECE  <COLUMN><IF_PLAYER>
					PlacePiece(chosenColumn-1, true);
					scan.nextLine();
				}else {
					System.err.println("Column out of bound, please try again!");
					scan.nextLine();
					StartPlaying();
				}
			}else {
				System.err.println("Invalid input, please try again!");
				scan.nextLine();
				StartPlaying();
			}
			//CHECK FOR LINE UP
			LineUpAnalyzation(true);
			//DISPLAY THE TABLE
			ComputersMove();
		}
	}
	
	public static void ComputersMove() {
		//COMPUTER'S MOVE
	    int digit = RNDM.nextInt(7)+1;
	    System.out.print("Computer's move at column: "+digit);
	    PlacePiece(digit-1, false);
	    LineUpAnalyzation(false);
	}
	
	public static void ShowTable() {
		System.out.println("\n\n--------------------------------");
		//DISPLAYING OF ELEMENTS
		for(int count=0; count<6; count++) {
			System.out.print("\t");
			for(int count1=0; count1<7; count1++) {
				System.out.print(arr[count][count1]+" ");
			}
			System.out.print("\n");
		}
		
		//CHECKS IF THE TABLE IS FULL
		int emptyColumn=0;
		for(int count=0; count<7; count++) {
			if(arr[0][count].equals("0")) {
				emptyColumn++;
			}
		}
		if(emptyColumn==0) {
			System.err.println("*****The game was DRAW!*****");
			main(null);
		}
	}

	public static void PlacePiece(int columnIndex, boolean ifPlayer) {
		//CHECKS IF THE SELECTED COLUMN IS FULL
		if(arr[0][columnIndex]!="0") {
			if(ifPlayer) {
				System.err.println("The column is full, please try again!");
				StartPlaying();
			}else {
				System.out.print(" = invalid\n");
				ComputersMove();
			}
		}
		
		//PLACING THE PIECE
		int rowIndex=5;
		if(arr[rowIndex][columnIndex]=="0") {
			arr[rowIndex][columnIndex]=ifPlayer?"+":"-";
		}else {
			while(true) {
				rowIndex--;
				//PLACING OF PIECE IF THERE'S ALREADY A PLACED PIECE
				if(arr[rowIndex][columnIndex]=="0") {
					arr[rowIndex][columnIndex]=ifPlayer?"+":"-";
					break;
				}else if(rowIndex==0)
					break;
			}
		}
	}
	
	public static void LineUpAnalyzation(boolean forPlayer) {
		int verticalOccurrence=0;
		int horizontalOccurrence=0;
		int diagonalOccurrence=0;
		int tempCount=0;
		int tempCount1=0;
		int tempCount2=6;
		int tempCount3=0;

    	//VERTICAL CHECKING
    	for(int count=0; count<7; count++) {
    		for(int count1=5; count1>=0; count1--) {
    			if(verticalOccurrence==4) {
    				System.out.println("\n***vertical line up");
    			}
    			verticalOccurrence = OccurenceValidation(count1, count, verticalOccurrence, forPlayer);
        	}
    	}
    	//HORIZONTAL CHECKING
    	for(int count=5; count>=0; count--) {
    		for(int count1=0; count1<7; count1++) {
    			if(horizontalOccurrence==4) {
    				System.out.println("\n***horizontal line up");
    			}
    			horizontalOccurrence = OccurenceValidation(count, count1, horizontalOccurrence, forPlayer);
    		}
    	}
		
		//DIAGONAL ANALYZATION
		//45 DEGREES 1ST HALF DIAGONAL CHECKING, top
    	for(int count=0; count<6; count++) {
    		tempCount=count;
    		for(int count1=0; count1<count+1; count1++) {
    			if(diagonalOccurrence==4) {
    				System.out.println("\n***diagonal line up-1");
    			}
    			diagonalOccurrence = OccurenceValidation(tempCount, count1, diagonalOccurrence, forPlayer);
    			tempCount--;
        	}
    		diagonalOccurrence=0;
    	}
    	//45 DEGREES 2ND HALF DIAGONAL CHECKING, bottom
    	for(int count=-1; count<5; count++) {
    		tempCount1=count+2;
    		for(int count1=5; count1>count; count1--) {
    			if(diagonalOccurrence==4) {
    				System.out.println("\n***diagonal line up-2");
    			}
    			diagonalOccurrence = OccurenceValidation(count1, tempCount1, diagonalOccurrence, forPlayer);
    			tempCount1++;
        	}
    		diagonalOccurrence=0;
    	}
    	//145 DEGREES 1ST HALF DIAGONAL CHECKING, top
    	for(int count=5; count>=0; count--) {
    		for(int count1=count; count1>=0; count1--) {
    			if(diagonalOccurrence==4) {
    				System.out.println("\n***diagonal line up-3");
    			}
    			diagonalOccurrence = OccurenceValidation(count1, tempCount2, diagonalOccurrence, forPlayer);
    			tempCount2--;
    		}
    		diagonalOccurrence=0;
    		tempCount2=6;
    	}
    	//145 DEGREES 2ND HALF DIAGONAL CHECKING, bottom
    	for(int count=6; count>=0; count--) {
    		tempCount3=5-count;
    		for(int count1=5; count1>=count; count1--) {
    			if(diagonalOccurrence==4) {
    				System.out.println("\n***diagonal line up-4");
    			}
    			diagonalOccurrence = OccurenceValidation(count1, tempCount3, diagonalOccurrence, forPlayer);
    			tempCount3--;
        	}
    		diagonalOccurrence=0;
    	}
	}
	
	public static int OccurenceValidation(int count1, int count2, int occurenceCount, boolean forPlayer) {
		//LINE UP WITH 4 PIECES VALIDATION
		if(occurenceCount==4) {
			ShowTable();
    		System.out.println(forPlayer?"***Player Wins!***":"***Computer Wins!***");
    		main(null);
    	}
		
		//INCREMENTATION OF OCCURRENCE
		if(arr[count1][count2].equals(forPlayer?"+":"-")) 
    		return occurenceCount+1;
		else 
    		return occurenceCount=0;
	}
}
