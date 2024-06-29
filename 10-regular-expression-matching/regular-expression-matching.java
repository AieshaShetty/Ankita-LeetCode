import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Boolean> memo;

    public boolean isMatch(String s, String p) {
        memo = new HashMap<>();
        return isMatch(0, s, 0, p);
    }

    private boolean isMatch(int i, String s, int j, String p) { 
        int sn = s.length(), pn = p.length();
        String key = i + "," + j;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (j == pn) { 
            return i == sn;    
        }

        char pj = p.charAt(j);
        boolean match = (i < sn && (s.charAt(i) == pj || pj == '.'));

        if (j + 1 < pn && p.charAt(j + 1) == '*') { 
            boolean result = (isMatch(i, s, j + 2, p) || (match && isMatch(i + 1, s, j, p)));
            memo.put(key, result);
            return result;
        } else if (match) {              
            boolean result = isMatch(i + 1, s, j + 1, p);
            memo.put(key, result);
            return result;
        }

        memo.put(key, false);
        return false;
    }
}
