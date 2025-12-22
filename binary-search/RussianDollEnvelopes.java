
import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] tails = new int[n];
        int size = 0;
        for (int[] num : envelopes) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num[1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num[1];
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
