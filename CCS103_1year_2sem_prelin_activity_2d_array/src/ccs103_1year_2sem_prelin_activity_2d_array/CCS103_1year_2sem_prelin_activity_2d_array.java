package ccs103_1year_2sem_prelin_activity_2d_array;
import java.util.Scanner;
public class CCS103_1year_2sem_prelin_activity_2d_array {
    //MAIN METHOD
    public static void main(String[] args) {
        Scanner toInput=new Scanner(System.in);
        System.out.println("Enter number of rows");
        //if its number
        if(toInput.hasNextInt()){
            int toRows=toInput.nextInt();
            System.out.println("Enter number of columns");
            //if its number
            if(toInput.hasNextInt()){
                int toColumn=toInput.nextInt();
                //INITIALIZING THE TWO 2D ARRAY
                double firstArray[][]=new double[toRows][toColumn];  
                double secondArray[][]=new double[toRows][toColumn];
                System.out.println("Enter first set of elements");
                /*
                COUNT1 FIRST LOOP - for first 2D Array
                COUNT1 SECOND LOOP - for second 2D Array
                COUNT1 THIRD LOOP - for getting the sum of two 2D Array
                COUNT2 - for Rows
                COUNT3 - for Columns
                */
                for(int count1=0; count1<3; count1++){
                    int count4=0;   //count4 are use for creating the sum matrix later
                    for(int count2=0; count2<toRows; count2++){
                        for(int count3=0; count3<firstArray[count2].length; count3++){
                            //Scanner for inside the loop to prevent the second warning loop
                            Scanner toInput2=new Scanner(System.in);         
                            count4++;
                        //FOR MESSAGE INDICATION
                            if(count1==1 && count2==0 && count3==0){
                                System.out.println("Enter second set of elements");
                            }
                            else if(count1==2 && count2==0 && count3==0){
                                System.out.println("The sum of two 2D Array:");
                            }
                        //START OF STORING AND PRINTING THE 2D ARRAY
                            if(count1<=1){   
                                if(toInput2.hasNextDouble() && count1==0){    
                                    firstArray[count2][count3]=toInput2.nextDouble();
                                }
                                else if(toInput2.hasNextDouble() && count1==1){
                                    secondArray[count2][count3]=toInput2.nextDouble();
                                }  
                                else{
                                    forError(); //call the method for error
                                }
                            }
                        //ADDING UP THE TWO 2D ARRAYS and print
                            else if(count1==2){
                                System.out.print((firstArray[count2][count3]+secondArray[count2][count3]));
                                
                                //use to next line the sum and create a matrix
                                System.out.print(count1==2 && count4==toRows? "\n":"   ");
                                if(count4==toRows){count4=0;} //to reset the count4
                            }
                        }
                    }
                }
            }
            else{//ERROR FOR INPUT COLUMN
                forError(); 
            }
        }
        else{//ERROR FOR INPUT ROWS
            forError();
        }
        System.exit(0); //TO FORCELY EXIT THE PROGRAM
    }
    //ERROR METHOD
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
        else{ System.exit(0); }
    }
}
