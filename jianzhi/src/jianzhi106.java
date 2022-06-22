/*
* 剑指 Offer II 106. 二分图
* */
public class jianzhi106 {

    public boolean isBipartite(int[][] graph) {
        int[] dp = new int[graph.length];
        boolean ans = true;
        for(int i = 0; i < graph.length; i++){
            ans &= dfs(graph, i, dp, dp[i] == 0 ? 1 : dp[i]);
        }
        return ans;
    }

    public boolean dfs(int[][] graph, int index, int[] dp, int color){
        if(dp[index] == color){
            return true;
        }
        if(dp[index] != 0){
            return false;
        }
        boolean res = true;
        dp[index] = color;
        for(int i = 0; i < graph[index].length; i++){
            res &= dfs(graph, graph[index][i], dp, -color);
        }
        return res;
    }

}
