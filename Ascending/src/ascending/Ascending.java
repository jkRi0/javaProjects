package ascending;
public class Ascending {
    public static void main(String[] args) {
        int a[]={5,9,2,56,12}; 
        int d = 0;
        for(int b=0; b<a.length; b++){ 
            for(int c=0; c<a.length; c++){
                if(a[b]<a[c]){
                    d=a[b];
                    a[b]=a[c];
                    a[c]=d;
                }
            }
        }
        for(int e=0; e<a.length; e++){
            System.out.println(a[e]);
        }
    }
}
