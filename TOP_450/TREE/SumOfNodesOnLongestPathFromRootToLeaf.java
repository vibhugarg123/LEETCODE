package TOP_450.TREE;

/*
        Problem- https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
        Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
        If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

            Example 1:

            Input:
                    4
                   / \
                  2   5
                 / \ / \
                7  1 2  3
                  /
                 6
            Output: 13
            Explanation:
                    4
                   / \
                  2   5
                 / \ / \
                7  1 2  3
                  /
                 6

            The highlighted nodes (4, 2, 1, 6) above are
            part of the longest root to leaf path having
            sum = (4 + 2 + 1 + 6) = 13
            Example 2:

            Input:
                      1
                    /   \
                   2     3
                  / \   / \
                 4   5 6   7
            Output: 11
 */
public class SumOfNodesOnLongestPathFromRootToLeaf {
    int maxLevel = 0;
    int maxSum = 0;

    public int sumOfLongRootToLeafPath(TreeNode root) {
        sumOfLongRootToLeafPath(root, 0, 0);
        return maxSum;
    }

    public void sumOfLongRootToLeafPath(TreeNode root, int sum, int level) {
        if (root == null) {
            return;
        }

        // If the current node is leaf and maxLevel < current level, update maxLevel and maxSum.
        if (null == root.left && null == root.right && maxLevel <= level) {
            maxSum = Math.max(maxSum, root.val + sum);
            maxLevel = level;
        }


        //Traverse left subtree recursively
        sumOfLongRootToLeafPath(root.left, root.val + sum, level + 1);
        //Traverse left subtree recursively
        sumOfLongRootToLeafPath(root.right, root.val + sum, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(new SumOfNodesOnLongestPathFromRootToLeaf().sumOfLongRootToLeafPath(root));
    }

}