import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 *
 * @author xiao__zhao
 */
public class jianzhi41 {

    class MovingAverage {

        Queue<Integer> queue = new LinkedList<>();
        int size = 0;
        double sum = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            sum += val;
            queue.add(val);
            return sum / queue.size();
        }
    }
}
