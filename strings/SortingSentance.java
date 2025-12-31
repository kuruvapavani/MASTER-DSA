
public class SortingSentance {

    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i].charAt(arr[i].length() - 1) - '0';
            ans[pos - 1] = arr[i].substring(0, arr[i].length() - 1);
        }
        return String.join(" ", ans);
    }
}
