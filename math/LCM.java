
public class LCM {

    public static void main(String[] args) {
        System.out.println(lcm(6,3));
    }

    public static int lcm(int a, int b) {
        return (a*b) / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
