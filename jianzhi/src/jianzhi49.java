import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class jianzhi49 {


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

    public int sumNumbers(TreeNode root) {
        backtrack(root, "");
        return sum;
    }

    public void backtrack(TreeNode root, String str){
        if(root == null){
            return;
        }
        str = str + root.val;
        backtrack(root.left, str);
        backtrack(root.right, str);
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(str);
        }
    }

    //Leetcode
//    public int sumNumbers(TreeNode root) {
//        return dfs(root, 0);
//    }
//
//    public int dfs(TreeNode root, int prevSum) {
//        if (root == null) {
//            return 0;
//        }
//        int sum = prevSum * 10 + root.val;
//        if (root.left == null && root.right == null) {
//            return sum;
//        } else {
//            return dfs(root.left, sum) + dfs(root.right, sum);
//        }
//    }
}
