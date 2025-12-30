
public class ShiftingLettersII {

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] sh : shifts) {
            int start = sh[0];
            int end = sh[1];
            int dir = sh[2] == 1 ? 1 : -1;

            diff[start] += dir;
            if (end + 1 < n) {
                diff[end + 1] -= dir;
            }
        }

        char[] arr = s.toCharArray();
        int currShift = 0;

        for (int i = 0; i < n; i++) {
            currShift += diff[i];
            int shift = ((currShift % 26) + 26) % 26;

            arr[i] = (char) ('a' + (arr[i] - 'a' + shift) % 26);
        }

        return new String(arr);
    }

}
