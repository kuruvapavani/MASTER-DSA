import java.util.HashMap;

public class SubarraySumK {

    // Approach: Prefix Sum + HashMap
    // prefix[j] - prefix[i] = k  =>  prefix[i] = prefix[j] - k
    // Count how many times a prefix value has appeared
    // Time: O(n), Space: O(n)
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;

            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 5, 2, 3};
        System.out.println(subarraySum(nums, 5));
    }
}
