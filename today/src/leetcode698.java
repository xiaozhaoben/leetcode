import java.util.Arrays;

/*
 * 698. 划分为k个相等的子集
 * */
public class leetcode698 {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0 || sum / k < nums[n - 1]) return false;
        Arrays.sort(nums);
        int target = sum / k;
        for (int i = 0; i < k; i++) {
            int a = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (a + nums[j] < target) {
                    a += nums[j];
                    nums[j] = 0;
                } else if (a + nums[j] == target) {
                    a += nums[j];
                    nums[j] = 0;
                    break;
                }
            }
            if (a != target) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

}
