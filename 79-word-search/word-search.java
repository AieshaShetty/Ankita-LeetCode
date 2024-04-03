class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean res = helper(board,i,j,m,n,0,word);
                    if(res == true)return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board,int i,int j,int m,int n,int idx,String s){
        if(idx == s.length())return true;
        else if(i < 0 || i == m || j < 0 || j == n || board[i][j] == '1' || board[i][j] != s.charAt(idx))return false;
        char c = board[i][j];
        board[i][j] = '1';
        idx++;
        boolean res = helper(board,i+1,j,m,n,idx,s) || helper(board,i-1,j,m,n,idx,s) || helper(board,i,j+1,m,n,idx,s) || helper(board,i,j-1,m,n,idx,s);
        board[i][j] = c;
        return res;
    }
}