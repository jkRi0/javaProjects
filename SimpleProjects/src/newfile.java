import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		int end=80;
		int start=75;
		int limit=10;
      	int arrsize = 1;
		char arr[] = new char[arrsize]; //changeable array length
		arr[0]=(char)70; //STARTING NUMBER
		
		//LOOP FOR EVERY SET
      	for(;;){
      	      
      	      int temp1=(int)arr[0]; //CHAR TO INT
      	      temp1++; //INT INCREMENT
      	      arr[0]=(char)temp1; //INT TO CHAR
      	      
      	      //LOOP FOR ARRAY SET
      	      for(int count2=0; count2<arr.length; count2++){
      	            
      	            //INCREMENT THE ARRAY LENGTH
      	            if(arr[arr.length-1]==80){
      	                  arrsize++;
      	                  arr=new char[arrsize];
      	            }
      	            
      	            //INCREMENT THE ELEMENTS
      	            else if(arr[count2]==80){
      	                  
      	                  int temp=count2; //TEMPORARY VARIABLE
      	                  count2++; 
      	                  arr[count2]++; //INCREMENT THE ELEMENT AFTER THE ELEMENT
      	                                            // THAT ACHIEVED THE CONDITION 
      	                  count2=temp; //RETURN TO PREVIOUS ELEMENT UNIL THE NEXT 
      	                                            //ELEMENT ACHIEVED THE CONDITION
      	                  arr[count2]=(char)70;    //INT TO CHAR
      	                  
      	            }
      	            
      	            //ARRAY LENGTH LIMITATION
      	            else if(arr.length==100){
      	                  System.exit(0);
      	            }
      	            
      	      }
      	      
      	      //PRINT THE SET ON ARRAY
      	      System.out.println(Arrays.toString(arr));
      	}
      	
      }
}