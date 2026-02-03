
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num] += num;
        }
        int prev1 = 0, prev2 = 0;
        for (int i = 0; i <= max; i++) {
            int temp = Math.max(prev1, prev2 + freq[i]);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}
