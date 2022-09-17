package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

/*
    Problem-606: https://leetcode.com/problems/construct-string-from-binary-tree/
            Input : Preorder: [1, 2, 3, 4]
               1
             /   \
            2     3
           /
          4
        Output: "1(2(4))(3)"
        Explanation: Originally it needs to be "1(2(4)
        ())(3()())", but we need to omit all the
        unnecessary empty parenthesis pairs.
        And it will be "1(2(4))(3)".

        Input : Preorder: [1, 2, 3, null, 4]
               1
             /   \
            2     3
             \
              4
        Output: "1(2()(4))(3)"

        Solution:
        For every node encountered, the following cases are possible.

            Case 1: Both the left child and the right child exist for the current node.
                    In this case, we need to put the braces () around both the left child’s preorder traversal output and
                    the right child’s preorder traversal output.
            Case 2: None of the left or the right child exist for the current node. Considering empty braces for the null left and
                    right children is redundant. Hence, we need not put braces for any of them.
            Case 3: Only the left child exists for the current node. Putting empty braces for the right child in this case is unnecessary
                    while considering the preorder traversal. This is because the right child will always
                    come after the left child in the preorder traversal.
                    Thus, omitting the empty braces for the right child also leads to same mapping between the string and the binary tree.
            Case 4: Only the right child exists for the current node. In this case,
                    we need to consider the empty braces for the left child. This is because,
                    during the preorder traversal, the left child needs to be considered first.
                    Thus, to indicate that the child following the current node is a
                    right child we need to put a pair of empty braces for the left child.

           Complexity Analysis:
                - Time complexity : O(n). The preorder traversal is done over the n nodes of the given Binary Tree.
                - Space complexity : O(n). The depth of the recursion tree can go upto n in case of a skewed tree.
 */
public class BinaryTreeToString606 {

    public String tree2str(TreeNode root) {
        if (null == root)
            return "";
        // Is leaf node
        if (root.left == null && root.right == null)
            return root.val + "";
        // only left node present
        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";
        // both left node & right node are present || only right node is present
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        System.out.println(new BinaryTreeToString606().tree2str(root));
    }
}