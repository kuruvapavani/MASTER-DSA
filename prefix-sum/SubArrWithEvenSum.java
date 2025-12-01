
public class SubArrWithEvenSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subArrWithEvenSum(nums));
    }

    public static int subArrWithEvenSum(int[] nums) {
        int even = 1, odd = 0;
        int prefix = 0, count = 0;
        for (int num : nums) {
            prefix += num;
            if (prefix % 2 == 0) {
                count += even;
                even++;
            } else {
                count += odd;
                odd++;
            }
        }
        return count;
    }


}
