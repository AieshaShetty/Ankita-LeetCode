class Solution {
    public int arrayNesting(int[] nums) {
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int length = 0;
                int current = i;

                while (nums[current] >= 0) {
                    int next = nums[current];
                    nums[current] = -1; // Mark as visited
                    current = next;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
