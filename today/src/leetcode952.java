import java.util.*;

/*
 * 873. 最长的斐波那契子序列的长度
 * */
public class leetcode952 {

    public static int largestComponentSize(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] path = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            path[i] = new ArrayList<>();
        }
        boolean[] dp = new boolean[n];
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= Math.sqrt(nums[j]); i++) {
                if (nums[j] % i == 0) {
                    Integer x = map.get(nums[j] / i), y = map.get(i);
                    if (x != null) {
                        if (!path[x].contains(j)) {
                            path[x].add(j);
                            path[j].add(x);
                        }
                    }
                    if (y != null && i != 1) {
                        if (!path[y].contains(j)) {
                            path[y].add(j);
                            path[j].add(y);
                        }
                    }
                    map.put(nums[j] / i, j);
                    map.put(i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {

//            System.out.println(Arrays.toString(path[i].toArray()));
//            System.out.println(Arrays.toString(dp));
            if (dp[i]) {
                continue;
            }
            ans = Math.max(check(path, i, dp, 0), ans);
        }
        return ans;
    }

    public static int check(List<Integer>[] path, int i, boolean[] dp, int max) {
        List<Integer> nexts = path[i];
        for (Integer next : nexts) {
            if (!dp[next]) {
                dp[next] = true;
                max = check(path, next, dp, max + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestComponentSize(new int[]{20, 50, 9, 63}));
    }

}
