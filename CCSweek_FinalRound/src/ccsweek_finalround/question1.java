package ccsweek_finalround;
public class question1 {
    public static void main(String[] args) {
        int case1=123;
        int case2=12345;
        int case3=1234567;
        solution(case1);
        System.out.println(solution(case1)); //output english representation
        System.out.println(solution(case2));
        System.out.println(solution(case3));
    }
    public static String solution(int theNum){
        String writtenNum[][]={{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"},
                          {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen",},
                          {"Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety",},
                          {"Hundred","Thousand","Million","Billion"}};
        
        String Str=Integer.toString(theNum);
        int length=Str.length();
        String theWord="";
        String tempWord="";
        
        if(theNum<0){
            System.out.println("The Integer are can not be accepted, because it has negative Integer");
        }
        else if(theNum<10){
            theWord=writtenNum[0][theNum];
            
        }
        
        else if(theNum<20){
            if(theNum==10){
                theWord=writtenNum[2][0];
            }
            else{
                int secondNum=theNum-11;
                theWord=writtenNum[1][secondNum];
            }
        }
        else if(theNum<100){
            for(int count1=0;count1<2;count1++){
                if(count1==0){
                    char index=Str.charAt(0);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[2][index2-1]+" ";
                    theWord=theWord.concat(tempWord);
                }
                else{
                    char index=Str.charAt(1);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[0][index2];
                    if(index2!=0){
                        theWord=theWord.concat(tempWord);
                    }
                }
            }
        }
        else if(theNum<1000){
            for(int count1=0;count1<3;count1++){
                if(count1==0){
                    char index=Str.charAt(0);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[0][index2]+" Hundred ";
                    theWord=theWord.concat(tempWord);
                }
                if(count1==1){
                    char index=Str.charAt(1);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[2][index2-1]+" ";
                    theWord=theWord.concat(tempWord);
                }
                else if(count1==2){
                    char index=Str.charAt(2);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[0][index2];
                    if(index2!=0){
                        theWord=theWord.concat(tempWord);
                    }
                }
            }
        }
        else if(theNum<100000){
            for(int count1=0;count1<6;count1++){
                if(theNum==10){
                    theWord=writtenNum[2][0];
                }
                else{
                    int secondNum=theNum-11;
                    theWord=writtenNum[1][secondNum];
                }
                if(count1==0){
                    char index=Str.charAt(0);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[0][index2]+" Hundred ";
                    theWord=theWord.concat(tempWord);
                }
                if(count1==1){
                    char index=Str.charAt(1);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[2][index2-1]+" ";
                    theWord=theWord.concat(tempWord);
                }
                else if(count1==2){
                    char index=Str.charAt(2);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[0][index2];
                    if(index2!=0){
                        theWord=theWord.concat(tempWord);
                    }
                }
                if(count1==3){
                    char index=Str.charAt(0);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[0][index2]+" Hundred ";
                    theWord=theWord.concat(tempWord);
                }
                if(count1==4){
                    char index=Str.charAt(1);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[2][index2-1]+" ";
                    theWord=theWord.concat(tempWord);
                }
                else if(count1==5){
                    char index=Str.charAt(2);
                    String index1=Character.toString(index);
                    int index2=Integer.parseInt(index1);
                    tempWord=writtenNum[0][index2];
                    if(index2!=0){
                        theWord=theWord.concat(tempWord);
                    }
                }
            }
        }
        else if(theNum<1000000000){
            
        }
        else{
            
        }
        
        
        return theWord;
    }
}
/*
        for(int count1=0; count1<4; count1++){
            for(int count2=0; count2<32; count2++){
                if(theNum==count2){
                    System.out.println(count2);
                    theWord=writtenNum[count1][count2];
                    break;
                }
            }
        }
        return theWord;*/
