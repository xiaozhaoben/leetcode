import java.util.HashMap;
import java.util.Map;

/*
* 剑指 Offer II 068. 查找插入位置
* */
public class jianzhi68 {

    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return left;

    }


}
