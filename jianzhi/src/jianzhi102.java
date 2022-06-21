/*
* 剑指 Offer II 102. 加减的目标值
* */
public class jianzhi102 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum < target || -sum > target){
            return 0;
        }
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= sum * 2; j++){
                if(j - nums[i - 1] >= 0){
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if(j + nums[i - 1] <= sum * 2){
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        // for(int i = 0; i <= nums.length; i++){
        //     for(int j = 0; j <= sum * 2; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[nums.length][sum + target];
    }

}
