import java.util.ArrayList;
import java.util.List;

/*
* 剑指 Offer II 055. 二叉搜索树迭代器
* */
public class jianzhi55 {


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

    class BSTIterator {

        private List<Integer> list = new ArrayList<>();
        private int index = 0;

        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        public void dfs(TreeNode root){
            if(root == null){
                return;
            }
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            if(index >= list.size()){
                return false;
            }
            return true;
        }
    }

}
