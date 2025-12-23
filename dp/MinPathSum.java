public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0)
                    continue;
                int fromUp = r == 0 ? Integer.MAX_VALUE : grid[r - 1][c];
                int fromLeft = c == 0 ? Integer.MAX_VALUE : grid[r][c - 1];
                grid[r][c] += Math.min(fromUp, fromLeft);
            }
        }
        return grid[rows - 1][cols - 1];
    }

}
