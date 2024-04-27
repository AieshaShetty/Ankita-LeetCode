class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        if (grid == null) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        if (n <= 1 || m <= 1) return 0;
        
        long ans = 0;
        
        // Use a map to store the count of occurrences of 1 in each row and each column
        Map<Integer, Integer> rowCount = new HashMap<>();
        Map<Integer, Integer> colCount = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Increment row count for current row i
                    rowCount.put(i, rowCount.getOrDefault(i, 0) + 1);
                    // Increment column count for current column j
                    colCount.put(j, colCount.getOrDefault(j, 0) + 1);
                }
            }
        }
        
        // Iterate through the grid again to find right triangles
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Count right triangles with (i, j) as the right angle
                    ans += (rowCount.getOrDefault(i, 0) - 1) * (colCount.getOrDefault(j, 0) - 1);
                }
            }
        }
        
        return ans;
    }
}
