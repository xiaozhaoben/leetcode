import java.util.List;
import java.util.Stack;

/*
 * 636. 函数的独占时间
 * */
public class leetcode636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        for (String log : logs) {
            String[] s = log.split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += Integer.parseInt(s[2]) - pre;
                    pre = Integer.parseInt(s[2]) - 1;
                }
                stack.add(Integer.parseInt(s[0]));
            } else {
                int i = stack.pop();
                if (stack.isEmpty()) {
                    ans[i] += Integer.parseInt(s[2]) - pre + 1;
                } else {
                    ans[i] += Integer.parseInt(s[2]) - pre;
                }
                pre = Integer.parseInt(s[2]) + 1;
            }

        }
        return ans;
    }

}
