package TREE;

import java.util.Arrays;

/*
Input: preorder = [8,5,1,7,10,12] [Root L R]
Output: [8,5,10,1,7,null,12]

        8
      5   10
    1   7    12

Approach-1 : Take one node at a time & construct BST starting from root again.
             Time Complexity: O(N*N)- due to skewed worst case complexity.

Approach-2: Use range property of BST.
The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}.
The first node will definitely be in range, so create a root node.
    To construct the left subtree, set the range as {INT_MIN …root->data}.
        If a value is in the range {INT_MIN .. root->data}, the values are part of the left subtree.
    To construct the right subtree, set the range as {root->data..max .. INT_MAX}.

Time Complexity: O(N)
 */


class BSTFromPreOrderTraversal1008 {

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
        if (preorder.length == 0) {
            return null;
        }

        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BSTFromPreOrderTraversal1008 bstFromPreOrderTraversal1008 = new BSTFromPreOrderTraversal1008();
        int[] preOrder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreOrderTraversal1008.bstFromPreorder(preOrder);
        root.printLevelOrderTraversal(root);
    }
}