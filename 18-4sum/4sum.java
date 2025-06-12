class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kthSum(nums, target,0,4);
    }
	
    public List<List<Integer>> kthSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(start ==  nums.length) return res;
        long average_value=target/k;
        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }
        
        if(k==2) return twoSum(nums,target, start);
    
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kthSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
    
        return res;
    }
	
    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int low = start, high = nums.length - 1;
    
        while (low < high) {
            int currSum = nums[low] + nums[high];
            if (currSum < target || (low > start && nums[low] == nums[low - 1])) {
                ++low;
            } else if (currSum > target || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
                --high;
            } else {
                res.add(Arrays.asList(nums[low++], nums[high--]));
            }
        }
        
                                                          
        return res;
    }
}