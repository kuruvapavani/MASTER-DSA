public class FindPairWithDifference {

    public static boolean findPairWithDifference(int[] nums, int k) {
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (left == right) {
                right++;
                continue;
            }

            int diff = nums[right] - nums[left];

            if (diff == k) return true;
            else if (diff < k) right++;
            else left++;
        }
        return false;
    }
}
