class Solution {
     public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,0, result, subset,visited);
        return result;
    }

    public void backtrack(int[] nums,int index, List<List<Integer>> result, List<Integer> subset, boolean[] visited) {
        if(subset.size() == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(index >= nums.length){
            return;
        }
        Set<Integer> previousSet = new HashSet();
        for(int i =0 ;i < nums.length;i++){
            if(visited[i] || previousSet.contains(nums[i])){
                continue;
            }
            previousSet.add(nums[i]);
            visited[i]=true;
            subset.add(nums[i]);
            backtrack(nums,i, result, subset,visited);
            subset.remove(subset.size()-1);
            visited[i]=false;
        }        
    }
}