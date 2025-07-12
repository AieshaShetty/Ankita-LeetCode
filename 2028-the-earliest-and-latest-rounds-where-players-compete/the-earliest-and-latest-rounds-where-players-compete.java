class Solution {

    private static final class Result {
        int min = 255;
        int max = 0;
        boolean initialized = false;
    }

    private static final Result[][][] memo = new Result[29][30][30];

    static {
        for (int n = 0; n < 29; n++) {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    memo[n][i][j] = new Result();
                }
            }
        }

        for (int n = 2; n < 29; n++) {
            int half = n / 2;
            for (int i = 0; i < half; i++) {
                memo[n][i][n - i - 1].min = 1;
                memo[n][i][n - i - 1].max = 1;
                memo[n][i][n - i - 1].initialized = true;
            }
        }
    }

    private static int reverse16Bits(int x) {
        x = ((x & 0xAAAA) >>> 1) | ((x & 0x5555) << 1);
        x = ((x & 0xCCCC) >>> 2) | ((x & 0x3333) << 2);
        x = ((x & 0xF0F0) >>> 4) | ((x & 0x0F0F) << 4);
        x = ((x & 0xFF00) >>> 8) | ((x & 0x00FF) << 8);
        return x & 0xFFFF;
    }

    private static int reverseInverseKLsb(int x, int k) {
        int reversed = reverse16Bits(x);
        int inverse = ~reversed & 0xFFFF;
        return inverse >>> (16 - k);
    }

    private static Result dfs(int n, int a, int b) {
        if (memo[n][a][b].initialized) return memo[n][a][b];

        Result result = memo[n][a][b];
        result.initialized = true;

        int half = n / 2;
        int winnersCount = half + (n % 2);
        int midMask = (1 << half) * (n % 2);
        int matchLimit = 1 << half;

        for (int w = 0; w < matchLimit; w++) {
            int revK = reverseInverseKLsb(w, half);
            int winners = (revK << winnersCount) | midMask | w;

            if (((winners & (1 << a)) != 0) && ((winners & (1 << b)) != 0)) {
                int winnersBeforeA = Integer.bitCount(winners & ((1 << a) - 1));
                int winnersBeforeB = Integer.bitCount(winners & ((1 << b) - 1));

                Result next = dfs(winnersCount, winnersBeforeA, winnersBeforeB);

                result.min = Math.min(result.min, next.min + 1);
                result.max = Math.max(result.max, next.max + 1);
            }
        }

        return result;
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int a = firstPlayer - 1;
        int b = secondPlayer - 1;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        Result res = dfs(n, a, b);
        return new int[]{res.min, res.max};
    }
}
