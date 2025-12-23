
import java.util.*;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) {
                ans.add(matrix[top][c]);
            }
            top++;
            for (int r = top; r <= bottom; r++) {
                ans.add(matrix[r][right]);
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    ans.add(matrix[bottom][c]);
                }
            }
            bottom--;

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    ans.add(matrix[r][left]);
                }
                left++;
            }
        }
        return ans;
    }

}
