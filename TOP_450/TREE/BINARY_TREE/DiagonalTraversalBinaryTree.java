package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
    Problem: https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

        Given a Binary Tree, print the diagonal traversal of the binary tree.

        Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

        Example 1:
                    8
                 /     \
                3      10
              /   \      \
             1     6     14
                 /   \   /
                4     7 13


        Output : 8 10 14 3 6 7 13 1 4


 */
public class DiagonalTraversalBinaryTree {

    private static void storeDiagonalTraversal(TreeNode root, Map<Integer, List<Integer>> mp, int levelOfRoot) {
        if (null == root) {
            return;
        }
        if (!mp.containsKey(levelOfRoot)) {
            mp.put(levelOfRoot, new ArrayList<>());
        }
        mp.get(levelOfRoot).add(root.val);

        storeDiagonalTraversal(root.left, mp, levelOfRoot + 1);
        storeDiagonalTraversal(root.right, mp, levelOfRoot);
    }

    public List<Integer> diagonal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        Map<Integer, List<Integer>> mp = new TreeMap<>();
        storeDiagonalTraversal(root, mp, 0);

        mp.forEach((k, v) -> {
            res.addAll(v);
        });
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(new DiagonalTraversalBinaryTree().diagonal(root));
    }
}