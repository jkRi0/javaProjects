package math_groupandungroupdata;
import java.util.*;
public class Math_GroupAndUnGroupData {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        System.out.print("Frequency length: ");
        double n=key.nextInt();
        System.out.print("What position (k): ");
        double k=key.nextInt();
        System.out.print("Class Interval [(1)yes] [(0)no]? ");
        int Interval=key.nextInt();
        //******************************************************************************
        int CI[]=new int[(int)n*2];
        if(Interval==1){
            for(int c2=0;c2<n*2;c2++){
                if(c2%2==0){
                    System.out.print("Lower Boundary: ");
                    CI[c2]=key.nextInt();
                }
                else if(c2%2==1){
                    System.out.print("Upper Boundary: ");
                    CI[c2]=key.nextInt();
                }
            }
        }
        //******************************************************************************
        int intNum = (int)n;
        double f[]=new double[intNum],forGroup[]=new double[intNum];
        for(int c1=0;c1<f.length;c1++){
            System.out.print("  input frequency: ");
            f[c1]=key.nextInt();
            forGroup[c1]=f[c1];
        }
        double qk;
        int q1;
        System.out.println("\nUNGROUP DATA");
        System.out.println("********************************************************************");
            Arrays.sort(f);
            System.out.println(Arrays.toString(f));
            System.out.println("    Quartile");
            System.out.println("        q_k = (k/4(n+1))");
            System.out.println("        k = "+k);
            System.out.println("        n = "+n);
            qk=(k/4)*(n+1);
            System.out.println("        q_k = "+qk);
            q1=(int)qk;
            if(qk>q1){ //if does have decimals
                if(qk>=1){
                    double ave=(f[q1-1]+f[q1])/2.0;
                    System.out.println("        value in position = "+ave);
                }
            }
            else{
                System.out.println("        value in position = "+f[q1-1]);
            }
            System.out.println("\n    Decile");
            System.out.println("        d_k = (k/10(n+1))");
            System.out.println("        k = "+k);
            System.out.println("        n = "+n);
            qk=(k/10)*(n+1);
            System.out.println("        d_k = "+qk);
            q1=(int)qk;
            if(qk>q1){ //if does have decimals
                if(qk>=1){
                    double ave=(f[q1-1]+f[q1])/2.0;
                    System.out.println("        value in position = "+ave);
                }
            }
            else{
                System.out.println("        value in position = "+f[q1-1]);
            }
            System.out.println("\n    Percentile");
            System.out.println("        p_k = (k/100(n+1))");
            System.out.println("        k = "+k);
            System.out.println("        n = "+n);
            qk=(k/100)*(n+1);
            System.out.println("        p_k = "+qk);
            q1=(int)qk;
            if(qk>q1){ //if does have decimals
                if(qk>=1){
                    double ave=(f[q1-1]+f[q1])/2.0;
                    System.out.println("        value in position = "+ave);
                }
            }
            else{
                System.out.println("        value in position = "+f[q1-1]);
            }
        if(Interval==0){
            System.out.println("\nNO Group Data");
            System.exit(0);
        }
        System.out.println("\nGROUP DATA");
        System.out.println("********************************************************************");
        System.out.println("Class   |   f    |   <f   |   x    |  f(x)  |");
        int forF=1;
        double cf=0,x=0,fxtotal=0,ftotal=0,mean=0,arrX[]=new double[intNum],forCF[]=new double[intNum];
        for(int c3=0;c3<n*2;c3++){
            //for class interval
            System.out.print(CI[c3]);
            if(c3%2==0){
                System.out.print("-");
            }
            else if(c3%2==1){
            //for frequency
                
                if(CI[c3]<10){System.out.print("    ");}
                else if(CI[c3]<100){System.out.print("   ");}
                else if(CI[c3]<1000){System.out.print("  ");}
                System.out.print("| "+forGroup[c3-forF]);
                ftotal=ftotal+forGroup[c3-forF];
                if(forGroup[c3-forF]<10){System.out.print("    |");}
                else if(CI[c3]<100){System.out.print("   |");}
                else if(CI[c3]<1000){System.out.print("  |");}
            // for less than cf
                double y=forGroup[(c3-forF)];
                if(forGroup[c3-forF]==0){
                   x=forGroup[c3-forF];
                }
                cf=x+y;
                System.out.print(" "+cf);
                x=cf;
                forCF[c3-forF]=x;
                if(cf<10){System.out.print("    |");}
                else if(cf<100){System.out.print("   |");}
                else if(cf<1000){System.out.print("  |");}
                else if(cf<10000){System.out.print(" |");}
            //for midpoint or x
                double midP=0;
                midP=(CI[c3]+CI[c3-1])/2.0;
                System.out.print(" "+midP);
                arrX[c3-forF]=midP;
                if(midP<10){System.out.print("    |");}
                else if(midP<100){System.out.print("   |");}
                else if(midP<1000){System.out.print("  |");}
                else if(midP<10000){System.out.print(" |");}
            //for f*x
                double fx=0;
                fx=forGroup[c3-forF]*midP;
                System.out.print(" "+fx);
                fxtotal=fxtotal+fx;
                if(fx<10){System.out.print("    |");}
                else if(fx<100){System.out.print("   |");}
                else if(fx<1000){System.out.print("  |");}
                else if(fx<10000){System.out.print(" |");}
            //for mean
                mean=0;
                mean=fxtotal/ftotal;
                System.out.println("");
                forF++;
            }
        }
        System.out.println("\nmean = "+mean);
        System.out.println("x-mean:");
        double xm[]=new double[intNum];
        for(int c4=0;c4<n;c4++){
            System.out.println("  "+(arrX[c4]-mean));
            xm[c4]=(arrX[c4]-mean);
        }
        System.out.println("\n(x-m)^2:");
        double xmSQRD[]=new double[intNum],allxmSQRD=0;
        for(int c5=0;c5<n;c5++){
            System.out.println("  "+(xm[c5]*xm[c5]));
            xmSQRD[c5]=xm[c5]*xm[c5];
            allxmSQRD=allxmSQRD+xmSQRD[c5];
        }
        System.out.println("\nf(x-m)^2:");
        double fxmSQRD[]=new double[intNum], allFxmSQRD=0;
        for(int c6=0;c6<n;c6++){
            System.out.println("  "+forGroup[c6]*xmSQRD[c6]);
            fxmSQRD[c6]=forGroup[c6]*xmSQRD[c6];
            allFxmSQRD=allFxmSQRD+fxmSQRD[c6];
        }
        double midCF=0,midF=0,midCI_1=0,midCI_2=0,lowerCF=0;         //for quartile
        double midCF1=0,midF1=0,midCI_11=0,midCI_21=0,lowerCF1=0;    //for decile
        double midCF2=0,midF2=0,midCI_12=0,midCI_22=0,lowerCF2=0;    //for percentile
        double computedMidforQuartile=0,computedMidforDecile=0,computedMidforPercentile=0;
        computedMidforQuartile=(k*ftotal)/4.0;
        computedMidforDecile=(k*ftotal)/10.0;
        computedMidforPercentile=(k*ftotal)/100.0;
        forF=0;
        for(int c7=0;c7<n;c7++){
            if(forCF[c7]>computedMidforQuartile){
                midCF=forCF[c7];
                midF=forGroup[c7];
                midCI_1=CI[c7+forF];
                midCI_2=CI[(c7+forF)+1];
                if(computedMidforQuartile<forCF[0]){break;}     //to prevent -1 out of bound
                else{lowerCF=forCF[c7-1];}
                break;
            }
            forF++;
        }
        forF=0;
        for(int c8=0;c8<n;c8++){
            if(forCF[c8]>computedMidforDecile){
                midCF1=forCF[c8];
                midF1=forGroup[c8];
                midCI_11=CI[c8+forF];
                midCI_21=CI[(c8+forF)+1];
                if(computedMidforDecile<forCF[0]){break;}
                else{lowerCF1=forCF[c8-1];}
                break;
            }
            forF++;
        }
        forF=0;
        for(int c9=0;c9<n;c9++){
            if(forCF[c9]>computedMidforPercentile){
                midCF2=forCF[c9];
                midF2=forGroup[c9];
                midCI_12=CI[c9+forF];
                midCI_22=CI[(c9+forF)+1];
                if(computedMidforPercentile<forCF[0]){break;}
                else{lowerCF2=forCF[c9-1];}
                break;
            }
            forF++;
        }
        System.out.println("********************************************************************");
        System.out.println("\nE f(x):             "+fxtotal);
        System.out.println("E (x-mean)^2:       "+allxmSQRD);
        System.out.println("Sample Size(n):     "+ftotal);
        System.out.println("Variance:           "+(allxmSQRD/(ftotal-1)));
        System.out.println("Standard Deviation: "+Math.sqrt(allxmSQRD/(ftotal-1)));
        System.out.println("Class Interval (i): "+(CI[2]-CI[0])+"\n");
        System.out.println("    computed mid   Q:    "+computedMidforQuartile);
        System.out.println("    lower <cf      Q:    "+lowerCF);
        System.out.println("    mid <cf        Q:    "+midCF);
        System.out.println("    mid frequency  Q:    "+midF);
        System.out.println("    mid class      Q:    "+midCI_1+" - "+midCI_2);
        System.out.println("    Quartile"+(int)k+":         "+((midCI_1-0.5)+((((k*ftotal)/4.0)-lowerCF)/midF)*5.0)+"\n");
        
        System.out.println("    computed mid   D:    "+computedMidforDecile);
        System.out.println("    lower <cf      D:    "+lowerCF1);
        System.out.println("    mid <cf        D:    "+midCF1);
        System.out.println("    mid frequency  D:    "+midF1);
        System.out.println("    mid class      D:    "+midCI_11+" - "+midCI_21);
        System.out.println("    Decile"+(int)k+":           "+((midCI_11-0.5)+((((k*ftotal)/10.0)-lowerCF1)/midF1)*5.0)+"\n");
        
        System.out.println("    computed mid   P:    "+computedMidforPercentile);
        System.out.println("    lower <cf      P:    "+lowerCF2);
        System.out.println("    mid <cf        P:    "+midCF2);
        System.out.println("    mid frequency  P:    "+midF2);
        System.out.println("    mid class      P:    "+midCI_12+" - "+midCI_22);
        System.out.println("    Percentile"+(int)k+":       "+((midCI_12-0.5)+((((k*ftotal)/100.0)-lowerCF2)/midF2)*5.0)+"\n");
        
    }
}
/*

Not working!
but almost

*/