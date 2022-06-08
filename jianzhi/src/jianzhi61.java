import java.util.*;

/*
* 剑指 Offer II 061. 和最小的 k 个数对
* */
public class jianzhi61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                heap.add(new int[]{nums1[i],nums2[j],nums1[i] + nums2[j]});
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++){
            if(heap.size() == 0)
                break;
            List<Integer> list = new ArrayList<>();
            list.add(heap.peek()[0]);
            list.add(heap.poll()[1]);
            ans.add(list);
        }
        return ans;
    }


}
