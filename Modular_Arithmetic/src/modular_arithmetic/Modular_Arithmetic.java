package modular_arithmetic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Modular_Arithmetic {
    static void one(){
        Scanner key=new Scanner(System.in);
        int num=0,allSum=0;
        for(int a=1;a>0;a++){
            System.out.print("(s)stop, number: ");
            if(key.hasNextInt()){
                num=key.nextInt();                                              
                allSum=allSum+num;
            }
            else if(key.hasNext()){
                break;
            }
        }
        String theNum=Integer.toString(allSum);                         //int to string
        int theNumLen=theNum.length()-1;                                  //length of string
        String oneDigit=Character.toString(theNum.charAt(theNumLen));   //get the last digit of string
        int oneDigitInt=Integer.parseInt(oneDigit);                    //last digit string to int
        System.out.println("\nSum of all: "+allSum);
        System.out.println("unit digit: "+oneDigitInt);
        System.exit(0);
    }
    static void two(){
        Scanner key=new Scanner(System.in);
        System.out.println("\nCongruent or Not");
        System.out.println("example 21=29=37(mod8)");
        System.out.print("your numbers: ");
        String question=key.nextLine(),num=" ",numtrim=" ";
        int equals=0,forARR=0;
    //create how many equals
        for(int Count=0;Count<question.length();Count++){ 
            if(question.charAt(Count)=='='){
                equals=equals+1;                           
            }
        }
        String numString[]=new String[(equals+2)]; //number of equals+1 are numbers of partition
//*******************************************************************************************************START OF PARTITION
        for(int a=0; a<question.length();a++){
            if(question.charAt(a)=='='){
                forARR++;
                numString[(forARR-1)]=numtrim;
                num=" ";                            //reset the num storage
                continue;
            }
            else if(question.charAt(a)=='('){  //start for mod
                forARR++;
                numString[(forARR-1)]=numtrim;
                num=" ";                            //reset the num storage
                
            }
            else if(question.charAt(a)==')'){  //end for mod
                forARR++;
                numString[(forARR-1)]=numtrim;
                num=" ";                            //reset the num storage
                break;
            }
            num=num+question.charAt(a);     //store each character
            numtrim=num.trim();             //trim for extra space
        }
        System.out.println("\n"+Arrays.toString(numString));
//*********************************************************************************************************END OF PARTITION
//*********************************************************************************************************START OF COMPUTATION
        int lastDigit=numString.length-1;
        String lastWord="sample",modNum="";
        lastWord=numString[lastDigit];
        int lastWordLen=lastWord.length(),numAns=0,finalnum=0;
    //analyze the mod
        for(int Count3=0;Count3<=lastWord.length();Count3++){
            if(lastWord.charAt(Count3)=='d'){
                modNum=Character.toString(lastWord.charAt(Count3));
                break;
            }
        }
        int modNum1=lastWord.indexOf(modNum); //getting the number
        String modNum2=lastWord.substring(modNum1+1); //the number but string
        int Dnum=Integer.parseInt(modNum2);     //"The number"
        System.out.println("The mod: "+Dnum+"\n");
    //subtracting to see what number are divisible by mod
        for(int Count1=0;Count1<numString.length-1;Count1++){
            for(int Count2=0;Count2<numString.length-1;Count2++){
                int num1=Integer.parseInt(numString[Count1]);
                int num2=Integer.parseInt(numString[Count2]);
                numAns=num1-num2;
                if(numAns>0){
//*********************************************************************************COMPUTAION FOR CONGRUENT OR NOT
                    finalnum=finalnum+numAns;
//*********************************************************************************
                    int newnum=0;
                    if(numAns==Dnum){
                        System.out.println(Dnum+" equal to "+numAns);
                        break;
                    }
                //if answer greater then mod
                    else if(numAns<Dnum){
                        for(int c1=0;c1>=0;c1++){
                          //limitation
                            newnum=Dnum-numAns;
                            Dnum=newnum;
                            if(Dnum==numAns){
                                System.out.println(Dnum+" equal to "+numAns);
                                break;
                            }
                            else if(Dnum<numAns){
                                System.out.println(Dnum+" not equal "+numAns);
                                break;
                            }
                        }
                    }
                //if answer less than mod
                    else if(numAns>Dnum){
                        for(int c1=0;c1>=0;c1++){
                          //limitation
                            newnum=newnum+Dnum;
                            if(newnum==numAns){
                                System.out.println(newnum+" equal to "+numAns);
                                break;
                            }
                            else if(newnum>numAns){
                                System.out.println(newnum+" not equal "+numAns);
                                break;
                            }
                        }
                    }
                }
            }
        }
//*****************************************************CONTINUE OF COMPUTATION FOR CONGRUENT OR NOT
        int Dans=finalnum%Dnum;
        if(Dans==0){
            System.out.print("\nCongruent\n");
        }
        else{
            System.out.print("\nNOT Congruent\n");
        }
//******************************************************
        System.exit(0);
    }
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        System.out.println("(1)units digit");
        System.out.println("(2)congruent or not");
        System.out.println("(3)simple modulo's");
        System.out.print("Enter: ");
        int chosen=key.nextInt();
        if(chosen==1){one();}
        else if(chosen==2){two();}
        else if(chosen==3){System.out.println("");}
        else{System.out.println("Ehhhh?");}
        System.out.print("dividend: ");
        double dividend=key.nextInt();
        System.out.print("divisor: ");
        double divisor=key.nextInt();
        int c=0;
        //for negative dividend
        if(dividend<0){
            System.out.print("\nSequence: 0 ");
            for(int a=0;a>dividend;a--){
                int divisorInt = (int) divisor;
                for(int b=divisorInt-1;b>=0;b--){
                    if(c==(dividend+1)){
                        break;
                    }
                    System.out.print(b+" ");
                    c--;
                }
            }
            System.out.println("\nmodulo: "+(dividend%divisor));
            System.out.print(dividend+" congruents "+(dividend%(divisor))+"(mod "+divisor+")");
        }
        //for negative divisor
        else if(divisor<0){
            System.out.print("\nSequence: 0 ");
            for(int a=0;a<dividend;a++){
                int divisorInt = (int) divisor;
                for(int b=divisorInt+1; b<=0; b++){
                    if(c==(dividend)){
                        break;
                    }
                    System.out.print(b+" ");
                    c++;
                }
            }
            double r=dividend%divisor;
            System.out.println("\nmodulo: "+(r*(-1)));
            System.out.print(dividend+" congruents "+(dividend%(divisor))+"(mod "+divisor+")");
        }
        //if all postive
        else{
            System.out.print("\nSequence: ");
            for(int a=0;a<dividend;a++){
                for(int b=0;b<divisor;b++){
                    if(c==(dividend+1)){
                        break;
                    }
                    c++;
                    System.out.print(b+" ");
                }
            }
            System.out.println("\nmodulo: "+(dividend%(divisor)));
            System.out.print(dividend+" congruents "+(dividend%(divisor))+"(mod "+divisor+")");
        }
    }
}
