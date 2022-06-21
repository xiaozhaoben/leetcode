import java.util.List;

/*
* 剑指 Offer II 100. 三角形中最小路径之和
* */
public class jianzhi100 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            List<Integer> list = triangle.get(i - 1);
            for(int j = 1; j <= i; j++){
                if (j == 1){
                    dp[i][j] = list.get(j - 1) + dp[i - 1][j];
                }else if(j == i){
                    dp[i][j] = list.get(j - 1) + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(list.get(j - 1) + dp[i - 1][j], list.get(j - 1) + dp[i - 1][j - 1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 1; j <= m; j++){
            ans = Math.min(dp[n][j], ans);
        }
        return ans;
    }

}
