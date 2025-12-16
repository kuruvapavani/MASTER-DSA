import java.util.HashMap;

public class CountSubarrays {
  public static void main(String[] args) {
    int[] nums = {1,2,3};
      System.out.println(countSubarrays(nums, 3));
  }
  public static int countSubarrays(int[] nums, int k){
    int count = 0;
    int prefix = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    for(int num:nums){
      prefix+=num;
      if(map.containsKey(prefix-k)){
        count+=map.get(prefix-k);
      }
      map.put(prefix, map.getOrDefault(prefix, 0)+1);
    }
    return count;
  }
}
