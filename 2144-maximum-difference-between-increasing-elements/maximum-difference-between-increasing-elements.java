class Solution {
    public int maximumDifference(int[] arr) {
        int n = arr.length;
        int max = arr[arr.length-1];
        int output = -1;

        for(int i = n-2;i>=0;i--){
            if(max>arr[i]){
                output = Math.max(output, max-arr[i]);
            }
            else{
                max = arr[i];
            }
        }
            
        return output;
        
    }
}