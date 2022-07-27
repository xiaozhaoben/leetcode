import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 919. 完全二叉树插入器
 * */
public class leetcode919 {

    class CBTInserter {

        TreeNode root;
        List<Integer> list = new ArrayList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        public int insert(int val) {
            int parent = list.size() % 2 == 0 ? (list.size() - 1) / 2 : list.size() / 2;
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            int i = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (i++ == parent) {
                    if (node.left == null) {
                        node.left = new TreeNode(val, null, null);
                        break;
                    }
                    if (node.right == null) {
                        node.right = new TreeNode(val, null, null);
                        break;
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(val);
            return list.get(parent);
        }

        public TreeNode get_root() {
            return root;
        }
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
