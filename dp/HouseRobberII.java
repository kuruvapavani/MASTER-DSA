
public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int rob1 = doRob(nums, 0, n - 1);
        int rob2 = doRob(nums, 1, n);
        return Math.max(rob1, rob2);
    }

    private int doRob(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i < end; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
