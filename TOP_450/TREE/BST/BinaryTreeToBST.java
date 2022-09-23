package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
        Problem: https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
        Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.


            Example 1:

            Input:
                  1
                /   \
               2     3

            Output: 1 2 3

            Solution:

            Following is a 3-step solution for converting Binary tree to Binary Search Tree.
               1.  Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
               2.  Sort the temp array arr[]. O(nlog(n))
               3. Again do inorder traversal of tree and copy array elements to tree nodes one by one. This step takes O(n) time.
 */

public class BinaryTreeToBST {
    int index = 0;

    TreeNode binaryTreeToBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        storeInorder(root, inorder);

        Collections.sort(inorder);
        index = 0;
        convertBinaryTreeToBST(root, inorder);
        return root;
    }

    private void convertBinaryTreeToBST(TreeNode root, List<Integer> inorder) {
        if (null == root || index >= inorder.size()) return;

        convertBinaryTreeToBST(root.left, inorder);
        root.val = inorder.get(index++);
        convertBinaryTreeToBST(root.right, inorder);
    }

    private void storeInorder(TreeNode root, List<Integer> inorder) {
        if (null == root) return;
        storeInorder(root.left, inorder);
        inorder.add(root.val);
        storeInorder(root.right, inorder);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BinaryTreeToBST binaryTreeToBST = new BinaryTreeToBST();
        root.inorderTraversal(root);
        root = binaryTreeToBST.binaryTreeToBST(root);
        root.inorderTraversal(root);
    }
}