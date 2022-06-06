/*
* 剑指 Offer II 052. 展平二叉搜索树
* */
public class jianzhi52 {


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

    TreeNode ans = new TreeNode(0);

    TreeNode pre = ans;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return ans.right;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);
        pre.right = new TreeNode(root.val);
        pre = pre.right;
        dfs(root.right);
    }

}
