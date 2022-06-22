/*
* 剑指 Offer II 103. 最少的硬币数目
* */
public class jianzhi103 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int j = 1; j <= amount; j++){
            dp[j] = amount + 1;
        }
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i] >= 0){
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
