class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] original = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // Find the indices of the original unsorted array
                int index1 = findIndex(original, nums[left], -1);
                int index2 = findIndex(original, nums[right], index1);
                return new int[] {index1, index2};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int findIndex(int[] nums, int value, int excludeIndex) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value && i != excludeIndex) {
                return i;
            }
        }
        return -1;
    }
}
