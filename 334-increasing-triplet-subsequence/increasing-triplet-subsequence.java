public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                // Update first if num is smaller or equal
                first = num;
            } else if (num <= second) {
                // Update second if num is greater than first but smaller or equal to second
                second = num;
            } else {
                // If num is greater than both first and second, we found our triplet
                return true;
            }
        }

        // If we finish the loop without finding any triplet
        return false;
    }
}
