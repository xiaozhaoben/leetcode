import java.util.Deque;
import java.util.LinkedList;

/*
 * 946. 验证栈序列
 * */
public class leetcode946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int push = 0, pop = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (push < pushed.length) {
            if (stack.isEmpty() || stack.peek() != popped[pop]) {
                stack.push(pushed[push++]);
            } else {
                stack.pop();
                pop++;
            }
        }
        while (pop < pushed.length) {
            if (stack.peek() != popped[pop++]) {
                break;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
