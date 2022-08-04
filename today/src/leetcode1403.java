import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1403. 非递增顺序的最小子序列
 * */
public class leetcode1403 {

    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int sum2 = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            sum2 += nums[i];
            sum -= nums[i];
            ans.add(nums[i]);
            if (sum2 > sum) {
                break;
            }
        }
        return ans;
    }
}
