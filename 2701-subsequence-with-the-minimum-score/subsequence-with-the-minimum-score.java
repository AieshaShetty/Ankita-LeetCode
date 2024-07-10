class Solution {
    public int minimumScore(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] f = new int[n];
        int[] b = new int[n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < m && s.charAt(i) == t.charAt(j)) {
                j++;
            }
            f[i] = j;
        }

        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && s.charAt(i) == t.charAt(j)) {
                j--;
            }
            b[i] = m - j - 1;
        }

        int ans = Math.min(m - f[n - 1], m - b[0]);
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, m - f[i - 1] - b[i]);
        }
        return Math.max(ans, 0);
    }
}
