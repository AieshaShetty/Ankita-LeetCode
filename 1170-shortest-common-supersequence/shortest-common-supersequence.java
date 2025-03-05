class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        if (m < n) return shortestCommonSupersequence(str2, str1);
        String[][] dp = new String[2][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m) dp[i & 1][j] = str2.substring(j);
                else if (j == n) dp[i & 1][j] = str1.substring(i);
                else if (str1.charAt(i) == str2.charAt(j))
                    dp[i & 1][j] = str1.charAt(i) + dp[(i + 1) & 1][j + 1];
                else if (dp[i & 1][j + 1].length() < dp[(i + 1) & 1][j].length())
                    dp[i & 1][j] = str2.charAt(j) + dp[i & 1][j + 1];
                else dp[i & 1][j] = str1.charAt(i) + dp[(i + 1) & 1][j];
            }
        }
        return dp[0][0];
    }
}