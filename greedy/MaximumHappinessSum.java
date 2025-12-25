
import java.util.Arrays;

public class MaximumHappinessSum {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int happy = happiness[n - 1 - i] - i;
            if (happy <= 0) {
                break;
            }
            ans += happy;
        }
        return ans;
    }
}
