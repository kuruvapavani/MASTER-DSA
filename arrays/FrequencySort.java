
import java.util.Arrays;

public class FrequencySort {

    public String frequencySort(String s) {
        int[][] count = new int[128][2];

        for (char c : s.toCharArray()) {
            count[c][0]++;
            count[c][1] = c;
        }

        Arrays.sort(count, (a, b) -> b[0] - a[0]);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 128; i++) {
            int freq = count[i][0];
            if (freq == 0) {
                break;

            }
            char c = (char) count[i][1];

            while (freq-- > 0) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
