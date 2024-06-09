class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        return helper(nums,k);
    }

    public int helper(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int ans=0, sum=0;
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            int rem = sum%k;
            if(rem<0)  rem+=k;
            map.put(rem, map.getOrDefault(rem,0)+1);
            ans+=map.get(rem)-1;
                    
            }
            return ans;
    }
}