/*class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack= new Stack<>();
        int max=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                max=Math.max(max,i-stack.peek());
            }
        }
        return max;
    }
}*/

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), maxi = 0;

        // dp[i] --> length valid parentheses (not longest) ending at end index (i-1)
        int[] dp = new int[n + 1];

        // j pointer
        // i-1 is prev index amd subtracting length of valid parentheses
        // e.g. (()()) n=6
        // for i=5 ')' need to check with i=0 '('-
        // and dp[5]=4 that is length of valid... ending at 4
        // therefor (i-1)-dp[i]=4-4=0 th index

        for (int i = 1; i < n; i++) {
            int j = (i - 1) - dp[i];

            // if s.charAt(i)=='(' the will not valid till i
            // but can get closing further
            if (j >= 0 && s.charAt(i) == ')' && s.charAt(j) == '(') {

                // valid for index 0 and 4 as per above example so add +2
                // so need to add dp[i] and at index j there can be valid ... so its length also
                // need to add
                dp[i + 1] = dp[i] + dp[j] + 2;
            }

            // as dp of 0, 1 will be 0 as single Bracket or empty can't valid
            maxi = Math.max(maxi, dp[i + 1]);
        }

        return maxi;
    }
}