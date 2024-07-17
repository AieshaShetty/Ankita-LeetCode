class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        if(n==0 || m==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        int ans = 0;
        int start=0;
        for(int i=0;i<m;i++){
            if(s[i] >= g[0]){
                start = i;
                break;
            }
        }
        int cookie = start, child = 0;
        while(cookie<m && child < n){
            if(s[cookie] >= g[child]){
                ans++;
                cookie++;
                child++;
            }
            else{
                cookie++;
            }
        }
        
        
        return ans;
    }
}