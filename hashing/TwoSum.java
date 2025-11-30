
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    int[] nums={2,7,11,15};
    System.out.println(Arrays.toString(twoSum(nums, 9)));
  }

  public static int[] twoSum(int[] nums,int target){
    if(nums.length<2) return new int[]{-1,-1};
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
        if(map.containsKey(target-nums[i])){
          return new int[]{map.get(target-nums[i]),i};
        }
        map.put(nums[i],i);
    }
    return new int[]{-1,-1};
  }
}
