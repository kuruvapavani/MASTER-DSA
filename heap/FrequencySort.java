import java.util.*;

public class FrequencySort {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // count freq
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // max heap by freq
        PriorityQueue<Character> pq =
            new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        // push all chars
        pq.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();

        // now build the output
        while (!pq.isEmpty()) {
            char c = pq.remove();
            int freq = map.get(c);
            for (int i = 0; i < freq; i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
