class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (helper(word, 0, wordSet)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean helper(String word, int startIndex, Set<String> wordSet) {
        if (startIndex > 0 && wordSet.contains(word.substring(startIndex))) {
            // No need to check the word again since this can be covered by other strings
            wordSet.remove(word);
            return true;
        }
        for (int i = startIndex + 1; i < word.length(); i++) {
            if (!wordSet.contains(word.substring(startIndex, i))) {
                continue;
            }
            if(helper(word, i, wordSet)) {
                return true;
            }
            
        }
        return false;
    }
}