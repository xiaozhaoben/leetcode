import java.util.Arrays;

/*
 * 1608. 特殊数组的特征值
 * */
public class leetcode1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] >= n) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            if (nums[n - i] >= i && nums[n - 1 - i] < i) {
                return i;
            }
        }
        return -1;
    }


}
