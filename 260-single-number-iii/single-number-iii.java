class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // XOR all elements to get xor of two unique numbers
        for (int num : nums) {
            xor ^= num;
        }
        // Find a bit that is set in the xor result
        int mask = xor & -xor;

        int num1 = 0, num2 = 0;
        // Partition numbers into two groups and XOR within each group
        for (int num : nums) {
            if ((num & mask) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[] {num1, num2};
    }
}