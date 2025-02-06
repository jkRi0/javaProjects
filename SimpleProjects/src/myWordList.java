import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class myWordList {
	public static void main(String[] args) throws InterruptedException, IOException{
		/*
		COMMENT STATUS:
		
		 		I think 4 word list are good for now!
		 		
		*/
		
		//INITIALIZATION
        int start=32;
		int end=126;
		int fileSizeLimitMB=1000;
      	int arrsize = 1;
      	int count4=0;
		char arr[] = new char[arrsize]; //changeable array length
		arr[0]=(char)start; //STARTING NUMBER
		String theTextFile="D:\\test.txt";  //the text file
		char temp2=(char)start;
		String str=Character.toString(temp2), data="", hexVal="";
		
		//FOR ARRAY ELEMENTS CONTINUATION
		//PT3F!
		String lastLine=""; //type the last set of characters on the precious text file
						//the value of lastLine must not be null or empty
		arrsize=lastLine.length();
		arr=new char[arrsize];
		
		for(int count5=0; count5<arrsize; count5++) {
			arr[count5]=lastLine.charAt(count5);
		}
		
		//CREATING THE TEXT FILE
		File accountData = new File(theTextFile);
		accountData.createNewFile();
		Scanner myReader = new Scanner(accountData);
        
		
		
		//STARTING LINE FOR TEXT FILE
		data = data.concat("\n");
		FileWriter writer = new FileWriter(theTextFile,true);
		writer.write(data);
		writer.close();
		
        
        while(true)
        {
            //PRINT THE COMBINATIONS
        	count4++;
            System.out.print(str+"\t"+"line: "+count4+"\t\t"+"hex: "+hexVal);
            
            
            //PRINT THE SET ON ARRAY
      	    System.out.print("\t\t"+Arrays.toString(arr)+"\t\t");
      	    
            
            
            //STORING THE COMBINATION ON A TEXT FILE
          	if(myReader.hasNextLine()) {
          		data = data.concat(str+"\n");
          		FileWriter writer1 = new FileWriter(theTextFile,true);
          		writer1.write(data);
          		writer1.close();
          	}
          	
          	
          	//GET THE TEXT FILE SIZE
    		File file = new File(theTextFile);
    		if (!file.exists() || !file.isFile()) return;
    		int filebytes=(int) file.length();
    		int fileSize=0;
    		
    		if(filebytes/1024>1000) {
    			System.out.println(filebytes/(1024*1024)+" mb");
    		}
    		else if(filebytes>1000) {
    			System.out.println(filebytes/1024+" kb");
    		}
    		else {
    			System.out.println(filebytes+" bytes");
    		}
    		
    		//FILE SIZE LIMIT
    		fileSize=filebytes/(1024*1024);
    		if(fileSize==fileSizeLimitMB) {
    			System.exit(0);
    		}
            
          	
          	
          	//RESET THE VALUE
          	str="";
            hexVal="";
            data="";
            
            //START OF CREATING COMBINATIONS
            
      	    int temp1=(int)arr[0]; //CHAR TO INT
      	    temp1++; //INT INCREMENT
      	    arr[0]=(char)temp1; //INT TO CHAR
      	      
      	    //LOOP FOR ARRAY SET
      	    for(int count2=0; count2<arr.length; count2++){
      	    	str=str+arr[count2];
      	    	hexVal=hexVal+" "+(int)arr[count2];
      	            
      	    	//INCREMENT THE ARRAY LENGTH
      	        if(arr[arr.length-1]==end){
      	            arrsize++;
      	            arr=new char[arrsize];
      	            
      	            //TO RESET ALL ELEMENT TO START
      	            for(int count3=0; count3<arr.length; count3++) {
    	            	arr[count3]=(char)start;
    	            }
      	        }
      	            
      	        //INCREMENT THE ELEMENTS
      	        else if(arr[count2]==end){
      	                  
      	        	int temp=count2; //TEMPORARY VARIABLE
      	            count2++; 
      	            arr[count2]++; //INCREMENT THE ELEMENT AFTER THE ELEMENT THAT ACHIEVED THE CONDITION 
      	            count2=temp; //RETURN TO PREVIOUS ELEMENT UNIL THE NEXT ELEMENT ACHIEVED THE CONDITION
      	            arr[count2]=(char)start;    //INT TO CHAR
      	        }
      	    }
        }
	}
}
