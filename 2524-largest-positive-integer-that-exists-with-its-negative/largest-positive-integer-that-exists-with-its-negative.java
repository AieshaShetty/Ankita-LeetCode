class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        //double pointers
        int positive = nums.length-1;
        int negative = 0;
        while(negative < positive){
            if(nums[positive] == -nums[negative]){
                return nums[positive];
            }
            else if(nums[positive] > -nums[negative]){
                positive--;
            }
            else{
                negative++;
            }
        }
        return -1;
    }
}