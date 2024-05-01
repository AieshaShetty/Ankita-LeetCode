class Solution {
    public String reversePrefix(String word, char ch) {
        String pre = word.substring(0,word.indexOf(ch)+1);
        StringBuffer sb = new StringBuffer(pre);
        return sb.reverse().append(word.substring(word.indexOf(ch)+1)).toString();
    }
}