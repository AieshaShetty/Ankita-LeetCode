class Solution {
      private final int MOD = 1_000_000_000 + 7;
      public int countPaths(int n, int[][] roads) {
        if (n == 1) {
            return 1;
        }
        long[][] d = new long[n][n];
        int[][] c = new int[n][n];
        for (long[] dd: d) {
            Arrays.fill(dd, Long.MAX_VALUE);
        }
        for (int[] road: roads) {
            d[road[0]][road[1]] = d[road[1]][road[0]] = road[2];
            c[road[0]][road[1]] = c[road[1]][road[0]] = 1;
        }
        for (int k = 0; k < n; ++k) 
            for (int i = 0; i < n; ++i) 
                for (int j = 0; j < n; ++j) {
                    if (d[i][k] == Long.MAX_VALUE || d[k][j] == Long.MAX_VALUE) {
                        continue;
                    }
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        c[i][j] = c[i][k] * c[k][j] % MOD;
                    } else if (d[i][j] == d[i][k] + d[k][j]) {
                        c[i][j] = (c[i][j] + c[i][k] * c[k][j] % MOD) % MOD;
                    }
                }
        return c[0][n - 1];
    }
	
}
