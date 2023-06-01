package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

/*
    Problem: Invert Binary Tree: https://leetcode.com/problems/invert-binary-tree/description/
    Algorithm:

    The inverse of an empty tree is the empty tree.
    The inverse of a tree with root r, and subtrees right and left, is a tree with root r,
    whose right subtree is the inverse of left, and whose left subtree is the inverse of right.
 */
public class InvertBinaryTree226 {
    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public TreeNode invertTree(TreeNode root) {
        if (null == root || isLeafNode(root)) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println("Before Tree Inversion");
        root.printLevelOrderTraversal(root);

        root = new InvertBinaryTree226().invertTree(root);
        System.out.println("\nAfter Tree Inversion");
        root.printLevelOrderTraversal(root);
    }
}