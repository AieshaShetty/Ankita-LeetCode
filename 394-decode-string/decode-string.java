class Solution {
    public String decodeString(String s) {
        int n = s.length();
        String ans = "";
        String temp = "";
        int mul = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                mul = mul * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                strStack.push(ans);
                numStack.push(mul);
                mul = 0;
                ans = "";
            } else if (s.charAt(i) == ']') {
                temp = ans;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < numStack.peek(); ++j) {
                    sb.append(temp);
                }
                numStack.pop();
                ans = strStack.pop() + sb.toString();
            } else {
                ans += s.charAt(i);
            }
        }
        
        return ans;
    }
}
