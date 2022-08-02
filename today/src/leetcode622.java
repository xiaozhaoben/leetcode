import java.util.Arrays;

/*
 * 622. 设计循环队列
 * */
public class leetcode622 {

    static class MyCircularQueue {

        Integer[] queue;
        int size;
        int left, right;

        public MyCircularQueue(int k) {
            queue = new Integer[k];
            size = 0;
            left = -1;
            right = -1;
        }

        public boolean enQueue(int value) {
            if (queue.length <= size) return false;
            right++;
            right = right % queue.length;
            queue[right] = value;
            size++;
            right = right % queue.length;
            return true;
        }

        public boolean deQueue() {
            if (size == 0) return false;
            left++;
            left = left % queue.length;
            queue[left] = null;
            size--;
            return true;
        }

        public int Front() {
            if (size == 0) return -1;
            return left + 1 == queue.length ? queue[0] : queue[left + 1];
        }

        public int Rear() {
            if (size == 0) return -1;
            return queue[right];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }

        @Override
        public String toString() {
            return "MyCircularQueue{" +
                    "queue=" + Arrays.toString(queue) +
                    ", size=" + size +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(9);
        myCircularQueue.enQueue(5);
        myCircularQueue.enQueue(0);
        myCircularQueue.deQueue();
        myCircularQueue.deQueue();
        System.out.println(myCircularQueue.toString());
    }

}
