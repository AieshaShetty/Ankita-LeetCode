class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(amount);
        visited.add(amount);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int currentAmount = queue.poll();
                for (int coin : coins) {
                    int nextAmount = currentAmount - coin;
                    if (nextAmount == 0) {
                        return level;
                    }
                    if (nextAmount > 0 && !visited.contains(nextAmount)) {
                        queue.offer(nextAmount);
                        visited.add(nextAmount);
                    }
                }
            }
        }
        return -1;
    }
}
