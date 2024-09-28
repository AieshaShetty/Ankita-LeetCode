class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && Math.abs(asteroids[i]) < asteroids[stack.peek()]) {
                    continue;
                } else if (!stack.isEmpty() && Math.abs(asteroids[i]) == asteroids[stack.peek()]) {
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && Math.abs(asteroids[i]) > asteroids[stack.peek()]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        resultList.add(asteroids[i]);
                    }
                    if (!stack.isEmpty() && Math.abs(asteroids[i]) == asteroids[stack.peek()]) {
                        stack.pop();
                    }
                }
            }
        }
        
        int index = resultList.size();
        while (!stack.isEmpty()) {
            resultList.add(index, asteroids[stack.pop()]);
        }
        
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
