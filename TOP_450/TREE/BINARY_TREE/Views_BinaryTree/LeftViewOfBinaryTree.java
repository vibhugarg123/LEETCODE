package TOP_450.TREE.BINARY_TREE.Views_BinaryTree;

import TOP_450.TREE.BINARY_TREE.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
        Problem: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
        Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side.

        Left view of following tree is 1 2 4 8.

                  1
               /     \
             2        3
           /  \      /  \
          4    5   6     7
           \
             8
         Left view of following tree is 1 2 4 8

         Solution:
         Print the left most node of every level.
         So, we will do a level order traversal on the tree and print the leftmost node at every level.

         Time Complexity: O(n), where n is the number of nodes in the binary tree.
         Auxiliary Space: O(n) since using space for auxiliary queue
 */
public class LeftViewOfBinaryTree {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        if (root == null) {
            return leftView;
        }

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int currentLevelSize = Q.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = Q.remove();
                if (null != node.left) {
                    Q.add(node.left);
                }
                if (null != node.right) {
                    Q.add(node.right);
                }
                if (i == 0) {
                    leftView.add(node.val);
                }
            }

        }
        return leftView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(8);

        LeftViewOfBinaryTree leftViewOfBinaryTree = new LeftViewOfBinaryTree();
        List<Integer> leftView = leftViewOfBinaryTree.leftSideView(root);
        System.out.println(leftView.toString());
    }
}