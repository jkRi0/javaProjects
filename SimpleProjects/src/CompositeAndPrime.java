//November 25, 2023
//2nd year, 1st semester

import java.util.Arrays;

public class CompositeAndPrime {

	public static void main(String[] args) {
		Search(100);
	}

	public static void Search(int limit) {
		int []composite=new int[0];
		int []prime=new int[0];
		
		//DETERMINE THE COMPOSITE AND PRIME NUMBERS
		for(int count=0; count<limit; count++) {
			if(isComposite(count)==true) {
				composite=DynamicArray(composite,count);
			}else {
				prime=DynamicArray(prime,count);
			}
		}
		//PRINT
		System.out.println(Arrays.toString(prime));
		System.out.println(Arrays.toString(composite));
	}
	
	public static boolean isComposite(int num) {
		//IF THE NUMBER HAS MORE THAN 2 FACTORS, THEN IT IS COMPOSITE
		if(ComputeFactors(num)>2) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int ComputeFactors(int num) {
		int count=0;
		//COUNT THE FACTORS
		for (int count1 = 1; count1 <= num; count1++){ 
			if (num % count1 == 0){
				count++;
			}
		}
		return count;
	}
	
	public static int[] DynamicArray(int []arr, int num) {
		//TEMPORARY ARRAY WITH INCREMENTED SIZE
		int []temp=new int[arr.length+1];
		//TRANSFER THE ELEMETS
		for(int count=0; count<arr.length; count++) {
			temp[count]=arr[count];
		}
		//ADD THE NEW ELEMENT
		temp[arr.length]=num;
		
		return temp;
	}
}
