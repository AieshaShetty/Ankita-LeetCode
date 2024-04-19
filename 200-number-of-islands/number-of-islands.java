class Solution {

        static void dfs(char arr[][], int i, int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length) return;

        if(arr[i][j]=='0') return;

        arr[i][j] = '0';
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
        dfs(arr,i-1,j);
        dfs(arr,i+1,j);
    }

 
    static void bfs(char arr[][], int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        int n = arr.length;
        int m = arr[0].length;

        while(q.size()!=0){
            int a[] = q.remove();
            int i = a[0];
            int j = a[1];
            arr[i][j] = '0';

            if(j+1<m && arr[i][j+1]=='1'){
                arr[i][j+1] = '0';
                q.add(new int[]{i,j+1});
            }

            if(j-1>=0 && arr[i][j-1]=='1'){
                arr[i][j-1] = '0';
                q.add(new int[]{i,j-1});
            }

            if(i+1<n && arr[i+1][j]=='1'){
                arr[i+1][j] = '0';
                q.add(new int[]{i+1,j});
            }

            if(i-1>=0 && arr[i-1][j]=='1'){
                arr[i-1][j] = '0';
                q.add(new int[]{i-1,j});
            }
        }
    }
    public int numIslands(char[][] arr) {
        int ans = 0;
        int n = arr.length;
        int m = arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]=='1'){
                    ans++;
                    dfs(arr,i,j); 
                }
            }
        }
        return ans;
  
    }
}