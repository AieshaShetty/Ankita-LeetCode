import java.util.Arrays;

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int n = zero + one;
        
        final int MOD = 1000000007;
        
        int[][] dp0 = new int[n + 1][n + 1];
        int[][] dp1 = new int[n + 1][n + 1];
        
        dp0[0][0] = dp1[0][0] = 1;
        dp0[1][1] = 1;
        dp1[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                {
                    int x = 0;
                    if (j >= 1) x = (x + dp0[i - 1][j - 1]) % MOD;
                    if (j >= 1) x = (x + dp1[i - 1][j - 1]) % MOD;
                    if (j >= limit + 1) x = (x - dp1[i - limit - 1][j - limit - 1] + MOD) % MOD;
                    dp0[i][j] = x;
                }
                {
                    int x = 0;
                    x = (x + dp0[i - 1][j]) % MOD;
                    x = (x + dp1[i - 1][j]) % MOD;
                    if (i >= limit + 1) x = (x - dp0[i - limit - 1][j] + MOD) % MOD;
                    dp1[i][j] = x;
                }
            }
        }
        
        int ans = (dp0[n][zero] + dp1[n][zero]) % MOD;
        return ans < 0 ? ans + MOD : ans;
    }

    
}
