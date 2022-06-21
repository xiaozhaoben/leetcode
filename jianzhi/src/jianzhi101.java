import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 剑指 Offer II 101. 分割等和子集
* */
public class jianzhi101 {

    /**
     * 未优化
     * @param nums
     * @return
     */
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for(int i = 0; i < nums.length; i++){
//            sum = nums[i] + sum;
//        }
//        if(sum % 2 == 1){
//            return false;
//        }
//        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
//        dp[0][0] = true;
//        for(int i = 1; i < dp.length; i++){
//            dp[i][0] = true;
//            for(int j = 0; j < dp[0].length; j++){
//                if(nums[i - 1] + j <= sum / 2){
//                    dp[i][nums[i - 1] + j] |= dp[i - 1][j];
//                }
//                dp[i][j] |= dp[i - 1][j];
//            }
//        }
//        boolean ans = false;
//        for(int i = 0; i < dp.length; i++){
//            ans |= dp[i][sum / 2];
//        }
//        return ans;
//    }


    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = nums[i] + sum;
        }
        if(sum % 2 == 1){
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for(int i = 1; i <= nums.length; i++){
            for(int j = sum / 2; j >= 0; j--){
                if (j - nums[i - 1] >= 0){
                    dp[j] |= dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        canPartition(new int[]{
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97
        });
    }

}
