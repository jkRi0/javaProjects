package fibonacci123;
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        // FOR LOOP FIBONACCI
        int lagay, x=0, y=1, z=0;
        System.out.print("enter a number: ");
        lagay=key.nextInt();
        for (int i=0; i<lagay; i++){
            System.out.print(y+" ");
            z = x + y;
            x = y;
            y = z;
        }
        
        // WHILE LOOP FIBONACCI
        int a=0, b=1, c, i=2, input;
        System.out.print("\nenter a number: ");
        input=key.nextInt();
        System.out.print(b);
        while(i<=input) {
            c=a+b;
            System.out.print(" "+c);
            a=b;
            b=c;
            i++;
        }
    }
    
}
