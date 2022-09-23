package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
        Problem: 1382- https://leetcode.com/problems/balance-a-binary-search-tree/

        Solution:
        1. Traverse given BST in inorder and store result in an array. This step takes O(n) time.
        2. Use middle element concept to construct the BST so that it's height balanced.
        Time Complexity: O(N) for inorder traversal + O(N) to construct new height balanced BST.

 */
public class BalanceABinarySearchTree1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        storeInorder(root, inorder);

        return balanceBSTUtils(inorder, 0, inorder.size() - 1);
    }

    private TreeNode balanceBSTUtils(List<Integer> inorder, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;

        TreeNode temp = new TreeNode(inorder.get(mid));

        temp.left = balanceBSTUtils(inorder, start, mid - 1);
        temp.right = balanceBSTUtils(inorder, mid + 1, end);
        return temp;
    }

    private void storeInorder(TreeNode root, List<Integer> inorder) {
        if (null == root) return;
        storeInorder(root.left, inorder);
        inorder.add(root.val);
        storeInorder(root.right, inorder);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);

        BalanceABinarySearchTree1382 balanceABinarySearchTree1382 = new BalanceABinarySearchTree1382();
        root = balanceABinarySearchTree1382.balanceBST(root);
        root.preOrderTraversal(root);
    }
}