class Solution {
    public int minimumSum(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n ; i++){
            for(int j = i+1; j < n ; j++){
                for(int k = j+1 ; k < n ; k++){
                    if(nums[i] < nums[j] && nums[j] > nums[k]){
                        sum = nums[i]+nums[j]+nums[k];
                        min = Math.min(min,sum);
                    }
                }
            }
        }
        if(min != Integer.MAX_VALUE)return min;
        else return -1;
    }
}