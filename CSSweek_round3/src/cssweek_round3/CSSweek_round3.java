package cssweek_round3;
public class CSSweek_round3 {
    public static void main(String[] args) {
        int case1[][]={{0, 1, 0, 0, 0},
                       {0, 1, 0, 1, 0},
                       {0, 0, 0, 1, 0}};
        
        int case2[][]={{0, 1, 1},
                       {1, 1, 0},
                       {1, 1, 0}};
        
        int case3[][]={{0, 0, 0},
                       {0, 1, 0},
                       {0, 1, 1},
                       {1, 1, 0},
                       {1, 1, 0},
                       {0, 1, 0}};
        
        System.out.println("output = "+solution(case1));//output 0
        System.out.println("output = "+solution(case2));//output 2
        System.out.println("output = "+solution(case3));//output 1
    }
    public static int solution(int [][]grid){
        int leastBlock=100;
        int tempCount=0, tempCount1=0;
        for(int count1=0; count1<grid.length; count1++){
            for(int count2=0; count2<grid[count1].length; count2++){
                if(grid[count1][count2]==1){
                    tempCount++;
                }
            }
            if(tempCount!=0 && tempCount<leastBlock){
                leastBlock=tempCount;
            }
        }
        return leastBlock;
    }
}
