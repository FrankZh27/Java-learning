class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    countHelper(board, i, j);
                }
            }
        }
        return count;
    }
    
    private void countHelper(char[][] board, int row, int col) {
        if (row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1) {
            return;
        }
        if (board[row][col] == '.') {
            return;
        }
        
        if (board[row][col] == 'X') {
            board[row][col] = '.';
            countHelper(board, row-1, col);
            countHelper(board, row+1, col);
            countHelper(board, row, col-1);
            countHelper(board, row, col+1);
            return;
        }
    }
}
