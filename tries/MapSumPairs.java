
import java.util.*;

public class MapSumPairs {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        int sum = 0;
    }
    TrieNode root;
    HashMap<String, Integer> map;

    public void MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int oldVal = map.getOrDefault(key, 0);
        int diff = val - oldVal;
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            node.sum += diff;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return 0;
            }
            node = node.children[idx];
        }
        return node.sum;
    }
}
