class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int zeros = countZeros(nums);
        if (zeros > 1) {
            return new int[nums.length];
        }

        int prd = reduceProduct(nums);

        if (zeros > 0) {
            return Arrays.stream(nums).map(x -> (x != 0) ? 0 : prd).toArray();
        } else {
            return Arrays.stream(nums).map(x -> prd / x).toArray();
        }
    }

    private static int countZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        return count;
    }

    private static int reduceProduct(int[] nums) {
        int product = 1;
        for (int num : nums) {
            if (num != 0) {
                product *= num;
            }
        }
        return product;
    }

}
