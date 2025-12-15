import java.util.HashMap;

public class CheckSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int rem = prefix % k;

            if (rem < 0) rem += k;

            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
