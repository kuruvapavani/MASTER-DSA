import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // Approach: Sorting + Two Pointers
    // 1. Sort array
    // 2. Fix nums[i], then use left/right pointers to find pairs that sum to -nums[i]
    // 3. Skip duplicates for i, left, and right
    // Time: O(n^2), Space: O(1) (excluding output list)
    public static List<int[]> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<int[]> ans = threeSum(nums);
        for (int[] triplet : ans) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}
