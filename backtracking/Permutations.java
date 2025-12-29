import java.util.*;

public class Permutations {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums,boolean[] used,List<Integer> list){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums,used,list);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
