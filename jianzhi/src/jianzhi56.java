import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 剑指 Offer II 056. 二叉搜索树中两个节点之和
* */
public class jianzhi56 {


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

    List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int left = 0, right = list.size() - 1;
        while(left < right){
            int sum = list.get(left) + list.get(right);
            if(sum == k){
                return true;
            }
            if(sum < k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    //hash表解法
    class Solution {
        Set<Integer> set = new HashSet<Integer>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }

}
