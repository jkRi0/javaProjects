import java.util.Scanner;

public class OccuringNumbers {
	//DECLARATION
	static int arrSize=0;
	static int occurCount=0;
    static int highestOccurCount=0;
    static int highestOccuringNum=0;
    static int array[]=null;
    static int array1[]=null;
	
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //DETERMINE THE ARRAY SIZE
        System.out.print("Enter the array size: ");
        //VALIDATE THE USER INPUT
        if(scan.hasNextInt()){
            arrSize=scan.nextInt();
        }else{
            System.out.println("Invalid input, please try again.\n");
            main(null);
        }

        //INITIALIZATION OF ARRAY SIZE
        array=new int[arrSize];
        array1=new int[0];
            
        //INSERTION OF ELEMENTS
        for(int count=0; count<arrSize; count++){
            System.out.print("Insert an integer for index "+count+" : ");
            if(scan.hasNextInt()){
                array[count]=scan.nextInt();
            }else{
                System.out.println("Invalid input, please try again.\n");
                main(null);
            }
        }
        
        //FIRST SET FOR COMBINING THE ELEMENTS
        for(int count=0; count<arrSize; count++) {
        	//SECOND SET FOR COMBINING THE ELEMENTS
            for(int count1=0; count1<arrSize; count1++) {
            	//COUNT THE OCCURRENCE
            	if(array[count]==array[count1]) 
            		occurCount++;
            	
            	//MUST BE GREATER THAN 1, TO BE INCLUDED IN OCCURING NUMBERS
            	if(occurCount>1) 
            		//SEARCH ON ARRAY, TO PREVENT MULTIPLE COMBINING OF ELEMENTS
            		if(!ifHasDuplicate(array1,count))
            			//DYNAMICALLY ADDING OF ELEMENT
            			array1=DynamicArray(count,array1);
            	
            	//TO DETERMINE THE HIGHEST OCCURING NUMBER
            	if(occurCount>highestOccurCount) {
            		highestOccurCount=occurCount;
            		highestOccuringNum=array[count];
            	}
            }
            //RESET THE OCCURING COUNTER FOR THE NEXT ELEMENT TO BE EVALUATE
            occurCount=0;
        }

        //DISPLAY THE ELEMENTS AND THEIR INDICES
        System.out.println("\nList of integers:");
        DisplayElements(array,null,false);

        //DISPLAY THE MOST OCCURING INTEGER AND THEIR INDICES
        System.out.println("\nList of Most occuring number/s:");
        DisplayElements(array,null,true);

        //DISPLAY ALL THE OCCURING NUMBERS, IF THERES ANY.
        System.out.println("\nList of existing occuring number/s:");
        DisplayElements(array,array1,false);
    }

    //METHOD TO DISPLAY THE ARRAY ELEMENTS
    public static void DisplayElements(int[]arr1, int[]arr2, boolean useMostOccuring) {
    	//LOOP FOR TRAVERSING THE SELECTED ARRAY
    	for(int count=0; count<(arr2!=null?arr2.length:arr1.length); count++) {
    		//TO PRINT THE MOST OCCURING NUMBERS
    		if(useMostOccuring && arr1[count]==highestOccuringNum)
    			System.out.println(arr1[count]+" at index "+count);
    		//TO PRINT THE ORDINARY ARRAY OR THE ARRAY OF EXISTING OCCURING NUMBERS
    		else if(!useMostOccuring)
    			System.out.println((arr2!=null? arr1[arr2[count]] : arr1[count])+
    					" at index "+(arr2!=null? arr2[count] : count));
    	}
    }
    
    //METHOD FOR CREATING THE DYNAMIC ARRAY
    public static int[] DynamicArray(int element, int[]arr){
        //TEMPORARY ARRAY WITH INCREMENTED SIZE
		int []temp=new int[arr.length+1];

		//TRANSFER THE ELEMETS
		for(int count=0; count<arr.length; count++) {
			temp[count]=arr[count];
		}
		//ADD THE NEW ELEMENT
		temp[arr.length]=element;
		
		return temp;
    }
    
    //TO VERIFY IF THE ELEMENT IS ALREADY EXISTING ON THE ARRAY
    public static boolean ifHasDuplicate(int[]arr, int element) {
    	//USING FOR EACH LOOP TO SEARCH THE ELEMENT
    	for(int num:arr)
    		if(element==num)
    			return true;
    	return false;
    }
}