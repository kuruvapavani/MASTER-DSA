
public class CountPairsWithSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5 ,6};
        System.out.println(countPairsWithSum(nums, 7));
    }

    public static int countPairsWithSum(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        //pairs with sum <=k
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= k) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
