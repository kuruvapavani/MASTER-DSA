
public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int[][] len = new int[n][m];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, dfs(i, j, matrix, len));
            }
        }
        return maxLen;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] len) {
        if (len[i][j] > 0) {
            return len[i][j];
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int best = 1;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[i][j]) {
                best = Math.max(best, 1 + dfs(nr, nc, matrix, len));
            }
        }
        len[i][j] = best;
        return best;
    }
}
