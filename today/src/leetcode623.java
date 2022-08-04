import java.util.LinkedList;
import java.util.Queue;

/*
 * 623. 在二叉树中增加一行
 * */
public class leetcode623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newRoot = root;
        Queue<TreeNode> queue = new LinkedList<>();
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val, root, null);
            return newNode;
        }
        if (newRoot != null) {
            queue.add(newRoot);
        }
        int i = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (++i == depth) {
                for (int j = 0; j < size; j++) {
                    TreeNode node = queue.poll();
                    TreeNode newNode = new TreeNode(val, node.left, null);
                    node.left = newNode;
                    newNode = new TreeNode(val, null, node.right);
                    node.right = newNode;
                }
                break;
            } else {
                for (int j = 0; j < size; j++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return root;
    }

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

}
