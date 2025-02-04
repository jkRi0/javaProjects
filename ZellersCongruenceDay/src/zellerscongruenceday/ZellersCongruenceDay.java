package zellerscongruenceday;
import java.util.*;
public class ZellersCongruenceDay {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        System.out.print("Day: ");
        int d=key.nextInt();
        System.out.println("3:march");
        System.out.println("4:april");
        System.out.println("5:may");
        System.out.println("6:june");
        System.out.println("7:july");
        System.out.println("8:august");
        System.out.println("9:september");
        System.out.println("10:october");
        System.out.println("11:november");
        System.out.println("12:december");
        System.out.println("13:january");
        System.out.println("14:february");
        System.out.print("Month: ");
        int m=key.nextInt();
        System.out.print("Year: ");
        int fullY=key.nextInt(),y=0;
        String fullYString=Integer.toString(fullY);
        for(int a=0;a<fullYString.length();a++){
            if(a>1){
                y=Integer.parseInt(fullYString.substring(a));
                System.out.print("\n"+y+"\n");
                break;
            }
        }
        int c=y/100;
        System.out.print("Century: "+c);
        System.out.print("\n\nFORMULA: x = (d+((13*(m+1))/5)+y+(y/4)+(c/4)+(5*c))mod 7");
        System.out.print("\nx = ("+d+"+((13*("+m+"+1))/5)+"+y+"+("+y+"/4)+("+c+"/4)+(5*"+c+")mod 7");
        System.out.print("\nx = ("+d+"+"+((13*(m+1))/5)+"+"+y+"+"+(y/4)+"+"+(c/4)+"+"+(5*c)+")mod 7");
        System.out.print("\nx = "+(d+((13*(m+1))/5)+y+(y/4)+(c/4)+(5*c))+" mod 7");
        System.out.print("\nx = "+(d+((13*(m+1))/5)+y+(y/4)+(c/4)+(5*c))% 7+"\n");
        int x = (d+((13*(m+1))/5)+y+(y/4)+(c/4)+(5*c))%7;
        switch(x){
            case 1:System.out.println("saturday");break;
            case 2:System.out.println("sunday");break;
            case 3:System.out.println("monday");break;
            case 4:System.out.println("tuesday");break;
            case 5:System.out.println("wednesday");break;
            case 6:System.out.println("thursday");break;
            case 7:System.out.println("friday");break;
            case 0:System.out.println("saturday");break;
        }
        
    }
}

/*

Not working!
but almost

*/