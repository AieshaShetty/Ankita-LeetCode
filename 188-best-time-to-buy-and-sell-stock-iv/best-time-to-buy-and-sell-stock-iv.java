class Solution {
    public int maxProfit(int k, int[] prices) {int n=prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
       
        
       
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][0][cap],dp[ind + 1][1][cap]);
                    } else { 
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][0][cap],
                                prices[ind] + dp[ind + 1][1][cap - 1]);
                    }
                }
            }
        }
        
        return dp[0][1][k];
    }
}