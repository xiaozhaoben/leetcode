import java.util.HashMap;
import java.util.Map;

/*
 * 662. 二叉树最大宽度
 * */
public class leetcode662 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }


}
