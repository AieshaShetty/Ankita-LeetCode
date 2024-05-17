class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] arr = new int[2];
        
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                arr[0] = l + 1;
                arr[1] = r + 1;
                break; // Break the loop when target sum is found
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return arr;
    }
}
