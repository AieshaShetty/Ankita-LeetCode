class Solution {
    public int minOperations(int[] nums, int k) {
        int ansXOR = 0;
        for(int i=0;i<nums.length;i++){
            ansXOR = ansXOR ^ nums[i];
        }
        int count = 0;
        while(k>0 || ansXOR > 0){
            if(k%2 != ansXOR%2){
                count++;
            }
            k = k/2;
            ansXOR = ansXOR/2;
        }
        return count;
    }
}