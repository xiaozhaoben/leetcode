import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* 剑指 Offer II 088. 爬楼梯的最少成本
* */
public class jianzhi88 {

    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[2];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= cost.length; i++){
            int next = Math.min(dp[0] + cost[i - 2], dp[1] + cost[i - 1]);
            dp[0] = dp[1];
            dp[1] = next;
        }
        return dp[1];
    }
}
