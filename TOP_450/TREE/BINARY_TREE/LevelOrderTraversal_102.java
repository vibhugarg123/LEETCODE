package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Problem 102: Given the root of a binary tree, return the level order traversal of its nodes' values.
             (i.e., from left to right, level by level).

             Input: root = [3,9,20,null,null,15,7]
             Output: [[3],[9,20],[15,7]]

    Concept: Next level begins when current queue empties.

    Time Complexity: O(N)
    Space Complexity: O(N)

    Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentElement = queue.remove(); //removes the head of the queue
                currentLevel.add(currentElement.val);

                if (null != currentElement.left) {
                    //adds to the end of queue
                    queue.add(currentElement.left);
                }
                if (null != currentElement.right) {
                    queue.add(currentElement.right);
                }
            }

            res.add(currentLevel);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        List<List<Integer>> res = levelOrderTraversal.levelOrder(root);
        System.out.println(res);
    }
}