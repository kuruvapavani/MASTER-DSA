
import java.util.*;

public class Subsets {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(0, nums, list);
        return ans;
    }

    private void backtrack(int idx, int[] nums, List<Integer> list) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        backtrack(idx + 1, nums, list);
        list.add(nums[idx]);
        backtrack(idx + 1, nums, list);
        list.remove(list.size() - 1);
    }
}
