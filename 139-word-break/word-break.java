class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return helper(s, wordDict, 0, dp) == 1;
    }
    private int helper(String s, List<String> wordDict, int pos, int[] dp) {
        if(pos == s.length()) {
            return 1;
        }

        if(dp[pos] != -1) {
            return dp[pos];
        }
        for(int i = 0; i < wordDict.size(); i++) {
            if(isMatching(s, pos, wordDict.get(i))) {
                dp[pos] =  helper(s, wordDict, pos + wordDict.get(i).length(), dp);
                if(dp[pos] == 1) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean isMatching(String s, int pos, String word) {
        if(s.length() - pos < word.length()) {
            return false;
        }
        return s.substring(pos, pos + word.length()).equals(word);
    }
}