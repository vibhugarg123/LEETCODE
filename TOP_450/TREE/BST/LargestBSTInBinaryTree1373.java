package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
        Problem: https://practice.geeksforgeeks.org/problems/largest-bst/1
                 https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
        Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
        Note: Here Size is equal to the number of nodes in the subtree.

        Example 1:

        Input:
                1
              /   \
             4     4
           /   \
          6     8
        Output: 1
        Explanation: There's no subtree with size
        greater than 1 which forms a BST. All the
        leaf Nodes are the BSTs with size equal
        to 1.

        Solution:
        A Tree is BST if following is true for every node x.
       -  The largest value in left subtree (of x) is smaller than value of x.
       -  The smallest value in right subtree (of x) is greater than value of x.
        We traverse tree in bottom up manner. For every traversed node, we return maximum and minimum values in subtree rooted with it.

        Time Complexity: O(N)
        Space Complexity: O(N)
 */
public class LargestBSTInBinaryTree1373 {
    static class NodeInfo {
        int size; // Size of subtree
        boolean isBST; // If subtree is BST
        int max; // Min value in subtree
        int min; // Max value in subtree

        int sum;

        int maxSum;

        NodeInfo() {
        }

        NodeInfo(int size, int min, int max, boolean isBST, int sum, int maxSum) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.sum = sum;
            this.maxSum = maxSum;
        }
    }

    void largestBst(TreeNode root) {
        NodeInfo nodeInfo = largestBSTUtils(root, 0);
        System.out.println("Maximum Size BST " + nodeInfo.size);
        System.out.println("Maximum Sum BST " + nodeInfo.maxSum);
    }

    NodeInfo largestBSTUtils(TreeNode root, int maxSum) {
        if (null == root) return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0, maxSum);

        NodeInfo left = largestBSTUtils(root.left, maxSum);
        NodeInfo right = largestBSTUtils(root.right, maxSum);

        NodeInfo returnInfo = new NodeInfo();
        returnInfo.min = Math.min(left.min, root.val);
        returnInfo.max = Math.max(right.max, root.val);
        returnInfo.sum = root.val + left.sum + right.sum;
        returnInfo.isBST = left.isBST &&
                right.isBST &&
                root.val > left.max
                && root.val < right.min;
        returnInfo.maxSum = Math.max(left.maxSum, right.maxSum);

        if (returnInfo.isBST) {
            returnInfo.size = 1 + left.size + right.size;
            returnInfo.maxSum = Math.max(returnInfo.sum, returnInfo.maxSum);
        } else {
            returnInfo.size = Math.max(left.size, right.size);
        }

        return returnInfo;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(9);

        new LargestBSTInBinaryTree1373().largestBst(root);
    }
}