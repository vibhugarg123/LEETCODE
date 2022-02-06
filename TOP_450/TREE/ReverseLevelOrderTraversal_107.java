package TOP_450.TREE;

import java.util.*;

/*
    Problem-107: Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
                 (i.e., from left to right, level by level from leaf to root).

                 Input: root = [3,9,20,null,null,15,7]
                 Output: [[15,7],[9,20],[3]]

    Solution: 1. Do plain level order traversal, but while adding current level to result, add it to index 0 ot at front.

    Time Complexity : O(N)
    Space Complexity: O(N)

    Link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */

public class ReverseLevelOrderTraversal_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                    queue.add(currentElement.left);
                }

                if (null != currentElement.right) {
                    //adds to the end of queue
                    queue.add(currentElement.right);
                }
            }

            res.add(0, currentLevel);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ReverseLevelOrderTraversal_107 reverseLevelOrderTraversal_107 = new ReverseLevelOrderTraversal_107();
        List<List<Integer>> res = reverseLevelOrderTraversal_107.levelOrderBottom(root);
        System.out.println(res);
    }
}