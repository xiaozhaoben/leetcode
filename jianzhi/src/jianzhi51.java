import java.util.HashMap;
import java.util.Map;

/*
* 剑指 Offer II 051. 节点之和最大的路径
* */
public class jianzhi51 {


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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum = 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        sum = root.val + left + right;
        max = Math.max(sum, max);
        return root.val + Math.max(left, right);
    }

}
