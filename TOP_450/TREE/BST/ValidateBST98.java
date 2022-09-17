package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
        Problem-98: https://leetcode.com/problems/validate-binary-search-tree/

        Let's use the order of nodes in the inorder traversal LNR.
            - Compute inorder traversal list inorder.
            - Check if each element in inorder is smaller than the next one.
            Complexity Analysis

        Time complexity : O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.
        Space complexity : O(N) for the space on the run-time stack.
 */
public class ValidateBST98 {

    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;

        if (!inorder(root.left)) return false;

        if (prev != null && root.val <= prev) return false;

        prev = root.val;
        return inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(new ValidateBST98().isValidBST(root));
    }
}