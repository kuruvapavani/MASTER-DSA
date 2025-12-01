import java.util.Arrays;

public class TwoSum {
  public static void main(String[] args) {
    int nums[] = {1,2,3,4,5,6,7};
    System.out.println(Arrays.toString(twoSum(nums, 7)));
  }

  public static int[] twoSum(int[] nums,int target){
    int left = 0;
    int right = nums.length-1;
    while(left<right){
        int sum = nums[left]+nums[right];
        if(sum == target){
          return new int[]{left,right};
        }else if(sum<target){
          left++;
        }else{
          right--;
        }
    }
    return new int[]{-1,-1};
  }
}
