import java.util.*;

/*
* 剑指 Offer II 059. 数据流的第 K 大数值
* */
public class jianzhi59 {



    class KthLargest {
        private PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> bigHeap = new PriorityQueue<>((i1, i2) ->{
            return i2 - i1;
        });
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++){
                smallHeap.add(nums[i]);
            }
            for(int i = 1; i <= nums.length - k; i++){
                bigHeap.add(smallHeap.poll());
            }
        }

        public int add(int val) {
            if(smallHeap.size() < k){
                smallHeap.add(val);
            }else if(smallHeap.peek() < val){
                smallHeap.add(val);
                bigHeap.add(smallHeap.poll());

            }else{
                bigHeap.add(val);
            }
            return smallHeap.peek();
        }
    }

//    class KthLargest {
//        PriorityQueue<Integer> pq;
//        int k;
//
//        public KthLargest(int k, int[] nums) {
//            this.k = k;
//            pq = new PriorityQueue<Integer>();
//            for (int x : nums) {
//                add(x);
//            }
//        }
//
//        public int add(int val) {
//            pq.offer(val);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//            return pq.peek();
//        }
//    }


}
