
import java.util.List;

public class MinimumSumSubarray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        int[] prefix = new int[nums.size() + 1];
        for (int i = 1; i < nums.size() + 1; i++) {
            prefix[i] = prefix[i - 1] + nums.get(i - 1);
        }
        while (l <= r) {
            for (int i = 0; i < prefix.length - l; i++) {
                int sum = prefix[i + l] - prefix[i];
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
            l++;
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
