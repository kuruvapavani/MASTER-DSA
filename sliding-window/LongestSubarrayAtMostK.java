
public class LongestSubarrayAtMostK {

    public static void main(String[] args) {
      int[] nums = {2,1,5,1,3,2};
      System.out.println(longestSubarrayAtMostK(nums, 7));
    }

    public static int longestSubarrayAtMostK(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int sum = 0;
        for(int right=0;right<nums.length;right++){
          sum+=nums[right];
          while(sum>k){
            sum-=nums[left++];
          }
          maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

}
