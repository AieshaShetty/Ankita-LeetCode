class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        
        for(int i = 0;i< m;i++){
            for(int j = 0;j< n;j++){
                if(land[i][j] == 1 && (i == 0 || land[i-1][j] == 0) && (j == 0 || land[i][j-1] == 0)){
                    int row = i,col = j;
                    while(row < m && land[row][j] == 1)row++;
                    while(col < n && land[i][col] == 1)col++;
                    res.add(new int[]{i,j,row-1,col-1});
                }
            }
        }
        
        int[][] result = new int[res.size()][4];
        for(int i = 0;i< result.length;i++)result[i] = res.get(i);
        return result;
    }
}