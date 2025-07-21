class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean tflag=false,mflag=true;
        int max=-999;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target) tflag=true;
                if(matrix[i][j]<max){
                   mflag=false;
                   break; 
                }
                max=matrix[i][j];
            }
        }
        if(tflag&&mflag) return true;
        return false;
    }
}