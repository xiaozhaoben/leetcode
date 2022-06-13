import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 剑指 Offer II 074. 合并区间
* */
public class jianzhi74 {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals,(a1, a2) -> {
            return a1[0] - a2[0];
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
