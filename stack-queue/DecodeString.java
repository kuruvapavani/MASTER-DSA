
import java.util.*;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<StringBuilder> st2 = new Stack<>();
        StringBuilder str = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                st1.push(num);
                num = 0;
                st2.push(str);
                str = new StringBuilder();
            } else if (ch == ']') {
                int count = st1.pop();
                StringBuilder prev = st2.pop();
                for (int j = 0; j < count; j++) {
                    prev.append(str);
                }
                str = prev;
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
