
public class MinDeletionSize {

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        int maxKeep = 1;
        for (int i = 0; i < cols; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (canFollow(strs, i, j)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxKeep = Math.max(dp[i], maxKeep);
        }
        return cols - maxKeep;
    }

    private boolean canFollow(String[] strs, int i, int j) {
        for (int row = 0; row < strs.length; row++) {
            if (strs[row].charAt(j) > strs[row].charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
