package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
        Problem-230: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

        Given a BST and an integer K. Find the Kth Smallest element in the BST.

        Example 1:

        Input:
              2
            /   \
           1     3
        K = 2
        Output: 2

        The Inorder Traversal of a BST traverses the nodes in increasing order.
        So the idea is to traverse the tree in Inorder. While traversing, keep track of the count of the nodes visited.
        If the count becomes k, return the node.
         (O(n) time and O(h) auxiliary space)
 */

public class KthSmallestElementBST {

        int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (null == root) return -1;

        int x = kthSmallest(root.left, k);

        if (x != -1) return x;

        counter++;
        if (counter == k) return root.val;

        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(new KthSmallestElementBST().kthSmallest(root, 1));
    }
}