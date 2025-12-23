
import java.util.*;

public class SpiralTraversalII {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                ans[top][c] = num++;
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                ans[r][right] = num++;
            }
            right--;

            for (int c = right; c >= left; c--) {
                ans[bottom][c] = num++;
            }
            bottom--;

            for (int r = bottom; r >= top; r--) {
                ans[r][left] = num++;
            }
            left++;
        }
        return ans;
    }
}
