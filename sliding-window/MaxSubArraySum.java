public class MaxSubArraySum {
  public static void main(String[] args) {
    int[] nums = {1,2,1,5,1,3,2};
    System.out.println(maxSubArraySum(nums, 3));
  }
  public static int maxSubArraySum(int[] nums,int k){
    int sum = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int i=0;i<k;i++){
      sum+=nums[i];
    }
    maxSum = Math.max(maxSum,sum);
    int left = 0;
    for(int i=k;i<nums.length;i++){
        sum+=nums[i];
        sum-=nums[left++];
        maxSum=Math.max(maxSum,sum);
    }
    return maxSum;
  }
}
