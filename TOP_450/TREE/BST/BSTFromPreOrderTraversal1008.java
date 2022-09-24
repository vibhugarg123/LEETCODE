package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
        Problem- 1008: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

        Solution:  ( O(n) time complexity )

        The trick is to set a range {min ... max} for every node.
        Initialize the range as {INT_MIN .. INT_MAX}.
        The first node will definitely be in range, so create a root node.
            - To construct the left subtree, set the range as {INT_MIN …root->data}.
                - If a value is in the range {INT_MIN .. root->data}, the values are part of the left subtree.
             -To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
 */
public class BSTFromPreOrderTraversal1008 {

    private int currentIndex = 0;

    private TreeNode constructBST(int[] preOrder, int min, int max) {
        //boundary case- if the preOrder array is traversed completely OR the current element is out of range.
        if (currentIndex >= preOrder.length || preOrder[currentIndex] < min || preOrder[currentIndex] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[currentIndex++]);

        root.left = constructBST(preOrder, min, root.val);
        root.right = constructBST(preOrder, root.val, max);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[] preOrder = {8, 5, 1, 7, 10, 12};
        TreeNode root = new BSTFromPreOrderTraversal1008().bstFromPreorder(preOrder);
        root.preOrderTraversal(root);
    }
}