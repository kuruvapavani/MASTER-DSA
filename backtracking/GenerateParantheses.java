
import java.util.*;

public class GenerateParantheses {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return ans;
    }

    private void backtrack(int open, int close, int n, StringBuilder s) {
        if (s.length() == 2 * n) {
            ans.add(s.toString());
            return;
        }
        if (open < n) {
            s.append('(');
            backtrack(open + 1, close, n, s);
            s.deleteCharAt(s.length() - 1);
        }
        if (close < open) {
            s.append(')');
            backtrack(open, close + 1, n, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
