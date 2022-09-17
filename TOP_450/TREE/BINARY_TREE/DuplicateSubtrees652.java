package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
        Problem- https://leetcode.com/problems/find-duplicate-subtrees/

                2
              /   \
             2     2
           /      /
          3      3

          Duplicate Sub Trees: [[2,3], [3]]

            1. Use Hash and serialise the binary tree.
                3.#.#
                2.3.#.#.#
                3.#.#
                2.3.#.#.#
                2.2.3.#.#.#.2.3.#.#.#
            2. Whenever the count of particular hash reaches 2, add that root to resultant list.

                Time Complexity: O(N)
                Space Complexity: O(N)
 */
public class DuplicateSubtrees652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        findDuplicateSubtreesUtils(root, count, result);
        return result;
    }

    private String findDuplicateSubtreesUtils(TreeNode root, Map<String, Integer> count, List<TreeNode> result) {
        if (null == root) {
            return "#";
        }
        String subTree = root.val + "." + findDuplicateSubtreesUtils(root.left, count, result) + "." + findDuplicateSubtreesUtils(root.right, count, result);

        count.put(subTree, count.getOrDefault(subTree, 0) + 1);

        if (count.get(subTree) == 2) {
            result.add(root);
        }
        return subTree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(3);

        List<TreeNode> result = new DuplicateSubtrees652().findDuplicateSubtrees(root);
        System.out.println("fdf");
        result.forEach(node -> {
            node.preOrderTraversal(node);
            System.out.println();
        });
    }
}