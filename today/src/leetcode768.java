import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 768. 最多能完成排序的块 II
 * */
public class leetcode768 {

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int max = stack.pop();
                while (!stack.isEmpty() && num < stack.peek()) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }

}
