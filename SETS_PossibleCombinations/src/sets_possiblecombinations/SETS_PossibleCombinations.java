package sets_possiblecombinations;
import java.util.Scanner;
public class SETS_PossibleCombinations {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        System.out.print("Enter the SET size, maximum of size 5: ");
        int size=key.nextInt();
        int setA[]=new int[size],subs=1;
        System.out.println("Enter the elements:");
        for(int a=0; a<size; a++){
            setA[a]=key.nextInt();
            subs=subs*2;
        }
        System.out.println("\npossible combinations without repeatition: "+subs+" subsets");
        System.out.println("null");
        
        for(int a=0;a<size;a++){
                System.out.println(setA[a]);
            }
        for(int b=0;b<size-1;b++){
            for(int c=b+1;c<size;c++){
                System.out.println(setA[b]+","+setA[c]);
            }
        }
        for(int b=0;b<size-1;b++){
            for(int c=b+1;c<size;c++){
                for(int d=c+1;d<size;d++){
                    System.out.println(setA[b]+","+setA[c]+","+setA[d]);
                }
            }
        }
        for(int b=0;b<size-1;b++){
            for(int c=b+1;c<size;c++){
                for(int d=c+1;d<size;d++){
                    for(int e=d+1;e<size;e++){
                        System.out.println(setA[b]+","+setA[c]+","+setA[d]+","+setA[e]);
                    }
                }
            }
        }
        for(int z=0;z<size;z++){
            System.out.print(setA[z]+" ");
        }
    }
}
