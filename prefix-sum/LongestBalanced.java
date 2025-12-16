
import java.util.HashMap;

public class LongestBalanced {

    class Solution {

        public int longestBalanced(String s) {
            int n = s.length();
            int ans = 1;
            ans = Math.max(ans, singleChar(s));

            ans = Math.max(ans, twoChars(s, 'a', 'b'));
            ans = Math.max(ans, twoChars(s, 'b', 'c'));
            ans = Math.max(ans, twoChars(s, 'a', 'c'));

            ans = Math.max(ans, threeChars(s));

            return ans;
        }

        private int singleChar(String s) {
            int count = 1;
            int maxLen = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++; 
                }else {
                    count = 1;
                }
                maxLen = Math.max(maxLen, count);
            }
            return maxLen;
        }

        private int twoChars(String s, char x, char y) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int cx = 0, cy = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch != x && ch != y) {
                    map = new HashMap<>();
                    map.put(0, i);
                    cx = 0;
                    cy = 0;
                    continue;
                }
                if (ch == x) {
                    cx++; 
                }else {
                    cy++;
                }
                int diff = cx - cy;
                if (map.containsKey(diff)) {
                    maxLen = Math.max(maxLen, i - map.get(diff));
                } else {
                    map.put(diff, i);
                }
            }
            return maxLen;
        }

        private int threeChars(String s) {
            HashMap<Long, Integer> map = new HashMap<>();
            map.put(0L, -1);
            int a = 0, b = 0, c = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'a') {
                    a++; 
                }else if (ch == 'b') {
                    b++; 
                }else {
                    c++;
                }
                int d1 = a - b;
                int d2 = a - c;
                long key = (((long) d1) << 32) | (d2 & 0xffffffffL);
                if (map.containsKey(key)) {
                    maxLen = Math.max(maxLen, i - map.get(key));
                } else {
                    map.put(key, i);
                }
            }
            return maxLen;
        }
    }
}
