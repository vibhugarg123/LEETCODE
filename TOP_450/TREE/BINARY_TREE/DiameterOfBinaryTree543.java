package TOP_450.TREE.BINARY_TREE;
/*
Problem 543: https://leetcode.com/problems/diameter-of-binary-tree/
    Given the root of a binary tree, return the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    The length of a path between two nodes is represented by the number of edges between them.

    Example 1:

    Input: root = [1,2,3,4,5]
                      1
                    /  \
                   2    3
                 /  \
                4   5
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

    Example 2:
    Input: root = [1,2]
    Output: 1

    Solution:
        The diameter of a tree T is the largest of the following quantities:
        - the diameter of T’s left subtree.
        - the diameter of T’s right subtree.
        - the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
        Time Complexity: O(n2)
        Space Complexity: O(n)
*/

public class DiameterOfBinaryTree543 {
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), (height(root.right))) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree543 diameterOfBinaryTree543 = new DiameterOfBinaryTree543();
        System.out.println(diameterOfBinaryTree543.diameterOfBinaryTree(root));
    }
}