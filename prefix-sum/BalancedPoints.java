
import java.util.*;

public class BalancedPoints {

    public static void main(String[] args) {
        int[] nums = {2, 3, -1, 8, 4};
        System.out.println(balancedPoints(nums).toString());
    }

    public static List<Integer> balancedPoints(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int total = prefixSum[n - 1];

        for (int i = 0; i < n; i++) {
            int prefix = prefixSum[i];
            int suffix = total - prefix + nums[i];
            if (prefix == suffix) {
                list.add(i);
            }
        }

        return list;
    }

}
