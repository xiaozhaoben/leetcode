/*
 * 1413. 逐步求和得到正数的最小值
 * */
public class leetcode1413 {

    public int minStartValue(int[] nums) {
        int min = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(sum, min);
        }
        return min < 0 ? -min + 1 : 1;
    }
}
