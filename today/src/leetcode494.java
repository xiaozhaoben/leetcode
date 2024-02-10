public class leetcode494 {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    public static int dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length && sum == target) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }
        return dfs(nums, target, index + 1, sum + nums[index]) + dfs(nums, target, index + 1, sum - nums[index]);
    }

}
