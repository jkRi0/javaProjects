package jaggedarray_withdeleting_andadding_index;
import java.util.Arrays;
import java.util.Scanner;
public class JaggedArray_withDeleting_andAdding_index {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the layer size: ");
        int tableSize=input.nextInt();
        double sampleArray[][][]=new double[tableSize][][];
        
        //TO GET THE SIZES FOR EACH ROW
        for(int count1=0; count1<tableSize; count1++){
            System.out.print("Enter the row size of Layer "+count1+": ");
            sampleArray[count1]=new double[input.nextInt()][];
        }
        
        //TO GET THE SIZES FOR EACH COLUMN
        for(int count1=0; count1<tableSize; count1++){
            for(int count2=0; count2<sampleArray[count1].length; count2++){
                System.out.print("Enter the column size of Layer "+count1+" Row "+count2+": ");
                sampleArray[count1][count2]=new double[input.nextInt()];
            }
        }
        
        //CREATING THE 3D ARRAY
        for(int count1=0; count1<tableSize; count1++){
            System.out.println("Value for Layer "+count1+": ");
            for(int count2=0; count2<sampleArray[count1].length; count2++){
                System.out.println("Enter values for Row "+count2+": ");
                for(int count3=0; count3<sampleArray[count1][count2].length; count3++){
                    sampleArray[count1][count2][count3]=input.nextDouble();
                }
                System.out.println("");
            }
            System.out.println("");
        }
        
        //PRINTING THE 3D ARRAY
        System.out.println("\nValues of the 3D Array");
        for(int count1=0; count1<tableSize; count1++){
            System.out.println("Layer "+count1+" Elements: ");
            for(int count2=0; count2<sampleArray[count1].length; count2++){
                for(int count3=0; count3<sampleArray[count1][count2].length; count3++){
                    System.out.print(sampleArray[count1][count2][count3]+"\t");
                }
                System.out.println("");
            }
            System.out.println("");
        }
        
        
        
        //MANIPULATING THE LENGTH OF AN ARRAY BY DELETING
        Scanner in = new Scanner(System.in);
	System.out.println("Enter an Index number to delete: ");
	int delete = in.nextInt();
	
	int num[] = {1,2,3,4,5};
	
	int newNum[] = new int[num.length -1];
	int j = delete; //the index
	for(int i =0, k=0; i < num.length; i++) {
            if(i != j) {
		newNum[k] = num[i];	
                k++;
            }
	}
	System.out.println("Original Arrays: " + Arrays.toString(num));
	System.out.println("New Arrays: " + Arrays.toString(newNum));
                
        //MANIPULATING THE LENGTH OF AN ARRAY BY ADDING
        int num2[] = {1,2,3,4,5};	
	int n = num2.length; //5
	int newNum2[] = new int[n + 1]; //6
	int val = 8;
	System.out.println("The Original Arrays: " + Arrays.toString(num2));
	for(int i =0; i < n; i++) {
            newNum2[i] = num2[i];  
	}
	newNum2[n] = val;
	System.out.println("The Updated Array: " + Arrays.toString(newNum2));
    }
}
