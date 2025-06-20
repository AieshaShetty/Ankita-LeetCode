class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;
        int[] dist = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'N') y++;
            else if (ch == 'S') y--;
            else if (ch == 'E') x++;
            else if (ch == 'W') x--;
            dist[i] = Math.abs(x) + Math.abs(y);
        }

        int n = dist.length;
        int i = 1;
        int count = 0;
        int maxDist = dist.length > 1 ? dist[1] : dist[0];
        int prev = dist[0];

        if (k == 0) {
            int maxVal = 0;
            for (int d : dist) {
                maxVal = Math.max(maxVal, d);
            }
            return maxVal;
        }

        while (i < n) {
            if (dist[i] < prev && k > 0) {
                count += 2;
                k--;
            }
            prev = dist[i];
            dist[i] += count;
            maxDist = Math.max(maxDist, dist[i]);
            i++;
        }
        return maxDist;
    }
}
