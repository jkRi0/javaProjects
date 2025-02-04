package ccs103_project_cardshuffle;
import java.util.Scanner;
import java.util.Random;
public class CCS103_Project_CardShuffle {
    public static void main(String[] args) {
        //ARRAYS INITIALIZATION
        int forNumbers[]=new int[52];
        String forSuit[]={"Spades","Hearts","Diamonds","Clubs"};
        String forRank[]={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        String allCards[][]=new String[52][3];
        int count1=0;
        int count2=0;
        //MERGING THE ARRAYS FOR NUMBER, SUITS, AND RANK INTO ONE 2D ARRAY
        for(int a=0; a<52; a++){
            forNumbers[a]=a;        //CREATING VALUES FOR NUMBERS OF CARD
            for(int b=0; b<3; b++){
                String charNum=Integer.toString(forNumbers[a]); //NUMBERS OF CARD INTEGER TO STRING
                allCards[a][b]=charNum; //NUMBER OF CARD FOR FIRST COLUMN
                if(b==1){               //RANK OF CARD FOR SECOND COLUMN
                    allCards[a][b]=forRank[count1];
                }
                else if (b==2){         //SUIT OF CARD FOR THIRD COLUMN
                    allCards[a][b]=forSuit[count2];
                }
            }
            count1++;       //INCREMENTING COUNT1 FOR RANKS UNTIL VALUE OF 13, THEN RESET
            if(count1==13){
                count1=0;   //RESET THE COUNT1
                count2++;   //INCREMENTING COUNT2 FOR SUITS EVERY VALUE OF 13.
            }
        }
        //TO PRINT THE 4 RANDOM CARDS INSIDE THE 2D ARRAY
        int b=4,secondStorage=-1;
        for(int a=0; a<b; a++){
            //CREATING RANDOM NUMBER FOR INDEX OF ROWS
            Random RNDM=new Random();
            int digit=RNDM.nextInt(52);
            if(a==4){
                break;
            }
            
            if(secondStorage!=digit){
                System.out.println("Card number "+allCards[digit][0]+": "
                        +allCards[digit][1]+" of "+allCards[digit][2]);
            }
            
            secondStorage = digit;
            b++;
            
        }
        System.out.println("");
        
        
        
        
        //********************************OTHER METHOD
        int[] deck = new int[52];
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "Jack", "Queen", "King"};
        
        // Initialize cards
        for (int i = 0; i < deck.length; i++){
            deck[i] = i;//store the index of the initialize card
        }
        
        // Shuffle the cards
        for (int i = 0; i < deck.length; i++) {
            // Generate an index randomly
            int random = (int)(Math.random() * deck.length);
            
            // to prevent the same cards
            int temporary = deck[i];//switch the value in the deck[index] to int temporary
            deck[i] = deck[random]; //switch the value inside the deck[index] to deck[i]
            deck[random] = temporary;//switch the value inside the temporary to deck[index]
        }
        
        // Display the first four cards
        for (int i = 0; i < 4; i++) {
            String suit = suits[deck[i] / 13];//divide the value stored in deck[i] by 13
            String rank = ranks[deck[i] % 13];//get the reminder of the deck[i] by deviding it by 13
            System.out.println("Card number " + deck[i] + ": " 
            + rank + " of " + suit);//display the suit and rank result
        }
        
        // User decision
        Scanner forDecision=new Scanner(System.in);
            // Print the condition 
        System.out.println("\nPress(1) to run again or press(2) to end the program");
        String decision=forDecision.nextLine();
         switch (decision) {
             case "1":
                 main(null);     //to call the main method, and loop to the start
                 break;//break the line 
             case "2":
                 System.out.println("The Program Ended");
                 System.exit(0);//FORCE EXIT
             default:
                 System.exit(0);//FORCE EXIT
         }
    }
}

//NOT WORKING PROPERLY