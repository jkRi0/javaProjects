package cssweek_computerprogramming_competition;
import java.util.Scanner;
import java.util.Arrays;
public class CSSweek_ComputerProgramming_Competition {
    public static void main(String[] args) {
        //PROBLEM
        /*there are one set/collection of numbers,
        the set are divided in half, then the size of possible sets are the half of main set/collection,
        the possible sets must have atleast 2 similar average of subset/possible set,
        to become true in its out put.
        */
        
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the amount of cards: ");
        int arrSize=input.nextInt();
        //used for grouping into two
        int halfSize=0;
        //if odd value
        if(arrSize%2==1){
            System.out.println("The amount of cards are odd and can not be seperated into half.");
            System.exit(0);
        }
        else{
            halfSize=arrSize/2;
        }
        
        //creating the array
        System.out.println("Enter your cards power levels:");
        int powers[]=new int[arrSize];
        for(int count1=0; count1<arrSize; count1++){
            powers[count1]=input.nextInt();
        }
        
        System.out.println("\nSet = "+Arrays.toString(powers));
        
        /*
        for(int count1=0; count1<arrSize; count1++){
            if(count1<halfSize){
                arr1[count1]=powers[count1];
            }
            else if(count1>=halfSize){
                arr2[count1-halfSize]=powers[count1];
            }
        }
        
        //every possible set and their average
        double sumAll=0;
        for(int count1=0; count1<arrSize; count1++){
            for(int count2=count1; count2<arrSize; count2++){
                if(powers[count1]!=powers[count2]){
                    sumAll=powers[count1]+powers[count2];
                    System.out.println(powers[count1]+" ");
                }
            }
            double ave=sumAll/arrSize;
            System.out.println(ave);
        }*/ //TIMES UP
        
        
        //creating the average of each array
        //half of an array only, not every possible set
        int arr1[]=new int[halfSize];
        int arr2[]=new int[halfSize];
        int sumAll=0, sumAll2=0;
        for(int count1=0; count1<arrSize; count1++){
            if(count1<halfSize){
                sumAll+=arr1[count1];
            }
            else{
                sumAll2+=arr2[count1-halfSize];
            }
        }
        int ave1=sumAll/halfSize;
        int ave2=sumAll2/halfSize;
        System.out.println(ave1);
        System.out.println(ave2);
        if(ave1==ave2){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
