import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 515. 在每个树行中找最大值
* */
public class leetcode515 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        List<Integer> ans = new ArrayList<>();
        while(queue.size() > 0){
            int size = queue.size();
            int max = queue.peek().val;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }


}
