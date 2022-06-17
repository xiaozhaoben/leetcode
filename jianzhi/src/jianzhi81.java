import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* 剑指 Offer II 081. 允许重复选择元素的组合
* */
public class jianzhi81 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] candidates, int target, int index, int sum, List<Integer> path){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(sum > target && index == candidates.length - 1){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(sum + candidates[i] <= target){
                path.add(candidates[i]);
                sum += candidates[i];
                dfs(candidates, target, i, sum, path);
                sum -= candidates[i];
                path.remove(path.size() - 1);
            }
        }
    }
}
