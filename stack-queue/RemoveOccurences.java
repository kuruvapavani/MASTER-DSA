
import java.util.Stack;

public class RemoveOccurences {

    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int m = part.length();
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
            if (st.size() >= part.length()) {
                boolean match = true;
                for (int j = 0; j < part.length(); j++) {
                    if (st.get(st.size() - m + j) != part.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int j = 0; j < m; j++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
