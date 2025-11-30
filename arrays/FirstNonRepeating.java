import java.util.HashMap;

public class FirstNonRepeating {

    // Approach: Frequency map
    // 1. Count occurrences using HashMap
    // 2. Second pass to find the first element with frequency 1
    // Time: O(n), Space: O(n)
    public static int firstNonRepeating(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 5, 2, 3};
        System.out.println(firstNonRepeating(nums));
    }
}
