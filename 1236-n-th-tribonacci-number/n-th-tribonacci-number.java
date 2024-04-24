class Solution {
    public int tribonacci(int n) {
        int t0=0,t1=1,t2=1,sum=2;
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(n==3) return sum;
        if(n>=0){
            for(int i=4;i<=n;i++){
                t0=t1;t1=t2;t2=sum;
                sum=t0+t1+t2;
            }
        }
        return sum;
        
    }
}