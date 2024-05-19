class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
       long sum=0;
       int cnt=0;
       int min_Loss=Integer.MAX_VALUE;
       for(int it:nums){
            if((it^k)>it){
                cnt++;
                sum+=it^k;
            }
            else
            sum+=it;
            min_Loss=Math.min(min_Loss,Math.abs(it-(it^k)));
       } 
       if(cnt%2==1){
        return sum-min_Loss;
       }
       else
       return sum;
    }
}