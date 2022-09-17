package TOP_450.TREE.BINARY_TREE;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
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

    public void inorderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}