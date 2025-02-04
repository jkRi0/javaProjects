package method_practice;
import java.util.*;
public class Method_practice {
    public static void main(String[] args) {
        double a=0,b=0,c=0;
        Scanner key=new Scanner(System.in);
        System.out.print("Choose an operator +, -, *, or /: ");
        String op=key.next();
        switch (op){
            case "+":
                    ahh("Enter first number: ");
                    if(key.hasNextDouble()){
                        a=key.nextDouble(); 
                        ahh("Enter second number: ");
                        if(key.hasNextDouble()){
                            b=key.nextDouble();
                            double plus=sum(a, b);
                            ahh(a+" + "+b+" = "+plus);
                        }else{wrong();}
                    }else{wrong();}break;
            case "-":
                    ahh("Enter first number: ");
                    if(key.hasNextDouble()){
                        a=key.nextDouble();
                        ahh("Enter second number: ");
                        if(key.hasNextDouble()){
                            b=key.nextDouble();
                            ahh(a+" - "+b+" = "+(a-b));
                        }else{wrong();}
                    }else{wrong();}break;
            case "*":
                    ahh("Enter first number: ");
                    if(key.hasNextDouble()){
                        a=key.nextDouble();
                        ahh("Enter second number: ");
                        if(key.hasNextDouble()){
                            b=key.nextDouble();
                            ahh(a+" * "+b+" = "+(a*b));
                        }else{wrong();}
                    }else{wrong();}break;
            case "/":
                    ahh("Enter first number: ");
                    if(key.hasNextDouble()){
                        a=key.nextDouble();
                        ahh("Enter second number: ");
                        if(key.hasNextDouble()){
                            b=key.nextDouble();
                            if(b==0){
                                ahh("undefined");
                            }
                            else{
                                ahh(a+" / "+b+" = "+(a/b));
                            }
                        }else{wrong();}
                    }else wrong();break;
            default:
                    wrong();break;
        }
    }
    static void ahh(String text)    //the value of "text" is the text above that put in the method name "ahh".
    {                               
        System.out.print(text);     //then the "text", will print.
    }
    
    static double sum(double a, double b)   //the value "a" and "b" is the number of what you input.
    {
        return a+b; //that two value will add, then will return to main method to use the sum.
    }
    
    static void wrong() // all the invalid input will go here.
    {
        ahh("Invalid operator");
    }
}