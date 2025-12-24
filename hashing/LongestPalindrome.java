
import java.util.*;

public class LongestPalindrome {

    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int length = 0;
        int center = 0;

        for (String word : words) {
            String rev = "" + word.charAt(1) + word.charAt(0);
            if (map.getOrDefault(rev, 0) > 0) {
                length += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                center = 2;
                break;
            }
        }
        return length + center;
    }

}
