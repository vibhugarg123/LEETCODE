package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

/*
     Problem- https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
     Find the distance between two keys in a binary tree,
     no parent pointers are given. The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.

     Solution:
     Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
             'n1' and 'n2' are the two given keys
             'root' is root of given Binary Tree.
             'lca' is the lowest common ancestor of n1 and n2

             OR

             We know that distance between two nodes (n1 and n2) = distance between LCA and n1 + distance between LCA and n2.
             We first find the LCA of two nodes. Then we find the distance from LCA to two nodes.

             Time Complexity:  O(N)
             Space Complexity: O(N)

 */
public class DistanceBetweenTwoNodesBinaryTree {

    private TreeNode LCA(TreeNode root, int a, int b) {
        if (null == root) {
            return null;
        }
        if (root.val == a || root.val == b) {
            return root;
        }
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);
        if (null == left) return right;
        if (null == right) return left;

        return root;
    }

    int findLevel(TreeNode root, int a, int level) {
        // Base condition
        if (null == root) {
            return -1;
        }
        //If the current node value equals `a`, return the current level as result
        if (root.val == a) {
            return level;
        }

        // Find `a` in left subtree.
        int left = findLevel(root.left, a, level + 1);
        if (left != -1) return left;

        // If `a` is not found in left subtree, traverse right subtree.
        int right = findLevel(root.right, a, level + 1);
        if (right != -1) return right;

        // If `a` is neither found in left subtree and right subtree, return -1
        return -1;
    }

    int findDist(TreeNode root, int a, int b) {
        TreeNode LCA = LCA(root, a, b);
        int d1 = findLevel(LCA, a, 0);
        int d2 = findLevel(LCA, b, 0);
        return d1 + d2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(new DistanceBetweenTwoNodesBinaryTree().findDist(root, 6, 0));
    }
}