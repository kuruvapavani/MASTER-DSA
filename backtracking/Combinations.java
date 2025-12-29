
import java.util.*;

public class Combinations {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k, new ArrayList<>());
        return ans;
    }

    private void backtrack(int n, int start, int k, List<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(n, i + 1, k, list);
            list.remove(list.size() - 1);
        }
    }
}
