class Solution {
    public int maxArea(int[] height) {
        if(height.length<2) return 0;
        int rslt=0;
        for(int i=1;i<height.length;++i){
            if(height[i]==0) continue;
            int length= rslt/ height[i];
            for(int j=i-length;j>=0;--j){
                int result=(i-j)* Math.min(height[i], height[j]);
                if(result> rslt) rslt=result;
            }
        }
        return rslt;
    }
}