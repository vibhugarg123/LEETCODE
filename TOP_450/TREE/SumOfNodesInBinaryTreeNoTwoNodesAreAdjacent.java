package TOP_450.TREE;

import java.util.HashMap;

/*
        Problem: https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
        Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that the
        sum of selected nodes is maximum under a constraint that no two chosen nodes in the subset should be directly connected,
        that is, if we have taken a node in our sum then we can’t take any of its children in consideration and vice versa.

                    Input:
                    1
                  /   \
                 2     3
                /     /  \
               4     5    6
            Output: 16
            Explanation: The maximum sum is sum of nodes 1 4 5 6 = 16. These nodes are non-adjacent.

                    Input:
                     11
                    /  \
                   1    2
            Output: 11

            Solution:
            The only choice is either to include current root or not.
            1. If we include current root-
                includeRootSum= root.val +
                                getMaxSum(root.left.left) +
                                getMaxSum(root.left.right) +
                                getMaxSum(root.right.right) +
                                getMaxSum(root.right.left)

            2. If we exclude current root-
                excludeRootSum= getMaxSum(root.left)+ getMaxSum(root.right)

            3. max= Math.max(includeRootSum, excludeRootSum)

            The only way to optimise the repeated getMaxSum() operation is to memoize.
*/
public class SumOfNodesInBinaryTreeNoTwoNodesAreAdjacent {

    int maxSum = Integer.MIN_VALUE;

    //Recursive Approach
    //Time Complexity: 2^n
    int getMaxSumRecursiveApproach(TreeNode root) {
        if (null == root) return 0;

        int includeRoot = root.val +
                (root.left != null ? getMaxSumRecursiveApproach(root.left.left) : 0) +
                (root.left != null ? getMaxSumRecursiveApproach(root.left.right) : 0) +
                (root.right != null ? getMaxSumRecursiveApproach(root.right.right) : 0) +
                (root.right != null ? getMaxSumRecursiveApproach(root.right.left) : 0);

        int excludeRoot = getMaxSumRecursiveApproach(root.left) + getMaxSumRecursiveApproach(root.right);

        return Math.max(includeRoot, excludeRoot);
    }

    //Using DP
    // Time complexity: O(n)
    // Auxiliary Space: O(n)
    int getMaxSum(TreeNode root) {
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        return getMaxSumUtils(root, hm);
    }

    int getMaxSumUtils(TreeNode root, HashMap<TreeNode, Integer> hm) {
        if (null == root) return 0;

        if (hm.containsKey(root)) return hm.get(root);

        int includeRoot = root.val;
        if (null != root.left) {
            includeRoot += getMaxSumUtils(root.left.left, hm);
            includeRoot += getMaxSumUtils(root.left.right, hm);
        }
        if (null != root.right) {
            includeRoot += getMaxSumUtils(root.right.left, hm);
            includeRoot += getMaxSumUtils(root.right.right, hm);
        }

        int excludeRoot = getMaxSumUtils(root.left, hm) + getMaxSumUtils(root.right, hm);

        hm.put(root, Math.max(includeRoot, excludeRoot));

        return hm.get(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(new SumOfNodesInBinaryTreeNoTwoNodesAreAdjacent().getMaxSum(root));
    }
}