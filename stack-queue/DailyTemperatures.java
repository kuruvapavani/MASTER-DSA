
import java.util.Stack;

public class DailyTemperatures {
  public static int[] dailyTemperatures(int[] temp){
    int[] ans = new int[temp.length];
    Stack<Integer> st = new Stack<>();
    for(int i=temp.length-1;i>=0;i--){
      while(!st.isEmpty() && temp[st.peek()] <= temp[i]){
        st.pop();
      }
      ans[i] = st.isEmpty() ? 0 : st.peek()-i;
      st.push(i);
    }
    return ans;
  }
}
