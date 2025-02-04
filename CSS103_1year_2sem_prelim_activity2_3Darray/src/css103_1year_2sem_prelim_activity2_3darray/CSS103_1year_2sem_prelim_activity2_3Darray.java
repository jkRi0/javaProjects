package css103_1year_2sem_prelim_activity2_3darray;
import java.util.Scanner;
public class CSS103_1year_2sem_prelim_activity2_3Darray {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the layer size: ");
        int layerSize=input.nextInt();
        
        //TO GET THE SIZES FOR EACH ROW
        int rowSize=0, sizeTemporary=0;
        int arrayForRow[]=new int[layerSize];
        for(int count1=0; count1<layerSize; count1++){
            System.out.print("Enter the row size of Layer "+count1+": ");
            sizeTemporary=input.nextInt();
            rowSize = rowSize + sizeTemporary;  //USE FOR 3D ARRAY ROW SIZE
            arrayForRow[count1]=sizeTemporary;  //THE SIZES WILL BE ELEMENT OF AN 1D ARRAY
        }
        
        //TO GET THE SIZES FOR EACH COLUMN
        int columnSize=0, sizeTemporary2=0;
        int arrayForColumn[][]=new int[layerSize][rowSize];   
        for(int count1=0; count1<layerSize; count1++){
            for(int count2=0; count2<arrayForRow[count1]; count2++){
                System.out.print("Enter the column size of Layer "+count1+" Row "+count2+": ");
                sizeTemporary2=input.nextInt();
                columnSize = columnSize + sizeTemporary2;       //USE FOR 3D ARRAY COLUMN SIZE
                arrayForColumn[count1][count2]=sizeTemporary2;  //THE SIZES WILL BE ELEMENT OF AN 2D ARRAY
            }
        }
        
        //CREATING THE 3D ARRAY
        double arr3D[][][]=new double[layerSize][rowSize][columnSize];
        for(int count1=0; count1<layerSize; count1++){
            //THE LENGTH OF EACH 3D ARRAY TABLE WILL BE THE VALUE OF LAYER SIZE
            System.out.println("Value for Layer "+count1+": ");
            for(int count2=0; count2<arrayForRow[count1]; count2++){
                //THE LENGTH OF EACH 3D ARRAY ROW WILL BE THE ELEMENTS INSIDE THE PREVIOUS 1D ARRAY
                System.out.println("Enter values for Row "+count2+": ");
                for(int count3=0; count3<arrayForColumn[count1][count2]; count3++){
                    //THE LENGTH OF EACH 3D ARRAY COLUMN WILL BE THE ELEMENTS INSIDE THE PREVIOUS 2D ARRAY
                    arr3D[count1][count2][count3]=input.nextDouble();
                }
                System.out.println("");
            }
            System.out.println("");
        }
        
        //PRINTING THE 3D ARRAY
        System.out.println("Values of the 3D Array");
        for(int count1=0; count1<layerSize; count1++){
            System.out.println("Layer "+count1+" Elements: ");
            for(int count2=0; count2<arrayForRow[count1]; count2++){
                for(int count3=0; count3<arrayForColumn[count1][count2]; count3++){
                    System.out.print(arr3D[count1][count2][count3]+"\t");
                }
                System.out.println("");
            }
        }
    }
}