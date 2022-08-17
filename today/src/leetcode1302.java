import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 1302. 层数最深叶子节点的和
 * */
public class leetcode1302 {

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

    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            int sum = 0;
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                sum = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return sum;
        }
    }

}
