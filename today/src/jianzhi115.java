import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 115. 重建序列
 *
 * @author xiao__zhao
 */
public class jianzhi115 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] path = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            map.put(nums[i - 1], nums[i]);
        }
        for (int[] sequence : sequences) {
            for (int j = 1; j < sequence.length; j++) {
                if (map.get(sequence[j - 1]) == sequence[j]) {
                    path[sequence[j]] = 1;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += path[i];
        }
        return sum == n - 1;
    }
}
