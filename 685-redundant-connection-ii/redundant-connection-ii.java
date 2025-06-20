class Solution {
    int[][] edges;
    int n;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        this.edges=edges; n= edges.length;
        int[] indegree=new int[n+1];
        List<Integer> candidates=new ArrayList<>();
        for(int i=0;i<n;i++){
            indegree[edges[i][1]]++;
        }
        for(int i=0;i<n;i++){
             if(indegree[edges[i][1]]==2) candidates.add(i);
        }
        if(candidates.size()>0){
            int remove=candidates.get(candidates.size()-1);
            if(isValidTree(remove)) return edges[remove];
            return edges[candidates.get(0)];
        }else{
            return findCycleEdge();
        }
    }
    boolean isValidTree(int remove){
        int[] uf=new int[n+1];
        for(int i=0;i<n;i++){
            if(i==remove) continue;
            int x=edges[i][0],y=edges[i][1],
            px=find(uf,x), py=find(uf,y);
            if(px==py) return false;
            uf[px]=py;
        }
        return true;
    }
    int[] findCycleEdge(){
        int[] uf=new int[n+1];
        for(int i=0;i<n;i++){
            int x=edges[i][0],y=edges[i][1],
            px=find(uf,x), py=find(uf,y);
            if(px==py) return edges[i];
            uf[px]=py;
        }
        return null;
    }
    int find(int[]uf, int x){
        if(uf[x]==0) uf[x]=x;
        if(uf[x]!=x) uf[x]=find(uf,uf[x]);
        return uf[x];
    }
}