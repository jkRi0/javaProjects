package withtextdocument;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class WithTextDocument {
    public static void start()throws IOException{
        Scanner key = new Scanner(System.in);
        System.out.println("\nDone...\n");
        
        main(null);     //to repeat from the start
    }
    public static void main(String[] args)throws IOException, FileNotFoundException{
        File myObj = new File("C:\\---#SAMSUNG300V4A_files#---\\justine\\JAVA Programming\\WithTextDocument\\test.txt");     //locate the file
        File theText = new File("C:\\---#SAMSUNG300V4A_files#---\\justine\\Miscellaneous\\rockyou.txt");     //for compare option
        Scanner myReader = new Scanner(myObj);      //scan the file
        Scanner toRead = new Scanner(theText);
        Scanner key=new Scanner(System.in);
        System.out.print("Do you want to conCat? (Y)yes (N)no (S)stop (C)compare: ");
        String f=key.next();
        String info="";
        
        if(f.equals("Y")){
            while(myReader.hasNextLine()){
                info = info.concat(myReader.nextLine()+"\n");
            }
            FileWriter writer = new FileWriter("C:\\---#SAMSUNG300V4A_files#---\\justine\\JAVA Programming\\WithTextDocument\\test2.txt");
            writer.write(info);      //your input will store to the text document
            writer.close();
            start();
        }
        else if(f.equals("N")){
            System.out.print("Do you want to Input? Y or N: ");
            String h = key.next();
            if(h.equals("Y")){
                System.out.print("Which txt do you want to edit 1 or 2? ");
                int i = key.nextInt();
                if(i == 2){
                    System.out.println("Type /save or Input to test2.txt: ");          //input for the file
                    while(myReader.hasNextLine()){
                        String d=key.nextLine(), j = "/save";
                        info = info.concat(d+"\n");     
                        if(d.equals(j)){
                            start();
                        }
                        FileWriter writer = new FileWriter("C:\\---#SAMSUNG300V4A_files#---\\justine\\JAVA Programming\\WithTextDocument\\test2.txt");
                        writer.write(info);      //your input will store to the text document
                        writer.close();
                    }
                }
                else{
                    System.out.println("Type /save or Input to test.txt: ");          //input for the file
                    while(myReader.hasNextLine()){
                        String d=key.nextLine(), j = "/save";
                        info = info.concat(d+"\n");
                        if(d.equals(j)){
                            start();
                        }
                        FileWriter writer = new FileWriter("C:\\---#SAMSUNG300V4A_files#---\\justine\\JAVA Programming\\WithTextDocument\\test.txt");
                        writer.write(info);      //your input will store to the text document
                        writer.close();
                    }
                }
            }
            else{
                System.out.println("Information from test.txt");
                while(myReader.hasNextLine()){
                    System.out.println(myReader.nextLine());
                }
                start();
            }
        }
        else if(f.equals("S")){
            System.out.println("STOPPED");
            System.exit(0);
        }
        else if(f.equals("C")){
            
            System.out.print("Enter the word: ");
            String k=key.next(), storage="";
            while(toRead.hasNextLine()){
                storage = toRead.nextLine();
                if(k.equals(storage)){
                    System.out.println("There's was");
                    break;
                }
            }
            start();
        }
    }
}
