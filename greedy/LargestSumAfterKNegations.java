
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] freq = new int[201];
        for (int num : nums) {
            freq[num + 100]++;
        }

        for (int i = 0; i < 100 && k > 0; i++) {
            while (freq[i] > 0 && k > 0) {
                freq[i]--;
                freq[200 - i]++;
                k--;
            }
        }

        if (k > 0 && k % 2 == 1 && freq[100] == 0) {
            for (int i = 101; i < 201; i++) {
                if (freq[i] > 0) {
                    freq[i]--;
                    freq[200 - i]++;
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 201; i++) {
            sum += (i - 100) * freq[i];
        }

        return sum;
    }
}
