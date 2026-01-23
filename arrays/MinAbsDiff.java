
import java.util.*;

public class MinAbsDiff {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            diff = Math.min(diff, Math.abs(arr[i] - arr[i - 1]));
        }
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == diff) {
                ans.add(new ArrayList<>(Arrays.asList(arr[i - 1], arr[i])));
            }
        }
        return ans;
    }
}
