/*
* 剑指 Offer II 070. 排序数组中只出现一次的数字
* */
public class jianzhi70 {

    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }


}
