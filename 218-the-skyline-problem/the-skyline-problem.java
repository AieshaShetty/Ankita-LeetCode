class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();     
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]}); // Start of a building
            height.add(new int[]{b[1], b[2]});  // End of a building
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]); // Add the height of the building
            } else {
                pq.remove(h[1]); // Remove the height of the building
            }
            int curr = pq.peek();
            if (prev != curr) {
                result.add(Arrays.asList(h[0], curr));
                prev = curr;
            }
        }
        return result;
    }
}
