
import java.util.Arrays;

public class MaxTwoEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });
        int n = events.length;
        int[][] endArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            endArr[i][0] = events[i][1];
            endArr[i][1] = events[i][2];
        }
        Arrays.sort(endArr, (a, b) -> a[0] - b[0]);
        int[] prefixMax = new int[n];
        prefixMax[0] = endArr[0][1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], endArr[i][1]);
        }
        int ans = 0;

        for (int[] e : events) {
            int start = e[0];
            int value = e[2];

            int left = 0, right = n - 1, index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (endArr[mid][0] < start) {
                    index = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int best = index == -1 ? 0 : prefixMax[index];
            ans = Math.max(ans, best + value);
        }
        return ans;
    }
}
