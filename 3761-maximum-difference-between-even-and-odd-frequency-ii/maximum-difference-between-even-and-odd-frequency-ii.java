class Solution {

    public int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;

        // Frequency count for digits '0' to '4'
        int[] digitFreq = new int[5];
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '4') {
                digitFreq[c - '0']++;
            }
        }

        // Try all combinations of two different digits
        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b || digitFreq[a - '0'] == 0 || digitFreq[b - '0'] == 0) {
                    continue;
                }

                maxDiff = Math.max(maxDiff, calculateDifference(s, k, a, b));
            }
        }

        return maxDiff;
    }

    private int calculateDifference(String s, int k, char a, char b) {
        int n = s.length();
        int[] minPrefix = new int[4];
        Arrays.fill(minPrefix, Integer.MAX_VALUE);

        int countA = 0, countB = 0;
        int removedA = 0, removedB = 0;
        int left = -1, bestDiff = Integer.MIN_VALUE;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == a) countA++;
            if (s.charAt(right) == b) countB++;

            // Maintain window of at least k with at least 2 of b
            while ((right - left) >= k && (countB - removedB) >= 2) {
                int status = getParityStatus(removedA, removedB);
                minPrefix[status] = Math.min(minPrefix[status], removedA - removedB);

                left++;
                if (s.charAt(left) == a) removedA++;
                if (s.charAt(left) == b) removedB++;
            }

            int currStatus = getParityStatus(countA, countB);
            int neededStatus = currStatus ^ 0b10; // Flip A's parity

            if (minPrefix[neededStatus] != Integer.MAX_VALUE) {
                int currentDiff = (countA - countB) - minPrefix[neededStatus];
                bestDiff = Math.max(bestDiff, currentDiff);
            }
        }

        return bestDiff;
    }

    private int getParityStatus(int aCount, int bCount) {
        return ((aCount & 1) << 1) | (bCount & 1);
    }
}
