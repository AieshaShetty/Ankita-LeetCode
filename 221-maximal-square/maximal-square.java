class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m + 1][n + 1];
        int maxL = 0;
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = 1 + Math.min(Math.min(dp[row + 1][col], dp[row + 1][col + 1]), dp[row][col + 1]);
                    maxL = Math.max(dp[row][col], maxL);
                }
            }
        }
        return maxL * maxL;
    }
}