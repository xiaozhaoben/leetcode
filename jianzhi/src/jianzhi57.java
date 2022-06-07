import java.util.*;

/*
* 剑指 Offer II 056. 二叉搜索树中两个节点之和
* */
public class jianzhi57 {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k > nums.length - 1){
            k = nums.length - 1;
        }
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j <= i + k && j <= nums.length - 1; j++){
                if(Math.abs((long)nums[i] - (long)nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }

    //滑动窗口
    //floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
    //
    //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> set = new TreeSet<Long>();
            for (int i = 0; i < n; i++) {
                Long ceiling = set.ceiling((long) nums[i] - (long) t);
                if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                    return true;
                }
                set.add((long) nums[i]);
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }

}
