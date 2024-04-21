class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> ans = new HashSet<>();
        ans.add(source);
        int r=0;

        while(r<ans.size() && !ans.contains(destination)){
            r=ans.size();
            for(int i=0;i<edges.length;i++){
                if(ans.contains(edges[i][0])){
                    ans.add(edges[i][1]);

                }
                if(ans.contains(edges[i][1])){
                    ans.add(edges[i][0]);
                }
            }
        }
        return ans.contains(destination);
    }
}