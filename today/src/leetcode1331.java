import java.util.*;

/*
 * 1331. 数组序号转换
 * */
public class leetcode1331 {

    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(set);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 1;
        while (heap.peek() != null) {
            map.put(heap.poll(), i++);
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] = map.get(arr[j]);
        }
        return arr;
    }
}
