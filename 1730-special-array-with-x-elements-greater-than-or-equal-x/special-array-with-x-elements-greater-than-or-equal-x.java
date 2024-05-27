class Solution {
    public int specialArray(int[] nums) {
        
        for(int i=1;i<=nums.length;i++){
            if(check(i,nums)==i){
                return i;
            }
        }
        return -1;
    }
    public int check(int i,int[] nums){
        int count =0;
        for(int num:nums){
            if(num>=i){
                count++;
            }
        }
        return count;
    }
}