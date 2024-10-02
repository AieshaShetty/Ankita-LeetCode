class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0) return arr;
        int[] nums=new int[arr.length]; int k=0;
        for(int e:arr) nums[k++]=e;
        Arrays.sort(nums);
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(nums[0],1);
        int rank=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) continue;
            else mp.put(nums[i],++rank);
        }
        k=0;
        for(int e:arr){
           nums[k++]=mp.get(e); 
        }
        return nums;
    }
}