class Solution {
    public boolean increasingTriplet(int[] nums) {
        int lowest=Integer.MAX_VALUE;
        int secondlowest=Integer.MAX_VALUE;

        for(int x: nums){
            if(lowest!=Integer.MAX_VALUE && secondlowest!=Integer.MAX_VALUE 
            && secondlowest<x){
                return true;
            }
            if(x<lowest){
                lowest=x;
            }else if(x!=lowest && x<secondlowest){
                secondlowest=x;
            }
        }
        return false;
        
    }
}