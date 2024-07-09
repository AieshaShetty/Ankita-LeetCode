class Solution {
    public int longestOnes(int[] nums, int k) {
        int countOfZero = 0;
        int maxCountOfOne = 0;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countOfZero++;
            }
            while (start < nums.length && countOfZero > k) {
                if (nums[start++] == 0) {
                    countOfZero--;
                }
            }
            maxCountOfOne = Math.max(maxCountOfOne, i - start + 1);
        }

        return maxCountOfOne;
    }
}