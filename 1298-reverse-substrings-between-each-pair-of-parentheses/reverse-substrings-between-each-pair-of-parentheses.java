class Solution {
    static Stack<Character> st = new Stack<>();
    public static String reverseParentheses(String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if(a[i]==')'){
                reverse(st);
            }else{
                st.push(a[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        return sb.toString();
    }

    private static void reverse(Stack<Character> st) {
        StringBuilder sb=  new StringBuilder();
        while(st.peek()!='('){
            sb.append(st.pop());
        }
        st.pop();

        for (int i = 0; i < sb.length(); i++) {
            st.push(sb.charAt(i));
        }
    }
}