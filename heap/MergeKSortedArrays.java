
import java.util.*;

public class MergeKSortedArrays {

    public int[] mergeKSortedArrays(int[][] arr) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> arr[a[0]][a[1]] - arr[b[0]][b[1]]
        );

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 0) {
                pq.add(new int[]{i, 0});
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int arrIndex = curr[0];
            int elemIndex = curr[1];

            ans.add(arr[arrIndex][elemIndex]);

            if (elemIndex + 1 < arr[arrIndex].length) {
                pq.add(new int[]{arrIndex, elemIndex + 1});
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
