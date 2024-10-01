class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> remainderMap = new HashMap<>();

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }

         for (int num : arr) {
            int remainder = ((num % k) + k) % k;

            if (remainder == 0) {
                if (remainderMap.get(remainder) % 2 != 0) {
                    return false;
                }
            } else {
                int complement = k - remainder;
                if (!remainderMap.containsKey(complement) || remainderMap.get(complement) < remainderMap.get(remainder)) {
                    return false;
                }
            }
        }

         return true;
       
    }
}