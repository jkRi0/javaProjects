import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestingArea2 {
	
	
    public static void main(String[] args) {
    	int arr[][]=new int[6][7];
    	int increment=0;
    	for(int count=0; count<arr.length; count++) {
    		for(int count1=0; count1<arr[count].length; count1++) {
        		arr[count][count1]=increment++;
        	}
    	}
    	for(int count=0; count<arr.length; count++) {
    		for(int count1=0; count1<arr[count].length; count1++) {
        		System.out.print(" "+arr[count][count1]);
        	}
    		System.out.println("\n");
    	}
    	
    	System.out.println("\n");
    	//********************************************************
    	//DIAGONAL VALIDATION
    	for(int count=1; count<7; count++) {
    		for(int count1=count; count1>count/2; count1--) {
        		System.out.print(count1+" ");
        	}
    		
    		for(int count1=((count+1)/2)+1; count1<count+1; count1++) {
        		System.out.print(count1+" ");
        	}
    		
    		System.out.println("\n");
    		
    	}
//    	for(int count=2; count<14; count++) {
//    		for(int count1=(count/2)+1; count1<count; count1++) {
//        		System.out.print(count1+" ");
//        	}
//    		
//    		System.out.println("\n");
//    		
//    	}
    	
    	//OR
    	
    	System.out.println("\n--------------------------------");
    	int tempCount;
    	for(int count=0; count<6; count++) {
    		tempCount=count;
    		for(int count1=0; count1<count+1; count1++) {
    			System.out.println(tempCount+" "+count1);
    			tempCount--;
        	}
    		System.out.println("\n");
    	}
    	System.out.println("\n------------------------------");
    	int tempCount1=0;
    	for(int count=-1; count<5; count++) {
    		tempCount1=count+2;
    		for(int count1=5; count1>count; count1--) {
    			System.out.println(count1+" "+tempCount1);
    			tempCount1++;
        	}
    		System.out.println("\n");
    	}
    	
    	System.out.println("\n-----------------------------");
    	int tempCount2=6;
    	for(int count=5; count>=0; count--) {
    		for(int count1=count; count1>=0; count1--) {
    			System.out.println(count1+" "+tempCount2);
    			tempCount2--;
    		}
    		tempCount2=6;
    		System.out.println("\n");
    	}
    	
    	
    	System.out.println("\n----------------------------");
    	
    	int tempCount3=0;
    	for(int count=6; count>=0; count--) {
    		tempCount3=5-count;
    		for(int count1=5; count1>=count; count1--) {
    			System.out.println(count1+" "+tempCount3);
    			tempCount3--;
        	}
    		System.out.println("\n");
    	}
    	
    	
    	//********************************************************
    	
    	System.out.println("\n---------------------------");
    	
    	//VERTICAL VALIDATION
    	for(int count=0; count<7; count++) {
    		for(int count1=0; count1<6; count1++) {
    			System.out.println(count1+""+count+" ");
        	}
    		System.out.println("\n");
    	}
    	
    	System.out.println("\n---------------------------");
    	//********************************************************
    	//HORIZONTAL VALIDATION
    	for(int count=5; count>=0; count--) {
    		for(int count1=0; count1<7; count1++) {
    			System.out.println(count+" "+count1);
        	}
    		System.out.println("\n");
    	}
    	
    	
    	System.out.println("\n");
    	Random RNDM=new Random();
        int digit=RNDM.nextInt(5);
    	System.out.println(digit);
    	
    }
}