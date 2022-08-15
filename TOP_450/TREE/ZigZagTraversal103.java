package TOP_450.TREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
   Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
    (i.e., from left to right, then right to left for the next level and alternate between).

        3
      /  \
     9   20
       /   \
      15   7

 Input: root = [3,9,20,null,null,15,7]
 Output: [[3],[20,9],[15,7]]

 level is even:  add current elements add at the back of list
 level is  odd:  add current elements at front of list.

 Time Complexity: O(N)
 Auxiliary Space: O(N) for queue data structure

 */

public class ZigZagTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZag = new ArrayList<>();
        if (null == root) {
            return zigZag;
        }

        int currentLevel = 0;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int currentSize = Q.size();
            List<Integer> CL = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = Q.remove();
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }

                if (currentLevel % 2 == 0) {
                    //if current level is even, add at the back of list
                    CL.add(node.val);
                } else {
                    //if current level is odd, add it to front of list
                    CL.add(0, node.val);
                }
            }

            currentLevel++;
            zigZag.add(CL);
        }
        return zigZag;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> zigzagLevelOrder = new ZigZagTraversal103().zigzagLevelOrder(root);
        System.out.println(zigzagLevelOrder.toString());
    }
}