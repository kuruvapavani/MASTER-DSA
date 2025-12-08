
import java.util.*;

public class SubArraySum {

    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};;
        System.out.println(subarraySum(nums, 7));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            currSum += num;

            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }

}
