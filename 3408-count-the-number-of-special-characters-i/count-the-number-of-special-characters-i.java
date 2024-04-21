import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (char nx : word.toCharArray()) {
            if ('A' <= nx && nx <= 'Z') {
                mp.put(nx - 'A', mp.getOrDefault(nx - 'A', 0) | 1);
            } else {
                mp.put(nx - 'a', mp.getOrDefault(nx - 'a', 0) | 2);
            }
        }
        int res = 0;
        for (int nx : mp.values()) {
            if (nx == 3) {
                res++;
            }
        }
        return res;
    }
}
