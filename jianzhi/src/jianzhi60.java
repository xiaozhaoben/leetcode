import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
* 剑指 Offer II 060. 出现频率最高的 k 个数字
* */
public class jianzhi60 {

    class frequent{
        private Integer num;
        private Integer sum;

        public Integer getNum() {
            return num;
        }

        public Integer getSum() {
            return sum;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public void setSum(Integer sum) {
            this.sum = sum;
        }

        public frequent(Integer num, Integer sum) {
            this.num = num;
            this.sum = sum;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<frequent> heap = new PriorityQueue<>((f1, f2) ->{
            return f2.getSum() - f1.getSum();
        });
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> integers = map.keySet();
        for (Integer i : integers){
            heap.add(new frequent(i, map.get(i)));
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++){
            ans[i] = heap.poll().getNum();
        }
        return ans;
    }


}
