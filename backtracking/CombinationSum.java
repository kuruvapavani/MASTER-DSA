import java.util.*;
public class CombinationSum{
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(0,target,candidates,new ArrayList<>());
        return ans;
    }

    private void backtrack(int start,int target,int[] candidates,List<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            int c = candidates[i];
            path.add(c);
            backtrack(i,target-c,candidates,path);
            path.remove(path.size()-1);
        }
    }
}