
public class HouseRobber {

    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n + 1];
    //     dp[1] = nums[0];
    //     for (int i = 2; i <= n; i++) {
    //         dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
    //     }
    //     return dp[n];
    // }

    
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int curr = Math.max(prev1, num + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
