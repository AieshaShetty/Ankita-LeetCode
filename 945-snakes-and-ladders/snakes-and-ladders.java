class Solution {
    public int snakesAndLadders(int[][] board) {
        int n= board.length;
        HashMap<Integer, Integer> dist = new HashMap<>();
        Queue<Integer> q= new LinkedList<>();
        q.offer(1);
        dist.put(1,0);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == n*n)  return dist.get(curr);

            int upperBound = Integer.min(curr+6 , n*n);
            for(int i=curr + 1; i<=upperBound;i++){
                int rc=get(i,n);
                int r=rc/n, c=rc%n;
                int nextLabel= board[r][c]==-1? i:board[r][c];
                if(!dist.containsKey(nextLabel)){
                    dist.put(nextLabel, dist.get(curr)+1);
                    q.offer(nextLabel);

                }
            }
        }
         
         return -1;
     }

     private int get(int label, int n){
         int q=(label-1)/n;
         int r=(label-1)%n;
         int row=n-1-q;
         int col = (row & 1)!= (n&1)?r:n-1-r;
             return row*n+col;
     }
}