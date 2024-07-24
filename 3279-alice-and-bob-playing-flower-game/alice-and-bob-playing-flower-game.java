class Solution {
    public long flowerGame(int n, int m){
        long evenCountN=(n+1)/2, oddCountN=n/2, evenCountM=(m+1)/2, oddCountM=m/2, total=0;
        total=evenCountN*oddCountM+oddCountN*evenCountM;
        return total;
       
    }
}