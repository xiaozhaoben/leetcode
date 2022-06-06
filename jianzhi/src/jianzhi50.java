import java.util.HashMap;
import java.util.Map;

/*
* 剑指 Offer II 050. 向下的路径节点之和
* */
public class jianzhi50 {


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

    /**
     * 前缀和解法
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, targetSum, 0, map);
    }

    public int dfs(TreeNode root, int targetSum, int cur, Map<Integer, Integer> map){
      if(root == null){
          return 0;
      }
      int sum = 0;
      cur += root.val;
      sum = map.getOrDefault(cur - targetSum, 0);
      map.put(cur,map.getOrDefault(cur, 0) + 1);
      sum += dfs(root.left, targetSum, cur, map);
      sum += dfs(root.right, targetSum, cur, map);
      map.put(cur, map.getOrDefault(cur, 0) - 1);
      return sum;
    }

}
