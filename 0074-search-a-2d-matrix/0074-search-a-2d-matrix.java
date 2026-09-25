class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top=0;
        int bot =rows-1;
        int row=0;
        while(top<=bot){
            row=(top+bot)/2;
            if(target>matrix[row][cols - 1]){
                top=row+1;
            }
            else if(target<matrix[row][0]){
                bot=row-1;
            }
            else{
                break;
            }
        }
        if(!(top<=bot)){
            return false;
        }
        int start=0;
        int end=cols-1;
        while(start<=end){
            int col=(start+end)/2;
            if(target>matrix[row][col]){
                start=col+1;
            }
            else if(target<matrix[row][col]){
                end=col-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}