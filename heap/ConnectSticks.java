import java.util.PriorityQueue;

public class ConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) pq.add(s);

        int cost = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int newStick = a + b;

            cost += newStick;
            pq.add(newStick);
        }

        return cost;
    }
}
