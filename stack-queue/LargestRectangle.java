
import java.util.Stack;

public class LargestRectangle {

    public int largestRectangleArea(int[] h) {
        int n = h.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int curr = (i == n ? 0 : h[i]);

            while (!st.isEmpty() && curr < h[st.peek()]) {
                int height = h[st.pop()];

                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();

                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}
