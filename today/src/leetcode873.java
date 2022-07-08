import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 873. 最长的斐波那契子序列的长度
* */
public class leetcode873 {

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int length = arr.length;
        for(int i = 0; i < length; i++){
            map.put(arr[i], i);
        }
        int[][] dp = new int[length + 1][length + 1];
        for(int i = 0; i < length; i++){
            for(int j = i - 1; j >= 0; j--){
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if(k >= 0 && k < j){
                    dp[j][i] = Math.max(dp[j][i], dp[k][j] + 1);
                }
                ans = Math.max(dp[j][i] + 2, ans);
            }
        }
        return ans > 2 ? ans : 0;
    }

}
