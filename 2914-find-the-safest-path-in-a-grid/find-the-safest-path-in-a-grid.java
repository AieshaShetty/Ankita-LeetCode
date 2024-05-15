class Solution {
    int[][] directions = {{0,1}, {1,0},{0,-1}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        int[][] mat = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new ArrayDeque();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                mat[i][j] = grid.get(i).get(j); 
                if(mat[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                } 
            }
        }       

        if(mat[0][0] == 1 || mat[rows-1][cols-1] == 1) return 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] current = q.poll();
                int curX = current[0], curY = current[1], distance = current[2];
                mat[curX][curY] = distance;
                for(int i = 0; i < 4; i++) {
                    int nx = curX + directions[i][0];
                    int ny = curY + directions[i][1];

                    if(isValidBound(visited, nx, ny)) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, distance + 1});
                    }
                }
                size--;
            }
        }

        int low = 0, high = Integer.MAX_VALUE;
        int ans = 0;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(canReachSafely(mid, mat)) 
            {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }

        return ans;
    }

    private boolean canReachSafely(int threshold, int[][] mat) {
        if(mat[0][0] < threshold) return false;
        Queue<int[]> q = new ArrayDeque();
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];

        visited[0][0] = true;
        q.add(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0], cy = current[1]; 

            if(cx == mat.length - 1 && cy == mat[0].length - 1) return true;

            for(int k = 0; k < 4; k++) {
                int nx = cx + directions[k][0];
                int ny = cy + directions[k][1];

                if(isValidBound(visited, nx, ny)) {
                    if(mat[nx][ny] < threshold) continue;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }


    private boolean isValidBound(boolean[][] visited, int x, int y) {
        return x < visited.length && y < visited[0].length && x >= 0 && y >= 0 && !visited[x][y];
    }
}