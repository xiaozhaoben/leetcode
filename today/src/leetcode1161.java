import java.util.LinkedList;
import java.util.Queue;

/*
 * 1161. 最大层内元素和
 * */
public class leetcode1161 {

    class TreeNode {
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

    public int maxLevelSum(TreeNode root) {
        int max = 0, layer = 1;
        if (root == null) {
            return -1;
        }
        max = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int j = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (max < sum) {
                layer = j;
                max = sum;
            }
            j++;
        }
        return layer;
    }
}
