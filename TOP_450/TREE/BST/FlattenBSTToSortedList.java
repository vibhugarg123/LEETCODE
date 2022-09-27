package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
    Problem: https://www.geeksforgeeks.org/flatten-bst-to-sorted-list-increasing-order/

    Examples:

    Input:
              5
            /   \
           3     7
          / \   / \
         2   4 6   8
    Output: 2 3 4 5 6 7 8

    Solution:
    1. Create a dummy node.
    2.  Create a variable called ‘prev’ and make it point to the dummy node.
    3. Perform in-order traversal and at each step.
         Set prev -> right = curr
         Set prev -> left = NULL
         Set prev = curr

         dummy->2->3->4->5->6->7->8->null
            |   |  |  |  |  |  |  |
            null...................

    Time Complexity:  O(N)
    Space Complexity: O(H) for recursive stack.

 */
public class FlattenBSTToSortedList {

    TreeNode prev;

    TreeNode flattenBST(TreeNode root) {

        TreeNode dummy = new TreeNode(-1);
        prev = dummy;
        flattenBSTUtils(root);

        //After updating for all nodes in inorder, last node left and right was unchanged
        // Updating last node left and right. Here, after recursion, prev points to last node in inorder traversal.
        prev.left = null;
        prev.right = null;

        //Head of list is dummy.right
        return dummy.right;
    }

    void flattenBSTUtils(TreeNode root) {
        if (null == root) return;
        flattenBSTUtils(root.left);

        if (null != prev) {
            prev.right = root;
            prev.left = null;
        }
        prev = root;

        flattenBSTUtils(root.right);
    }

    void print(TreeNode root) {
        TreeNode temp = root;
        while (null != temp) {
            System.out.print(temp.val + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        FlattenBSTToSortedList flattenBSTToSortedList = new FlattenBSTToSortedList();
        TreeNode list = flattenBSTToSortedList.flattenBST(root);
        flattenBSTToSortedList.print(list);
    }
}