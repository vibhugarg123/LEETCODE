package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

/*
Problem-101 : https://leetcode.com/problems/symmetric-tree/
        Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTreeAroundCenter101 {

    private boolean isSymmetricUtils(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (right == null || left == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        return isSymmetricUtils(left.left, right.right) && isSymmetricUtils(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetricUtils(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);

        SymmetricTreeAroundCenter101 symmetricTreeAroundCenter101 = new SymmetricTreeAroundCenter101();
        System.out.println(symmetricTreeAroundCenter101.isSymmetric(root));
    }
}