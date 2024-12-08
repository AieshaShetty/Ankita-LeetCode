class Solution {
    private int bsearch(int[][] events, int low, int high, int curr){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(events[mid][0] <= events[curr][1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int res = 0;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int[] maxSuffix = new int[n];
        maxSuffix[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(events[i][2], maxSuffix[i + 1]);
        }

        for(int i = 0;i < n;i++){
            int curr = events[i][2];
            int low = bsearch(events, i, n - 1, i);
            if (low < n) {
                curr += maxSuffix[low];
            }
            res = Math.max(curr, res);
        }

        return res;
    }
}