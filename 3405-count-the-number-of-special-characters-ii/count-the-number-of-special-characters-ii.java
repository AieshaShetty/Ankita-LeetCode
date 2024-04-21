class Solution {
    public int numberOfSpecialChars(String word) {
        List<List<Integer>> v = new ArrayList<>(256);
        for (int i = 0; i < 256; i++) {
            v.add(new ArrayList<>());
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            v.get(ch).add(i);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            int x = 'a' + i;
            int y = 'A' + i;
            if (v.get(x).isEmpty()) {
                continue;
            }
            if (v.get(y).isEmpty()) {
                continue;
            }
            if (v.get(x).get(v.get(x).size() - 1) < v.get(y).get(0)) {
                res++;
            }
        }
        return res;
    }
}
