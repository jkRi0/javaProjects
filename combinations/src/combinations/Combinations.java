package combinations;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.*; // Import the Scanner class to read text files
public class Combinations {
    public static void main(String[] args)throws InterruptedException, IOException, FileNotFoundException{
        File myObj = new File("C:\\Users\\JK\\Desktop\\aaa.txt");     //locate the file
        File theText = new File("C:\\\\Users\\\\Public\\\\applicationProjectSavedAccount.txt");     //for compare option
        Scanner myReader = new Scanner(myObj);      //scan the file
        Scanner toRead = new Scanner(theText);
        Scanner key=new Scanner(System.in);
        System.out.print("(1)insert (2)compare (3)stop: ");
        String choice=key.next();
        String info="",store="",fix="";
        
        boolean x=true;
        long starttime=System.currentTimeMillis(),Minutes=0, Hours=0, days=0, count=0;
    
        if(choice.equals("1")){
                String keys[]={" ","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",  
                            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                            "0","1","2","3","4","5","6","7","8","9","`","~","!","@","#","$","%","^","&","*","(",")","_","-","=","+",
                            "[","{","}","]","'",";",":","/","?",".",">",",","<","|"};
                
                    for(int a=0; a<92; a++){
                        for(int b=0; b<92; b++){
                            for(int c=0; c<92; c++){
                                for(int d=0; d<92; d++){
                    for(int e=0; e<93; e++){
                        for(int f=0; f<93; f++){
                            for(int g=0; g<93; g++){
                                for(int h=0; h<93; h++){
                    for(int i=0; i<92; i++){
                        for(int j=0; j<92; j++){
                            for(int k=0; k<92; k++){
                                for(int l=0; l<92; l++){
                    for(int m=0; m<93; m++){
                        for(int n=0; n<93; n++){
                            for(int o=0; o<93; o++){
                                for(int p=0; p<93; p++){
                                    store = keys[a]+keys[b]+keys[c]+keys[d]+keys[e]+keys[f]+keys[g]+keys[h]+
                                            keys[i]+keys[j]+keys[k]+keys[l]+keys[m]+keys[n]+keys[o]+keys[p];
                                    long timepassed=System.currentTimeMillis()-starttime;
                                    long seconds=timepassed/1000;
                                    if(seconds==60){
                                        seconds=0;
                                        starttime=System.currentTimeMillis();
                                        Minutes++;
                                        if(Minutes==60){
                                            Minutes=0;
                                            Hours++;
                                            if(Hours==24){
                                                Hours=0;
                                                days++;
                                            }
                                        }
                                    }
                                    System.out.println(store+"      "+a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h+" "+i+" "+j+" "+k+" "+l+" "+m+" "+n+" "+o+" "+p+
                                            "       "+days+":"+Hours+":"+Minutes+":"+seconds+"      "+count);
                                    count++;
                                    FileWriter writer = new FileWriter("C:\\Users\\JK\\Desktop\\aaa.txt");
                                    if(count==10000){
                                        System.exit(0);
                                    }
                                    else if(p<=0){
                                        fix=store.substring(16);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(o<=0){
                                        fix=store.substring(15);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(n<=0){
                                        fix=store.substring(14);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(m<=0){
                                        fix=store.substring(13);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(l<=0){
                                        fix=store.substring(12);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(k<=0){
                                        fix=store.substring(11);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(j<=0){
                                        fix=store.substring(10);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(i<=0){
                                        fix=store.substring(9);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(h<=0){
                                        fix=store.substring(8);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(g<=0){
                                        fix=store.substring(7);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(f<=0){
                                        fix=store.substring(6);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(e<=0){
                                        fix=store.substring(5);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(d<=0){
                                        fix=store.substring(4);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(c<=0){
                                        fix=store.substring(3);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(b<=0){
                                        fix=store.substring(2);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(a<=0){
                                        fix=store.substring(1);
                                        if(myReader.hasNextLine()){
                                            info = info.concat(fix+"\r\n");
                                            writer.write(info);      //your input will store to the text document
                                            writer.close();
                                        }
                                    }
                                    else if(store.equals("            AAAA")){
                                        System.exit(0);
                                    }
                                }
                            }   
                        }
                    }
                                }
                            }   
                        }
                    } 
                                }
                            }   
                        }
                    }
                                }
                            }   
                        }
                    }
        }
        else if(choice.equals("2")){
            
            System.out.print("Enter the word: ");
            String k=key.next(), storage="",test="@.com";
            while(toRead.hasNextLine()){
                storage = toRead.nextLine();
                if(k.equals(storage)){
                    System.out.println("There it was!!!  "+storage);
                    storage = toRead.nextLine();
                    if(test.equals(storage)){
                        System.out.println("There it was!!!  "+storage);
                    }
                    else{
                        break;
                    }
                    break;
                }
            }
            System.out.println("\nDone...\n");
            main(null);     //to repeat from the start
        }
        else if(choice.equals("3")){
            System.out.println("STOPPED");
            System.exit(0);
        }
        else{
            main(null);
        }
    }
}

/*

*/