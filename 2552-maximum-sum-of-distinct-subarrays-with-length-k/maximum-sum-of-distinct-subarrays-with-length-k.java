class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result=0;
        long sum=0;
        int start=0;
        int end=0;
        Set<Integer> temp=new HashSet<>();
        while(end<nums.length && start<nums.length)
        {
            if(temp.contains(nums[end]))
            {
               temp.remove(nums[start]);
                sum-=nums[start];
                start++; 
                continue;
            }
            sum+=nums[end];
            temp.add(nums[end]);
            end++;
            if((end-start)==k)
            {
                result=Math.max(sum,result);
                temp.remove(nums[start]);
                sum-=nums[start];
                start++;
            }
        }
        return result;
    }
}