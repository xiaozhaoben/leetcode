import java.util.ArrayDeque;
import java.util.Deque;

/*
* 剑指 Offer II 054. 所有大于等于节点的值之和
* */
public class jianzhi54 {


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

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

}
