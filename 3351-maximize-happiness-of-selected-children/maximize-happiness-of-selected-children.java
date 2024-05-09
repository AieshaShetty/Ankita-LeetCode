class Solution {
    public long maximumHappinessSum(int[] happy, int k) {
        long res = 0;
        Arrays.sort(happy);
        for(int turns=0, j=happy.length-1 ; j>=0 && turns<k; j--, turns++){
            res += Math.max(happy[j] - turns, 0);
        }
        return res;
    }
}