
import java.util.HashMap;

public class ContainsDuplicateII {
  public static void main(String[] args) {
    int[] nums = {1,2,3,1,0};
    System.out.println(containsDuplicateII(nums, 2));
  }

  private static boolean containsDuplicateII(int[] nums,int k){
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
      if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k) return true;
      map.putIfAbsent(nums[i], i);
    }
    return false;
  }
}
