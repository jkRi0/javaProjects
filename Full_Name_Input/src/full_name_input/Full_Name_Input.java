package full_name_input;
import java.util.Scanner;
public class Full_Name_Input {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.print("\nEnter your Full Name: ");
        String Name = key.nextLine(); //nextLine is used to consider spaces too
        
        System.out.print("First Name: ");
        int ind = 0, ind2 = 0; 
        BigBreak:
        for(int d=Name.length()-1; d>=0; d--){ //for reverse name
            ind = d+1; //for last name
            if(Name.charAt(d) == ' '){ //limitation for last name
                for(int f=d-1; f>=0; f--){
                    ind2 = f+1; //for middle name
                    if(Name.charAt(f) == ' '){ //limitation for middle name
                        for(int g=0; g<=f; g++){
                            System.out.print(Name.charAt(g)); //printing first name
                        }
                        break BigBreak; //end of full name partition
                    }
                }
            }
        }
        System.out.print("\nMiddle Initial: "+Name.charAt(ind2)+"."); //character on number (ind2)
        System.out.println("\nLast Name: "+Name.substring(ind));
    }
    
}
