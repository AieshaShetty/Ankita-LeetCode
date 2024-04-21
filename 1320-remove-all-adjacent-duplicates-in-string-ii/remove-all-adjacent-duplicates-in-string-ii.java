class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().getKey() == c) {
                Pair<Character, Integer> pair = stack.pop();
                pair = new Pair<>(pair.getKey(), pair.getValue() + 1);
                if (pair.getValue() != k)
                    stack.push(pair);
            } else {
                stack.push(new Pair<>(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair<Character, Integer> pair : stack) {
            for (int i = 0; i < pair.getValue(); i++) {
                sb.append(pair.getKey());
            }
        }
        return sb.toString();
    }
}