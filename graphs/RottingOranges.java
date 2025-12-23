
import java.util.*;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int mins = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        q.add(new int[]{nr, nc});
                        rotted = true;
                        grid[nr][nc] = 2;
                        freshOranges--;
                    }
                }
            }

            if (rotted) {
                mins++;
            }
        }
        return freshOranges == 0 ? mins : -1;
    }
}
