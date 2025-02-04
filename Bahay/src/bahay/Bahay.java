package bahay;
import java.util.Scanner;
public class Bahay {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        
        //triangle
        for(int j=1; j<=10; j++){
            for(int i=1; i<=10-j; i++){
                System.out.print(" ");
            }
            for(int k=1; k<=j; k++){
                System.out.print("*");
            }
            for(int a=1; a<=j-1; a++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        //rectangle
        for(int a=1; a<=8; a++){
            int e=15;
            System.out.print("  ");
            for(int b=1; b<=e; b++){
                //door
                if(b==4 && a>4){
                    System.out.print("__");
                    int c=2;
                    e=e-c;  
                }
                //window
                else if(b==8 && a==5){
                    System.out.print("[][]");
                    int c=4;
                    e=e-c;
                }
                System.out.print("*");
            }
            System.out.print("  \n");
            
        }
        
        //circle
        int x=0, y=1, z=0;
        for (int i=0; i<5; i++){
            System.out.print(y+" ");
            z = x + y;
            x = y;
            y = z;
        }
        x=0;
        y=5;
        z=0;
        for (int i=5; i>0; i--){
            System.out.print(y+" ");
            z = x - y;
            x = y;
            y = z;
        }
    }
}
