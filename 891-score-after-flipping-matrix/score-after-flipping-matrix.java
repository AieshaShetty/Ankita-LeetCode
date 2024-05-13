class Solution {
    public int matrixScore(int[][] grid) {
        final int rowCount = grid.length;
        final int colCount = grid[0].length;
        int score = 0;
        for (int col = colCount - 1; col >= 0; col--) {
            int colSum = 0;
            //bottom to top
            for (int row = rowCount - 1; row >= 0; row--){
                /*Count the number of matching bits in the column
                 with the bit in column 0 of the row*/    
                if (grid[row][col] == grid[row][0])
                    colSum++;
            }
            
            /* Choose the maximum between the column sum and 
             the complement of the column sum, and add it to 
             the total score shifted into the correct bit position
             */
            score += Math.max(colSum, rowCount - colSum) << (colCount - col - 1);
        }
        return score;
    }
}
