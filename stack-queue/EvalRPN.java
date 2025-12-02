import java.util.Stack;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int a = st.pop();
                int b = st.pop();
                st.push(apply(b, a, token));
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int apply(int b, int a, String op) {
        switch (op) {
            case "+": return b + a;
            case "-": return b - a;
            case "*": return b * a;
            default:  return b / a;
        }
    }
}
