package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
        Problem:
        Given a Binary Search Tree. The task is to find the minimum element in this given BST.

        Example 1:

        Input:
                   5
                 /    \
                4      6
               /        \
              3          7
             /
            1
        Output: 1


        Time Complexity: O(n) Worst case happens for left skewed trees.
        Similarly, we can get the maximum value by recursively traversing the right node of a binary search tree.

        Space complexity: O(n) for stack space, since using recursion
 */

public class MinimumInBST {

    int minValue = Integer.MAX_VALUE;

    int minValue(TreeNode root) {
        if (null == root)
            return -1;
        minValueUtils(root);
        return minValue;
    }

    void minValueUtils(TreeNode root) {
        if (null == root)
            return;
        if (root.val < minValue) {
            minValue = root.val;
        }
        minValueUtils(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println(new MinimumInBST().minValue(root));
    }
}