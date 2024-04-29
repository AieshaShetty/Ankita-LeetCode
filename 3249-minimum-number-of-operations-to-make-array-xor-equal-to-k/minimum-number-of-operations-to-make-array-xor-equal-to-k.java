class Solution {
    public int minOperations(int[] nums, int k) {
        int ansXOR = 0;
        for (int i = 0; i < nums.length; i++) {
            ansXOR ^= nums[i];
        }
        int count = 0;
        while (k > 0 || ansXOR > 0) {
            if ((k & 1) != (ansXOR & 1)) { // Compare least significant bit
                count++;
            }
            k >>= 1; // Right shift to consider next bit
            ansXOR >>= 1;
        }
        return count;
    }
}
