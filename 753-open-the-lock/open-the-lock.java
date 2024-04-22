class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String current = q.poll();

                if (current.equals(target)) return moves;

                for (int j = 0; j < 4; ++j) {
                    for (int d = -1; d <= 1; d += 2) {
                        char[] next = current.toCharArray();
                        next[j] = (char) (((next[j] - '0' + d + 10) % 10) + '0');
                        String nextStr = new String(next);

                        if (!visited.contains(nextStr) && !dead.contains(nextStr)) {
                            q.offer(nextStr);
                            visited.add(nextStr);
                        }
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}