class Solution {
    static ArrayList<Integer> graph[];

    static void addEdge(int a, int b){
        graph[a].add(b);
        graph[b].add(a);
    }

    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();
        if(n==0) return ans;
        if(n==1){
            ans.add(0);
            return ans;
        }
        graph = new ArrayList[n];
        int indegree[] = new int[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(var a : edges){
            addEdge(a[0],a[1]);
            indegree[a[0]]++;
            indegree[a[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==1){
                q.add(i);
            } 
        }


        while(q.size()!=0){
            int size = q.size();
            ans.clear();
            for(int i=0; i<size; i++){
                int a = q.remove();
                ans.add(a);
                for(var x : graph[a]){
                    indegree[x]--;
                    if(indegree[x]==1) q.add(x);
                }
            }
            
        }
        return ans;

    }
}