import java.util.Stack;

public class MinStack {

    private Stack<Integer> st; 
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        if (minSt.isEmpty() || x <= minSt.peek()) {
            minSt.push(x);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        int removed = st.pop();
        if (removed == minSt.peek()) {
            minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
