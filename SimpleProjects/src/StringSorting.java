import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSorting {

	public static void main(String[] args) {
		//SAMPLE OF ARRAYLIST THAT NEEDS TO BE SORTED
		List<String> sampleList=new ArrayList<>();
		sampleList.add("\nasz asd 1");
		sampleList.add("\nasy asd 2");
		sampleList.add("\nbfg asd 3");
		sampleList.add("\nfgh asd 4");
		sampleList.add("\nasx asd 5");
		sampleList.add("\nejk asd 6");
		
		
		
				
		//DECLARATION OF TEMPORARY VARIABLES
		String temp1="";
		String tempList[]=new String[sampleList.size()];
		//TRANSFERRING OF ELEMENTS FROM ARRAYLIST TO ARRAY
		for(int count=0; count<tempList.length; count++) {
			tempList[count]=sampleList.get(count);
		}
				
		//method2(tempList);
		
		//SORTING THE STRING
		//USED FOR THE FIRST VARIABLE TO COMPARE 
		for(int count=0; count<sampleList.size(); count++) {
			//USED FOR THE SECOND VARIABLE TO COMPARE
			for(int count1=count+1; count1<sampleList.size(); count1++) {
				
				//VALIDATE THE COMPARING CHARACTER IF ITS DUPLICATE
				//OTHERWISE, COMPARE THE NEXT CHARACTER OF TWO STRING
				here: //BREAK POINT
				for(int count2=1; count2<sampleList.get(count).length(); count2++) {
					//GET THE DECIMAL VALUE OF THE CHARACTER FROM THE STRING 
					int decimal1=sampleList.get(count).charAt(count2);
					int decimal2=sampleList.get(count1).charAt(count2);
					
					//SWAPPING OF ELEMENTS
					if(decimal1!=decimal2 && decimal1>decimal2) {
						temp1=sampleList.get(count1);
						sampleList.set(count1, sampleList.get(count));
						sampleList.set(count, temp1);
						break here;
								
					}
					//BREAK IF ITS ALREADY MEET THE REQUIREMENT
					else if(decimal1<decimal2){
						break here;
					}
					/*THE TRAVERSING THROUGTH THE STRING
					WILL CONTINUE IF THE TWO COMPARING CHARACTER ARE STILL THE SAME*/
				}
			}
		}
		String asd="";
		for(String str:sampleList)
			asd+=str;
		
		System.out.println(asd);
	}
	
	
	public static void method2(String arr[]) {
		for(int i = 0; i < arr.length-1; i++) {  
			for (int j = i+1; j < arr.length; j++) { 
				// Comparing each element of the array with the rest elements. 
				if(arr[i].compareTo(arr[j])>0) {  
					// Swapping array elements  
					String temp = arr[i];  
					arr[i] = arr[j];  
					arr[j] = temp;  
				} 
		    }
		}
		
		System.out.println(Arrays.toString(arr)+"\n");
	}
}
