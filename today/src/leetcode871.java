/*
* 871. 最低加油次数
* */
public class leetcode871 {

    //递归
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return dfs(0, startFuel, stations, 0, target);
    }

    public int dfs(int index, int fuel, int[][] stations, int sum, int target){
        if(index >= target){
            return sum;
        }
        int res = Integer.MAX_VALUE;
        if(fuel > 0){
            res = Math.min(dfs(index + fuel, 0, stations, sum, target), res);
        }
        for(int i = 0; i < stations.length; i++){
            if(stations[i][0] > index && stations[i][0] <= index + fuel){
                res = Math.min(dfs(stations[i][0], fuel - stations[i][0] + index + stations[i][1], stations, sum + 1, target),res);
            }
            if(fuel == 0 && stations[i][0] == index){
                res = Math.min(dfs(stations[i][0], stations[i][1], stations, sum + 1, target), res);
            }
            if(stations[i][0] > index + fuel){
                break;
            }
        }
        return res;
    }

    //官方解答
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            int n = stations.length;
            long[] dp = new long[n + 1];
            dp[0] = startFuel;
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    if (dp[j] >= stations[i][0]) {
                        dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                    }
                }
            }
            for (int i = 0; i <= n; i++) {
                if (dp[i] >= target) {
                    return i;
                }
            }
            return -1;
        }
    }

}
