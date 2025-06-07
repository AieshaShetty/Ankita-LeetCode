class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        Set<Integer> remove = new HashSet<Integer>();
        int n = s.length();
        char[] sChar = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (sChar[i] == '*') {
                int[] el = q.poll();
                remove.add(el[1]);
                remove.add(i);
            } else {
                q.add(new int[] {sChar[i], i});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (remove.contains(i)) {
                continue;
            }
            sb.append(sChar[i]);
        }
        return sb.toString();
    }
}