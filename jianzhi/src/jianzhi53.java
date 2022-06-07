import java.util.ArrayDeque;
import java.util.Deque;

/*
* 剑指 Offer II 053. 二叉搜索树中的中序后继
* */
public class jianzhi53 {


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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while(root != null){
            if(root.val > p.val){
                ans = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ans;
    }

    //非递归中序遍历
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            TreeNode prev = null, curr = root;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                if (prev == p) {
                    return curr;
                }
                prev = curr;
                curr = curr.right;
            }
            return null;
        }
    }

}
