package ccs103_1year_2sem_prelim;
import java.util.Scanner;
public class CCS103_1year_2sem_prelim {
    public static void main(String[] args) {
        Scanner forInput=new Scanner(System.in);//scanner for new input
        int forLength=0;
        int abvAve=0;
        double sumAll=0;
        double forAve=0;
        System.out.print("Enter the numbers of items: ");
        if(forInput.hasNextInt()){          //if the input is a number
            forLength=forInput.nextInt();
            double numbers[]=new double[forLength];         //creating the array
            System.out.println("Enter "+forLength+" numbers:");
            for(int count1=0; count1<forLength; count1++){
                if(forInput.hasNextDouble()){                   //if the input is a number
                    numbers[count1]=forInput.nextDouble();      //storing numbers to array
                    sumAll=sumAll+numbers[count1];              //adding all the numbers
                }
                else{forError();}
                
                if(numbers[count1]>100){
                    System.out.println("Your input exceeds the limit with 100 or below.");
                }
            }
            forAve=sumAll/forLength;        //getting the average
            for(int count2=0; count2<forLength; count2++){   
                if(numbers[count2]>forAve){ //getting the above average
                    abvAve++;               //count the number above average
                }
            }
            System.out.println("\nAverage is "+forAve);
            System.out.println("Number of elements above the average is "+abvAve);
        }
        else{forError();}
        System.exit(0); //TO FORCELY EXIT THE PROGRAM
    }
    //METHOD FOR ERROR
    static void forError(){
        Scanner toError=new Scanner(System.in);
        System.out.println("Error! Number only, press(1) to try again or press(2) to stop");
        String decision=toError.nextLine();
        if(decision.equals("1")){
            main(null);     //to call the main method, and loop to the start
        }
        else if(decision.equals("2")){
            System.out.println("The Program Ended");
            System.exit(0);
        }
    }
}

/*
1st year, 2nd sem, prelim
CSS103_laboratory

*/



