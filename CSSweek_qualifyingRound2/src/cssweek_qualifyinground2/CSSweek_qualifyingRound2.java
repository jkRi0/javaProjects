package cssweek_qualifyinground2;

public class CSSweek_qualifyingRound2 {
    public static void main(String[] args) {
        //TEST CASES
        int set1[]={4, 5, 33, 20, 19, 0};
        int set2[]={18, 44, 0};
        int set3[]={44, 9, 18, 23, 7, 34, 8, 19, 0};
    
        System.out.println("\nset = {4, 5, 33, 20, 19, 0}");		//output 8
        System.out.println("output"+computation(set1));
        System.out.println("\nset = {18, 44, 0}");				//output 2
        System.out.println("output"+computation(set2));
        System.out.println("\nset = {44, 9, 18, 23, 7, 34, 8, 19, 0}");	//output 6
        System.out.println("output"+computation(set3));
    }
    //THE FUNCTION FOR GETTING THE HIGHEST QUOTIENT
    public static int computation(int a[]){
        int quotient=0, highest=0;
        for(int count1=0; count1<a.length; count1++){
            for(int count2=0; count2<a.length; count2++){
              //TO SHOW THE INVALID COMPUTATION
                if(a[count2]==0){
                    System.out.println(a[count1]+" divided by "+a[count2]+" is a math error");
                }
        	//TO DIVIDE THE TWO COMBINATION
                else{
                    quotient=a[count1]/a[count2];
                }
                //STORE THE HIGHEST
                if(quotient>highest)
                    highest=quotient;
            }
        }
        return highest;
    }
}
