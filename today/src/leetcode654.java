/*
 * 654. 最大二叉树
 * */
public class leetcode654 {

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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode getMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = left, max = nums[left];
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        return new TreeNode(max, getMaximumBinaryTree(nums, left, index - 1), getMaximumBinaryTree(nums, index + 1, right));
    }


}
