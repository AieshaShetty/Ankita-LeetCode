class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<>();
        int c = 1;
        for (int i = 0; i < n; i++) {
            l.add(c);
            if (c * 10 <= n) {
                c *= 10;
            } else {
                while (c % 10 == 9 || c >= n) {
                    c /= 10;
                }
                c++;
            }
        }
        return l;
    }
}