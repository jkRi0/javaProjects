package datatypes_convertion;
import java.util.*;
public class DataTypes_Convertion {
    public static void main(String[] args) {
        //STRING TO INT     1
            String a = "1";
            int b=Integer.parseInt(a);
            System.out.println(b);
            
        //INT TO STRING     2
            int a1 = 3;
            String b1 = Integer.toString(a1);
            System.out.println(b1);
            
        //DOUBLE TO INT     3
            double a2 = 32.892534;
            int b2 = (int)a2;
            System.out.println(b2);
            
            //rounding      4
            int c2 = (int)Math.round(a2);
            System.out.println(" "+c2);
            
        //INT TO DOUBLE     5
            int a3 = 5;
            double b3 = (double)a3;
            System.out.println(b3);
        
        //STRING TO CHAR    6
            String a4 = "h";  
            char b4 = a4.charAt(0);
            System.out.println(b4);
            
        //CHAR TO STRING    7
            char a5 = 'z';
            String b5 = Character.toString(a5);
            System.out.println(b5);
            
        //STRING TO BOOLEAN 8
            String a6 = "true";
            boolean b6 = Boolean.parseBoolean(a6);
            System.out.println(b6);
            
        //BOOLEAN TO STRING 9
            boolean a7 = false;
            String b7 = Boolean.toString(a7);
            System.out.println(b7);
    }
}
