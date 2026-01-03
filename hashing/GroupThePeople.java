import java.util.*;

public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);

            if (map.get(size).size() == size) {
                ans.add(map.get(size)); // directly add
                map.put(size, new ArrayList<>()); // start a new list
            }
        }

        return ans;
    }
}
