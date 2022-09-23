package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
        Problem: 938: https://leetcode.com/problems/range-sum-of-bst/
        Given the root node of a binary search tree and two integers low and high,
        return the sum of values of all nodes with a value in the inclusive range [low, high].

        Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
        Output: 32
        Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

        Solution:
            1. Use BFS
                - Time complexity:  O(N)
                - Space Complexity: O(N)
 */
public class RangeSumBST938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (null == root) return 0;
        int sum = 0;

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            TreeNode current = Q.remove();
            if (current.val >= L && current.val <= R)
                sum += current.val;

            if (null != current.left && current.val > L) {
                Q.add(current.left);
            }

            if (null != current.right && current.val < R) {
                Q.add(current.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(new RangeSumBST938().rangeSumBST(root, 7, 15));
    }
}