package TOP_450.TREE;

/*
     Problem: 110: https://leetcode.com/problems/balanced-binary-tree/
     Given a binary tree, determine if it is height-balanced.

        Example 1:

        Input:
              1
            /
           2
            \
             3
        Output: 0
        Explanation: The max difference in height
        of left subtree and right subtree is 2,
        which is greater than 1. Hence, unbalanced!

        Example 2:

        Input:
               10
             /   \
            20   30
          /   \
         40   60
        Output: 1
        Explanation: The max difference in height
        of left subtree and right subtree is 1.
        Hence, balanced.

     Solution:
         An empty tree is height-balanced. A non-empty binary tree T is balanced if:
            Left subtree of T is balanced
            Right subtree of T is balanced
            The difference between heights of left subtree and the right subtree is not more than 1.

            Time Complexity: O(n)
            Space Complexity: O(n) for recursive stack
 */
public class BalancedBinaryTree110 {
    public int dfsHeight(TreeNode root) {
        if (null == root) return 0;

        int lh = dfsHeight(root.left);
        if (lh == -1) return -1;

        int rh = dfsHeight(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;

        //Return height of current node
        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new BalancedBinaryTree110().isBalanced(root));
    }
}