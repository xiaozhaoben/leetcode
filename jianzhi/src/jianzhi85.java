import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
* 剑指 Offer II 078. 合并排序链表
* */
public class jianzhi85 {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void backtrack(int n, int left, int right, StringBuilder sb){
        if(n == right){
            ans.add(sb.toString());
        }
        if(left > right){
            backtrack(n, left, right + 1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
        if(left < n){
            backtrack(n, left + 1, right, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
