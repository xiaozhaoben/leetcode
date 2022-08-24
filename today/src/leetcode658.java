import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 658. 找到 K 个最接近的元素
 * */
public class leetcode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i], Math.abs(arr[i] - x)});
        }
        list.sort((l1, l2) -> {
            if (l1[1] == l2[1]) {
                return l1[0] - l2[0];
            }
            return l1[1] - l2[1];
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i)[0]);
        }
        ans.sort(Comparator.comparingInt(a -> a));
        return ans;
    }

    //官方解答
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }

}
