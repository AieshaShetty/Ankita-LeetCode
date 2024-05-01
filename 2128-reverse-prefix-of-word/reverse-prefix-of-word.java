/*class Solution {
    public String reversePrefix(String word, char ch) {
        String pre = word.substring(0,word.indexOf(ch)+1);
        StringBuffer sb = new StringBuffer(pre);
        return sb.reverse().append(word.substring(word.indexOf(ch)+1)).toString();
    }
}*/
class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word; // If the character 'ch' is not found, return the original word
        
        // Reverse the prefix directly in the original string
        char[] chars = word.toCharArray();
        int left = 0, right = index;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}
