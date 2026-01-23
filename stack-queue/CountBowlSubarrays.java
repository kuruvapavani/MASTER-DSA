
import java.util.*;

public class CountBowlSubarrays {

    public long countBowlSubarrays(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[dq.peek()] < nums[i]) {
                dq.pop();
            }
            left[i] = dq.size();
            dq.push(i);
        }
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && nums[dq.peek()] < nums[i]) {
                dq.pop();
            }
            right[i] = dq.size();
            dq.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) left[i] * right[i];
        }
        return ans;
    }
}
