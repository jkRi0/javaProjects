package electricbillcalculator;
import java.util.*;
public class ElectricBillCalculator {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        System.out.println("***Compute at exact reading day every month***");
        System.out.print("\nCurrent kwh: ");
        double a=key.nextDouble();
        System.out.print("Previous kwh: ");
        double b=key.nextDouble();
        System.out.print("Rate from previous month: ");
        double c=key.nextDouble();
        double d=a-b;
        double e=d*c;
        float  f=Float.parseFloat(String.valueOf(e));
        System.out.println("\nYour bill: "+f);
    }
    
}
