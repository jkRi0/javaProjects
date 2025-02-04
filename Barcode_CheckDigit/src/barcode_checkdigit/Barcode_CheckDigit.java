package barcode_checkdigit;
import java.util.Scanner;
public class Barcode_CheckDigit {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        System.out.println("(1)check ISBN           13 all digits");
        System.out.println("(2)check UPC            12 all digits");
        System.out.println("(3)check Credit Card    16 all digits");
        System.out.print("Enter: ");
        String a=key.next();
        int sumAll=0, input=0, lastDigit=0;
        switch(a){
            case "1":
                for(int b=1;b<=12;b++){
                    if(b%2==0){
                        System.out.print("number"+b+": ");
                        input=key.nextInt();
                        sumAll=sumAll+(input*3);
                    }
                    else if(b%2==1){
                        System.out.print("number"+b+": ");
                        input=key.nextInt();
                        sumAll=sumAll+input;
                    }
                    
                }
                System.out.print("check digit: ");
                input=key.nextInt();
                lastDigit=input;
                int digit=10-(sumAll%10);
                if(digit==lastDigit){
                    System.out.println("\noriginal");
                }
                else if(digit==10){
                    System.out.println("\noriginal");
                }
                else{
                    System.out.println("\nfake");
                }
                System.out.println("digit: "+digit);
                break;
            case "2":
                for(int b=1;b<=11;b++){
                    if(b%2==0){
                        System.out.print("number"+b+": ");
                        input=key.nextInt();
                        sumAll=sumAll+input;
                    }
                    else if(b%2==1){
                        System.out.print("number"+b+": ");
                        input=key.nextInt();
                        sumAll=sumAll+(input*3);
                    }
                    
                }
                System.out.print("check digit: ");
                input=key.nextInt();
                lastDigit=input;
                digit=10-(sumAll%10);
                if(digit==lastDigit){
                    System.out.println("\noriginal");
                }
                else if(digit==10){
                    System.out.println("\noriginal");
                }
                else{
                    System.out.println("\nfake");
                }
                System.out.println("digit: "+digit);
                break;
            case "3":
                for(int b=1;b<=16;b++){
                    if(b%2==0){
                        System.out.print("number"+b+": ");
                        input=key.nextInt();
                        sumAll=sumAll+input;
                    }
                    else if(b%2==1){
                        System.out.print("number"+b+": ");
                        input=key.nextInt();
                        input=input*2;
                        if(input>=10){
                            String inputString=Integer.toString(input); //int to string
                            //first digit
                            String inputString1=Character.toString(inputString.charAt(0));  //char to string
                            int inputInt1=Integer.parseInt(inputString1);   //string to int
                            //second digit
                            String inputString2=Character.toString(inputString.charAt(1));  //char to string
                            int inputInt2=Integer.parseInt(inputString2);   //string to int
                            int inputInt3=inputInt1+inputInt2;
                            sumAll=sumAll+inputInt3;
                        }
                        else{
                            sumAll=sumAll+input;
                        }
                    }
                    /*

Not working!
but almost

*/
                }
                System.out.println("\nsum result: "+sumAll);
                sumAll=sumAll%10;
                System.out.println("mod 10 result: "+sumAll);
                /*if(sumAll==0){
                    System.out.println("original");
                }
                else{
                    System.out.println("fake");
                }*/
                break;
            default:
                System.out.println("\nEhhh?");
        }
    }
}
