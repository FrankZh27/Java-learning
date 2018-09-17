class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length, count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'x' || grid[i][j] == '0') continue;
                count++;
                marker(grid, i, j);
            }
        }
        return count;
    }
    
    private void marker(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (grid[row][col] == 'x' || grid[row][col] == '0') return;
        grid[row][col] = 'x';
        marker(grid, row-1, col);
        marker(grid, row+1, col);
        marker(grid, row, col-1);
        marker(grid, row, col+1);
        return;
    }
}
