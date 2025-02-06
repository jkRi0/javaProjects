import java.io.File;
import java.util.Arrays;

public class TheFolderCombnination {

	public static void main(String[] args) {

		int count4=0;
		int start=1;
		int end=11;
      	int arrsize = 1;
      	int lengthOFpassword=5;
      	String path="F:\\TheFolder"; //starting directory
		int arr[] = new int[arrsize]; //changeable array length
		arr[0]=start; //STARTING NUMBER
		int temp2=start;
		String str="\\"+Integer.toString(temp2);
		
        
        while(true)
        {
        	
        	//SET THE ARRAY ORDER ON REVERSE, used for folders directories
      	    String a=Arrays.toString(arr),temp3="";
      	    int d = 0;
      	    for(int b=0; b<arr.length; b++){ 
      	    	for(int c=0; c<arr.length; c++){
      	    		//comparing the indices of the array
      	    		if(a.indexOf(a.charAt(b))<a.indexOf(a.charAt(c))){
      	    			//swapping the variables from each indices
      	    			d=arr[b];
      	    			arr[b]=arr[c];
      	    			arr[c]=d;
      	    		}
      	    	}
      	    }
      	    //CREATING THE PATH DIRECTORIES
      	    for(int e=0; e<arr.length; e++){
      	    	temp3+="\\"+arr[e];
      	    	
      	    	if(e==arr.length-1) {
      	    		
      	    		String path1=path+temp3;
      	    		File files = new File(path1);
      	    		if (!files.exists()) {
      	    			if (files.mkdirs()) {
      	    				count4++;
      	    				System.out.println("Multiple directories are created!"+" "+path1+"\t\t"+count4);
      	    			} 	
      	    			else {
      	    				System.out.println("Failed to create multiple directories!");
      	    			}
      	    		}
      	    	}
      	    }
      	    
      	    //SET THE ARRAY ORDER TO NORMAL
    	    String a1=Arrays.toString(arr);
    	    int d1 = 0;
    	    for(int b=0; b<arr.length; b++){ 
    	    	for(int c=0; c<arr.length; c++){
    	    		if(a1.indexOf(a1.charAt(b))<a1.indexOf(a1.charAt(c))){
    	    			d1=arr[b];
    	    			arr[b]=arr[c];
    	    			arr[c]=d1;
    	    		}
    	    	}
    	    }
            
    	    
    	    
    	    
          	//RESET THE VALUE
          	str="";
            
            //START OF CREATING COMBINATIONS
      	    arr[0]++;
      	      
      	    //LOOP FOR ARRAY SET
      	    for(int count2=0; count2<arr.length; count2++){
      	    	str=str+"\\"+arr[count2];   
      	    	
      	    	//INCREMENT THE ARRAY LENGTH
      	        if(arr[arr.length-1]==end){
      	            arrsize++;
      	            arr=new int[arrsize];
      	            
      	            //TO RESET ALL ELEMENT TO START
      	            for(int count3=0; count3<arr.length; count3++) {
    	            	arr[count3]=start;
    	            }
      	        }
      	            
      	        //INCREMENT THE ELEMENTS
      	        else if(arr[count2]==end){
      	                  
      	        	int temp=count2; //TEMPORARY VARIABLE
      	            count2++; 
      	            arr[count2]++; //INCREMENT THE ELEMENT AFTER THE ELEMENT THAT ACHIEVED THE CONDITION 
      	            count2=temp; //RETURN TO PREVIOUS ELEMENT UNIL THE NEXT ELEMENT ACHIEVED THE CONDITION
      	            arr[count2]=start;    //INT TO CHAR
      	        }
      	    }
      	    
      	    
      	    //limitation
      	    if(arrsize==(lengthOFpassword+1)) {
      	    	System.exit(0);
      	    }
        }

	}

}
