import java.util.Arrays;

/*
* 324. 摆动排序 II
* */
public class leetcode324 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] a = Arrays.copyOf(nums,nums.length);
        int small = (nums.length + 1) / 2 - 1, big = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            nums[i] = a[small--];
            if(++i < nums.length){
                nums[i] =a[big--];
            }
        }
    }

}
