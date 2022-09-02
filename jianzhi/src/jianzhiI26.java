/*
 * 剑指 Offer 26. 树的子结构
 * */
public class jianzhiI26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean flag = false;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        dfs(A, B);
        return flag;
    }

    public void dfs(TreeNode A, TreeNode B) {
        if (A == null) {
            return;
        }
        dfs(A.left, B);
        dfs(A.right, B);
        if (A.val == B.val) {
            flag |= dfsEachTree(A, B);
        }
    }

    public boolean dfsEachTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        } else if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return dfsEachTree(A.left, B.left) & dfsEachTree(A.right, B.right);
    }
}
