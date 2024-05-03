class Solution {
    public int compareVersion(String v1, String v2) {
        int i=0,j=0;
        while(i<v1.length()||j<v2.length()){
            int x=0,y=0;
            while(i<v1.length()&&v1.charAt(i)!='.'){
                x=x*10 + (v1.charAt(i)-'0');
                i++;
            }
            while(j<v2.length()&&v2.charAt(j)!='.'){
                y=y*10 + (v2.charAt(j)-'0');
                j++;
            }
            if(x>y)    return 1;
            else if(y>x)    return -1;
            else{
                i++;
                j++;
            }
        }
        return 0;
    }
}