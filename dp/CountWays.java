public class CountWays {

    public static void main(String[] args) {
      int[] nums = {1,0,1};
      System.out.println(countWays(nums));
    }

    public static int countWays(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 1;

        if (n >= 1 && nums[0] > 0) {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (nums[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            if (nums[i - 2] > 0) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

}
