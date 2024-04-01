class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length(), length = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') length++;
            else if(length > 0) return length;
        }

        return length;
    }
}