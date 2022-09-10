/*
 * 669. 修剪二叉搜索树
 * */
public class leetcode669 {

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


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root != null && root.val < low) {
            root = trimBST(root.right, low, high);
        }
        if (root != null && root.val > high) {
            root = trimBST(root.left, low, high);
        }
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            if (root.left.val < low) {
                root.left = trimBST(root.left.right, low, high);
            } else {
                root.left = trimBST(root.left, low, high);
            }
        }
        if (root.right != null) {
            if (root.right.val > high) {
                root.right = trimBST(root.right.left, low, high);
            } else {
                root.right = trimBST(root.right, low, high);
            }
        }
        return root;
    }

    //官方解答
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (root.val < low) {
                return trimBST(root.right, low, high);
            } else if (root.val > high) {
                return trimBST(root.left, low, high);
            } else {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            }
        }
    }
}
