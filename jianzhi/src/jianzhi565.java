import java.util.ArrayList;
import java.util.List;

/*
 * 565. 数组嵌套
 * */
public class jianzhi565 {

    public int arrayNesting(int[] nums) {
        int n = nums.length, max = 0;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[i] > 0) {
                continue;
            }
            if (dp[nums[i]] > 0) {
                dp[i] = dp[nums[i]] + 1;
                max = Math.max(max, dp[i]);
            }
            int j = i, z = 0;
            List<Integer> list = new ArrayList<>();
            while (true) {
                int x = nums[j];
                if (dp[x] == 0) {
                    dp[x]++;
                    list.add(j);
                    j = nums[j];
                    z++;
                } else {
                    break;
                }
            }
            max = Math.max(max, z);
            for (int index : list) {
                dp[index] = z--;
            }
        }
        return max;
    }

    //官方解答
    class Solution {
        public int arrayNesting(int[] nums) {
            int ans = 0, n = nums.length;
            for (int i = 0; i < n; ++i) {
                int cnt = 0;
                while (nums[i] < n) {
                    int num = nums[i];
                    nums[i] = n;
                    i = num;
                    ++cnt;
                }
                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }

}
