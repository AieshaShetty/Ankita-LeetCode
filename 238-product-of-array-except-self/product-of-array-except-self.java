class Solution {
    public int[] productExceptSelf(int[] nums) {
        int suffProduct=1, n=nums.length;
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            suffProduct*=nums[i];
            ans[i]=suffProduct;
        }
        int product=1;
        for(int i=0;i<nums.length;i++){
            int currProduct=i+1<n? product*ans[i+1]:product;
            ans[i]=currProduct;
            product*=nums[i];
        }
        return ans;
    }
}