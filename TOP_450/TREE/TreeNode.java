package TOP_450.TREE;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void printLevelOrderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            System.out.print(node.val + " ");
            if (null != node.left) {
                Q.add(node.left);
            }
            if (null != node.right) {
                Q.add(node.right);
            }
        }
    }
}