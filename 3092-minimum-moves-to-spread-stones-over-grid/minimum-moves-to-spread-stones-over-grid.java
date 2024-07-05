class Solution {
    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int minimumMoves(int[][] grid) {
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    a.add(new int[]{i, j});
                }
                if (grid[i][j] == 0) {
                    b.add(new int[]{i, j});
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        do {
            int total = 0;
            int i = 0;
            for (int[] p : a) {
                int cur = grid[p[0]][p[1]];
                while (cur > 1) {
                    total += distance(p, b.get(i++));
                    cur--;
                }
            }
            ans = Math.min(ans, total);
        } while (nextPermutation(b));

        return ans;
    }

    private boolean nextPermutation(List<int[]> b) {
        int k = -1;
        for (int i = b.size() - 2; i >= 0; i--) {
            if (compare(b.get(i), b.get(i + 1)) < 0) {
                k = i;
                break;
            }
        }
        if (k == -1) return false;

        int l = -1;
        for (int i = b.size() - 1; i > k; i--) {
            if (compare(b.get(k), b.get(i)) < 0) {
                l = i;
                break;
            }
        }

        Collections.swap(b, k, l);

        Collections.reverse(b.subList(k + 1, b.size()));
        return true;
    }

    private int compare(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        } else {
            return Integer.compare(a[1], b[1]);
        }
    }
}
