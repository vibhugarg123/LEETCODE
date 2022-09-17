package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

/*
    Problem-124: https://leetcode.com/problems/binary-tree-maximum-path-sum/
    Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
    A node can only appear in the sequence at most once.
    Note that the path does not need to pass through the root.

    Example:

    Input: Root of below tree
           1
          / \
         2   3
    Output: 6
    Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

    Input: Root of below tree
          -10
          / \
         9  20
            / \
           15 7
    Input: root = [-10,9,20,null,null,15,7]
    Output: 42
    Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

    Solution:
    For each node there can be four ways that the max path goes through the node:
        1. Node only
        2. Max path through Left Child + Node
        3. Max path through Right Child + Node
        4. Max path through Left Child + Node + Max path through Right Child

        Case-1:  current node either falls in the straight path of max path forming from left or right subtree / or starting path from current node
                 MaximumStraightPath=max(max(left,right)+node.val, node.val)
        Case-2:  If the maximum path is formed from current node
                 M21=max(MaximumStraightPath, left+right+node.val)
        Case-3:  Result=max(result, M21)

        Imp: Function will only return the MaximumStraightPath value.

        Time Complexity: O(N)
        Space Complexity: O(N)
 */
public class BinaryTreeMaximumPathSum124 {

    int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxPathSumUtils(root);
        return result;
    }

    public int maxPathSumUtils(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxPathSumUtils(root.left);
        int right = maxPathSumUtils(root.right);

        int maximumStraightPathSum = Math.max(Math.max(left, right) + root.val, root.val);
        int m21 = Math.max(maximumStraightPathSum, left + right + root.val);

        //Updates result
        result = Math.max(result, m21);
        return maximumStraightPathSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new BinaryTreeMaximumPathSum124().maxPathSum(root));
    }
}