
import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        int m = grid[0].length;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
