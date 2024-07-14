class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIdx = -1;
        int lastMatch = -1;
        
        while (i < s.length()) {
            // If characters match or pattern has '?'
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } 
            // If pattern has '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                starIdx = j;
                lastMatch = i;
                j++;
            } 
            // If there was a previous '*' and current characters don't match
            else if (starIdx != -1) {
                j = starIdx + 1;
                lastMatch++;
                i = lastMatch;
            } 
            // If characters don't match and no previous '*' to fallback on
            else {
                return false;
            }
        }
        
        // Check for remaining '*' in the pattern
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        // Return true if both strings have been completely matched
        return j == p.length();
    }
}
