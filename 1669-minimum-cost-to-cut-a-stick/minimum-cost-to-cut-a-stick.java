class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for(int cut : cuts) list.add(cut);
        list.add(n);
        list.add(0);
        Collections.sort(list);
        int t=list.size();
        int dp[][]=new int[t][t];
        for(int i=t-1;i>=0;i--){
            for(int j=i+1;j<t;j++){
                if(i+1==j) {
                    dp[i][j]=0;
                    continue;
                }
                int cost=list.get(j)-list.get(i);
                int min=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    min=Math.min(min,dp[i][k]+dp[k][j]+cost);
                }
                dp[i][j]=min;
            }
        }
        return dp[0][t-1];
        
    }
}