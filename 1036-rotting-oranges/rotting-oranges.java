class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q1 = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int counter = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q1.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    counter = 1;
                    set.add(i + " " + j);
                }
            }
        }
        if (counter == 0) {
            return 0;
        }
        int time = 0;
        while (!q1.isEmpty()) {
            time++;
            int size = q1.size();
            for(int i=0; i<size; i++) {
                int[] cur = q1.remove();
                int x = cur[0];
                int y = cur[1];

                if (isSafe(x-1, y, grid.length, grid[0].length) && grid[x-1][y] == 1) {
                    int val = x-1;
                    String str = val + " " + y;
                    set.remove(str);
                    grid[x-1][y] = 2;
                    q1.add(new int[]{x-1, y});
                }
                if (isSafe(x+1, y, grid.length, grid[0].length) && grid[x+1][y] == 1) {
                    int val = x+1;
                    String str = val + " " + y;
                    set.remove(str);
                    grid[x+1][y] = 2;
                    q1.add(new int[]{x+1, y});
                }
                if (isSafe(x, y-1, grid.length, grid[0].length) && grid[x][y-1] == 1) {
                    int val = y-1;
                    String str = x + " " + val;
                    set.remove(str);
                    grid[x][y-1] = 2;
                    q1.add(new int[]{x, y-1});
                }
                if (isSafe(x, y+1, grid.length, grid[0].length) && grid[x][y+1] == 1) {
                    int val = y+1;
                    String str = x + " " + val;
                    set.remove(str);
                    grid[x][y+1] = 2;
                    q1.add(new int[]{x, y+1});
                }
            }
        }

        return set.size() == 0 ? time-1 : -1;
    }

    public boolean isSafe(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}