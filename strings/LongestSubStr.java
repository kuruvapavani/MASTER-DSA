public class LongestSubStr {

    public static void main(String[] args) {
        System.out.println(longestSubStr("abacdae"));
    }

    public static int longestSubStr(String s) {
        int[] freq = new int[26];
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';
            freq[idx]++;
            while (freq[idx] > 1) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
