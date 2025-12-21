
public class AddBinary {

    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (m >= 0 || n >= 0 || carry == 1) {
            if (m >= 0) {
                carry += a.charAt(m--) - '0';
            }
            if (n >= 0) {
                carry += b.charAt(n--) - '0';
            }
            ans.append(carry & 1);
            carry >>= 1;
        }
        return ans.reverse().toString();
    }
}
