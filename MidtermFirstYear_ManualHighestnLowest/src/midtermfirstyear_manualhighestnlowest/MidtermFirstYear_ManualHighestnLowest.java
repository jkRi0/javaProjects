package midtermfirstyear_manualhighestnlowest;
import java.util.Scanner;
public class MidtermFirstYear_ManualHighestnLowest {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        for(;;){        //for infinite loop
            double NUM1,lowest=0,highest=0,extra;  //preperation
            System.out.println("Enter your five numbers: ");
            if(key.hasNextInt()){           //if the input is integer
                NUM1=key.nextDouble();      //input the very first number
                for(int a=0; a<4; a++){
                    double NUM2=key.nextDouble();  /*input the second number
                                                    and so on*/
                    if(NUM2>=highest){      //for highest
                        highest=NUM2;       //the highest was stored
                        if(NUM1>=highest){//if the very 1st number is the highest
                            highest=NUM1;   
                        }
                    } 
                    else if(NUM1<=NUM2){    //compare which are lowest
                        lowest=NUM1;        //store the lowest in new variable
                        NUM1=lowest;        //place black
                    }
                    else if(NUM1>=NUM2){    //if the second number is lowest
                        extra=NUM2;         //temporary variable
                        NUM2=NUM1;          //1st into 2nd
                        NUM1=extra;         //2nd into 1st
                        lowest=NUM1;        //the 2nd is now the lowest
                        NUM1=lowest;        //place back
                    }
                }
                System.out.println("\nThe lowest number are: "+lowest);
                System.out.println("The highest number are: "+highest);
                break;
            }
            else if(key.hasNext()){         //if the input is not an integer
                String again;               //the input will be stored here
                again=key.next();           //as an unused input
            }
        }
    }
}
