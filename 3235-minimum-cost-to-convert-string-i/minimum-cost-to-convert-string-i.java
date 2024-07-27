class Solution {
    private int[][] D = new int[26][26];

    private void FW(char[] original, char[] changed, int[] cost) {
        for (int[] row : D) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int sz = original.length;
        for (int i = 0; i < sz; i++) {
            int row = original[i] - 'a';
            int col = changed[i] - 'a';
            D[row][col] = Math.min(D[row][col], cost[i]);
        }
        for (int i = 0; i < 26; i++) {
            D[i][i] = 0;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (D[i][k] < Integer.MAX_VALUE && D[k][j] < Integer.MAX_VALUE) {
                        D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                    }
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        FW(original, changed, cost);

        int n = source.length();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int row = source.charAt(i) - 'a';
            int col = target.charAt(i) - 'a';
            if (D[row][col] == Integer.MAX_VALUE) {
                return -1; 
            }
            ans += D[row][col];
        }

        return ans;
    }
}
