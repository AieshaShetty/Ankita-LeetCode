class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] temp_arr = new int[nums.length+1];
        int result = 0;
        
        for(int i=1;i<temp_arr.length;i++)
            temp_arr[i] = nums[i-1] + temp_arr[i-1];
        for(int i=0;i<temp_arr.length;i++){
            if(map.containsKey(temp_arr[i] - k))
                result += map.get(temp_arr[i] - k);
                map.put(temp_arr[i],map.getOrDefault(temp_arr[i],0)+1);
        }
        return result;
    }
}