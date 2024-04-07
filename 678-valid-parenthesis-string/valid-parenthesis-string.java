class Solution {
    public boolean checkValidString(String str) {
        int open = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '*') {
                count++;
            } else if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open <= 0 && count <= 0)
                    return false;
                else if (open > 0)
                    open--;
                else if (count > 0)
                    count--;
            }
        }
        int close = 0;
        int count1 = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '*') {
                count1++;
            } else if (ch == ')') {
                close++;
            } else if (ch == '(') {
                if (close <= 0 && count1 <= 0)
                    return false;
                else if (close > 0)
                    close--;
                else if (count1 > 0)
                    count1--;
            }
        }
        return open <= count && close <= count1;
    }
}