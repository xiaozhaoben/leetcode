import java.util.ArrayList;
import java.util.List;

/*
 * 1282. 用户分组
 * */
public class leetcode1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Integer>[] sign = new ArrayList[groupSizes.length + 1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (sign[groupSizes[i]] == null) {
                sign[groupSizes[i]] = new ArrayList<>();
            }
            sign[groupSizes[i]].add(i);
            if (sign[groupSizes[i]].size() == groupSizes[i]) {
                ans.add(new ArrayList<>(sign[groupSizes[i]]));
                sign[groupSizes[i]] = null;
            }
        }
        return ans;
    }


}
