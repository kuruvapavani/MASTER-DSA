
import java.util.LinkedList;
import java.util.Queue;

public class NumOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                bfs(i, 0, grid, visited);
            }
            if (grid[i][m - 1] == 1) {
                bfs(i, m - 1, grid, visited);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                bfs(0, i, grid, visited);
            }
            if (grid[n - 1][i] == 1) {
                bfs(n - 1, i, grid, visited);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, int[][] grid, boolean[][] visited) {
        int m = grid[0].length;
        int n = grid.length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
