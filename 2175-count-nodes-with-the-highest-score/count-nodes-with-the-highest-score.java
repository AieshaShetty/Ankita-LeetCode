class Solution {
    private long[] dp;
    
    private void dfs(int node, List<List<Integer>> tree){
        dp[node]=1;
        for(int child: tree.get(node)){
            dfs(child,tree);
            dp[node]+=dp[child];
        }
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        List<List<Integer>> tree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            tree.get(parents[i]).add(i);
        }
        dp = new long[n];
        dfs(0, tree);
        long maxScore = 0;
        Map<Long, Long> scoreCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long totalNodes = dp[0];
            long product = 1;
            long upperPart = totalNodes - dp[i];
            if (upperPart == 0) upperPart = 1;
            long downward = 1;
            product *= upperPart;
            for (int child : tree.get(i)) {
                downward *= dp[child];
            }
            product *= downward;
            scoreCount.put(product, scoreCount.getOrDefault(product, 0L) + 1);
        }
        maxScore = 0;
        for (Map.Entry<Long, Long> entry : scoreCount.entrySet()) {
            if (entry.getKey() > maxScore) {
                maxScore = entry.getKey();
            }
        }
        return scoreCount.get(maxScore).intValue();
    }
}
