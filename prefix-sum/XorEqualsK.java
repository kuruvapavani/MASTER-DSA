
import java.util.*;

public class XorEqualsK {

    public static int countSubarraysWithXor(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixXor = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : nums) {
            prefixXor ^= num;

            int target = prefixXor ^ k;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7};
        System.out.println(countSubarraysWithXor(nums, 1));
    }
}
