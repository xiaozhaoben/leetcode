import java.nio.charset.StandardCharsets;
import java.util.*;

/*
* 735. 行星碰撞
* */
public class leetcode735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < asteroids.length; i++){
            int a = asteroids[i];
            if(a > 0){
                stack.push(a);
            }else{
                boolean flag = true;
                while(!stack.isEmpty()){
                    int b = stack.pop();
                    if(Math.abs(b) > Math.abs(a)){
                        flag = false;
                        stack.push(b);
                        break;
                    }else if(Math.abs(b) == Math.abs(a)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(a);
                }
            }
        }
        while(!stack.isEmpty()){
            list2.add(stack.pop());
        }
        Collections.reverse(list2);
        list.addAll(list2);
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    //官方解答
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int aster : asteroids) {
                boolean alive = true;
                while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                    alive = stack.peek() < -aster; // aster 是否存在
                    if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                        stack.pop();
                    }
                }
                if (alive) {
                    stack.push(aster);
                }
            }
            int size = stack.size();
            int[] ans = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
