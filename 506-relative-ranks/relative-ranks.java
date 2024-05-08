class Solution {
   public static String[] findRelativeRanks(int[] score) {
        // Create a priority queue to store scores and their positions
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // Insert scores and their positions into the priority queue
        for (int i = 0; i < score.length; i++) {
            pq.offer(new int[]{score[i], i});
        }
        
        // Initialize the result array
        String[] ans = new String[score.length];
        
        // Assign ranks
        int counter = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (counter == 0) {
                ans[current[1]] = "Gold Medal";
            } else if (counter == 1) {
                ans[current[1]] = "Silver Medal";
            } else if (counter == 2) {
                ans[current[1]] = "Bronze Medal";
            } else {
                ans[current[1]] = String.valueOf(counter + 1);
            }
            counter++;
        }
        
        return ans;
    }
}