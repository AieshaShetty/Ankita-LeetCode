class Solution {
    public int helper(int i, int[] nums, int k, HashMap<Integer, Integer> map) {
        if(i == nums.length) return 1;

        int pick = 0;
        
        if(!map.containsKey(nums[i] - k)) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            pick = helper(i + 1, nums, k, map);
            map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
            if(map.get(nums[i]) == 0) map.remove(nums[i]);
        }

        int notPick = helper(i + 1, nums, k, map);

        return pick + notPick;
    }
    
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return helper(0, nums, k, new HashMap<Integer, Integer>()) - 1;
    }
}