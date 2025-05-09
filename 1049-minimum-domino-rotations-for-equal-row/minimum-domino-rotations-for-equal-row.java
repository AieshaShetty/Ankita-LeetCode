class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] upCnt = new int[7];
        int[] downCnt = new int[7];
        int[] dupCnt = new int[7];
        int n = tops.length;

        for (int i = 0; i < n; i++) {
            int top = tops[i], bottom = bottoms[i];
            if (top == bottom) {
                dupCnt[top]++;
            } else {
                upCnt[top]++;
                downCnt[bottom]++;
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (upCnt[i] + downCnt[i] + dupCnt[i] == n) {
                return Math.min(upCnt[i], downCnt[i]);
            }
        }

        return -1;
    }
}
