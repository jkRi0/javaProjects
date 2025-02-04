package pkg1sty_1sts_midterm_rioveros;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        System.out.println("1: Floyd Triangle");
        System.out.println("2: Odd Numbers");
        System.out.println("3: Random Number");
        System.out.println("4: Quit");
        System.out.print("Choose One: ");
        int chosen=key.nextInt();
        switch(chosen){
            case 1: //floyd triangle
                System.out.print("Input number of rows : ");
                int count=key.nextInt(), Fcounting=1;
                for(int Fcount=0; Fcount<count; Fcount++){      //for columns
                    for(int Scount=0; Scount<Fcount; Scount++){ //for rows
                        System.out.print(Fcounting+" ");        
                        Fcounting++;    
                    }   //printing the increasing value with columns and rows
                    System.out.println(Fcounting+" ");
                    Fcounting++;
                }break;
                
            case 2: //odd numbers
                System.out.print("Input number of terms is: ");
                int termNums=key.nextInt(),Scounting=1;
                System.out.println("\nThe odd numbers are :");
                for(int Fcount=0; 1>0; Fcount++){
                    if(Fcount%2==1){ //when the count has remainder 1, then its the output
                        Scounting++; //count of every possible output
                        System.out.println(Fcount); //print the possible outputs
                        if(Scounting==termNums+1){ 
                            //if the possible output count reach the user terms input
                            break;
                        }
                    }
                }break;
                
            case 3: //random numbers
                System.out.println("I have a number between 1 to 5");
                int theNum = 1+(int)(Math.random()*5);  //initialize the random numbers
                for(int Fcount=1; Fcount<=3; Fcount++){ //limiting the tries
                    System.out.print("Guess the number: ");
                    int guess=key.nextInt();
                    if(guess==theNum){    //if the number was guessed
                        System.out.print("You guessed it!");
                        break;
                    }
                    else{   //if the number was wrong
                        System.out.println("That's wrong.\n"+"Tries "+Fcount);
                    }
                }
                System.out.print("\nProgram ended.");
                break;
            case 4: //quit message
                System.out.println("THANK YOU!!");
                break;
            default://wrong input message
                System.out.println("Invalid choice!!! Please make a valid choice.");
        }
    }
}
