class Solution {
    public int numRabbits(int[] answers) {
        int[] freq = new int[1001];
        int cnt = 0;

        for (int x : answers) {
            if (freq[x] % (x + 1) == 0) {
                cnt += (x + 1);
            }
            freq[x]++;
        }

        return cnt;
    }
}
