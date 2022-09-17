package TOP_450.TREE.BINARY_TREE.Views_BinaryTree;

import TOP_450.TREE.BINARY_TREE.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Problem-199: https://leetcode.com/problems/binary-tree-right-side-view/
    Given the root of a binary tree, imagine yourself standing on the right side of it,
                 return the values of the nodes you can see ordered from top to bottom.

                   1
                 /  \
                2   3
                \   \
                5   4
    Input: root = [1,2,3,null,5,null,4]
    Output: [1,3,4]

    Solution: Print the right most node of every level. So, we will do a level order traversal on the tree and print the last node at every level.
 */
public class RightSideViewOfBinaryTree199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if (root == null) {
            return rightSideView;
        }

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int currentLevelSize = Q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = Q.remove();
                if (null != node.left) {
                    Q.add(node.left);
                }
                if (null != node.right) {
                    Q.add(node.right);
                }
                currentLevel.add(node.val);
            }
            rightSideView.add(currentLevel.get(currentLevel.size() - 1));
        }

        return rightSideView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);


        RightSideViewOfBinaryTree199 rightSideViewOfBinaryTree199 = new RightSideViewOfBinaryTree199();
        List<Integer> rightSideView = rightSideViewOfBinaryTree199.rightSideView(root);
        System.out.println(rightSideView.toString());
    }
}