
public class ReverseWords {

    public String reverseWords(String s) {
        int n = s.length();
        int l = 0;
        StringBuilder ans = new StringBuilder();

        while (l < n) {

            while (l < n && s.charAt(l) == ' ') {
                l++;
            }
            if (l >= n) {
                break;
            }

            int r = l;
            while (r < n && s.charAt(r) != ' ') {
                r++;
            }

            for (int i = r - 1; i >= l; i--) {
                ans.append(s.charAt(i));
            }
            if (r < n) {
                ans.append(' ');
            }

            l = r + 1;
        }
        return ans.toString();
    }

}
