
import java.util.*;

public class LetterCombinations {

    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(0, digits, new StringBuilder());
        return ans;
    }

    private void backtrack(int i, String digits, StringBuilder s) {
        if (i == digits.length()) {
            ans.add(s.toString());
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (char ch : letters.toCharArray()) {
            s.append(ch);
            backtrack(i + 1, digits, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
