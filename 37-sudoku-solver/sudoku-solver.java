class Solution {
    public boolean valid(char[][] board, int i, int j, char k) {
        for (int r = 0; r < 9; r++) {
            if (board[r][j] == k && i != r) return false;
        }
        for (int r = 0; r < 9; r++) {
            if (board[i][r] == k && j != r) return false;
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[(i / 3) * 3 + r][(j / 3) * 3 + c] == k && i != (i / 3) * 3 + r && j != (j / 3) * 3 + c) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (valid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false; 
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board){
        solve(board);
    }

}
