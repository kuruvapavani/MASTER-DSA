
import java.util.Arrays;

public class MinDeletionSize {

    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int n = strs.length;
        boolean[] undecided = new boolean[n - 1];
        Arrays.fill(undecided, true);
        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean delete = false;
            for (int j = 0; j < n - 1; j++) {
                if (undecided[j]) {
                    if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                        delete = true;
                        break;
                    }
                }
            }

            if (delete) {
                count++;
                continue;
            }

            for (int j = 0; j < n - 1; j++) {
                if (undecided[j]) {
                    if (strs[j].charAt(i) < strs[j + 1].charAt(i)) {
                        undecided[j] = false;
                    }
                }
            }
        }
        return count;
    }

}
