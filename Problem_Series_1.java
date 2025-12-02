package DSA_Series;

public class Problem_Series_1 {

    public static  int largestRectangle(int[][] array){
        int maxArea=0;
        int rows=array.length;
        int columns=array[0].length;

        for(int row1=0;row1<rows;row1++){

            for(int column1=0;column1<columns;column1++){

                if(array[row1][column1]==1){

                    for(int row2=row1;row2<rows;row2++){

                        for (int column2=column1;column2<columns;column2++){

                          if(check(array,row1,row2,column1,column2)){
                              int area=(row2-row1+1)*(column2-column1+1);
                              maxArea=Math.max(area,maxArea);
                          }

                        }

                    }

                }
            }
        }


        return maxArea;
    }

    public static boolean check(int[][] array , int row1,int row2,int column1,int column2){

        for(int r=row1;r<=row2;r++){
            for(int c=column1;c<=column2;c++){
                    if(array[r][c]==0){
                        return false;
                    }
            }
        }

        return true;
    }


    static void main(String[] args) {

         int[][] array= {
                 {1,0,0,0},
                 {1,0,1,1},
                 {1,0,1,1},
                 {0,1,0,0}
         };
        System.out.println(largestRectangle(array));
    }


}
