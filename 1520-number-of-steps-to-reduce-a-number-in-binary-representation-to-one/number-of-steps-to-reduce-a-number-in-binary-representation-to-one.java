class Solution {
    public int numSteps(String s) {
        int n=s.length();
        int cnt=0;
        int carry=0;
        for(int i=n-1;i>0;i--){
            int num=((s.charAt(i)-'0')+carry);
            if(num%2!=0){
                cnt+=2;
                carry=1;
            }
            else{
                cnt++;
            }
        }
        
        return cnt+carry;
    }
}