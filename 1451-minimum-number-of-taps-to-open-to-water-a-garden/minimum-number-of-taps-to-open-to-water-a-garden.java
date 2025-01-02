class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp=new int[n+1];
        for(int i=0;i<ranges.length;i++){
            int left=(i-ranges[i]<0)?0:i-ranges[i];
            int right=(i+ranges[i]>n)?n:i+ranges[i];
            dp[left]=Math.max(dp[left],right);
        }
        int fountains=1,maxRange=dp[0],max=dp[0];
        for(int i=1;i<=n;i++){
            if(max<i && maxRange<i) return -1;
            else if(max<i){
                max=maxRange;
                fountains++;
            }
            if(maxRange<dp[i])maxRange=dp[i];
        }
        return (maxRange<n)?-1:fountains;
    }
}