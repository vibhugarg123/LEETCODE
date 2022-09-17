package TOP_450.TREE.BINARY_TREE;

import java.util.ArrayList;
import java.util.List;

/*
    [GFG] :https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

    Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:

    Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could
    reach when you always travel preferring the left subtree over the right subtree.

    Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.

    Reverse right boundary nodes: defined as the path from the right-most node to the root.
    The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree.

    Exclude the root from this as it was already included in the traversal of left boundary nodes.
    Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary

    Input:
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
              / \
             8   9

        Output: 1 2 4 8 9 6 7 3
        Explanation:

        Solution:
        //print left boundary excluding leaf nodes
        //only leaf nodes
        //print right boundary in reverse order excluding leaf nodes

        Time Complexity: O(n) where n is the number of nodes in binary tree.
        Auxiliary Space: O(n)
 */

public class BoundaryTraversalBinaryTree {
    public boolean isLeaf(TreeNode root) {
        return null == root.left && null == root.right;
    }

    public void addLeftBoundaryExcludingLeaves(TreeNode left, List<Integer> boundaryElements) {
        if (null == left || isLeaf(left)) return;

        boundaryElements.add(left.val);

        if (null != left.left)
            addLeftBoundaryExcludingLeaves(left.left, boundaryElements);
        else
            addLeftBoundaryExcludingLeaves(left.right, boundaryElements);
    }

    public void addLeaves(TreeNode node, List<Integer> boundaryElements) {
        if (null == node) return;

        addLeaves(node.left, boundaryElements);

        if (isLeaf(node)) {
            boundaryElements.add(node.val);
        }

        addLeaves(node.right, boundaryElements);
    }

    public void addRightBoundaryExcludingLeaves(TreeNode right, List<Integer> boundary) {
        if (null == right || isLeaf(right)) return;

        if (null != right.right) {
            addRightBoundaryExcludingLeaves(right.right, boundary);
        } else {
            addRightBoundaryExcludingLeaves(right.left, boundary);
        }
        //For reverse, adding it in the end.
        boundary.add(right.val);
    }

    public List<Integer> boundary(TreeNode root) {
        List<Integer> boundaryElements = new ArrayList<>();
        if (null == root) {
            return boundaryElements;
        }

        //Add root if it's not leaf
        if (!isLeaf(root))
            boundaryElements.add(root.val);

        //print left boundary excluding leaf nodes
        addLeftBoundaryExcludingLeaves(root.left, boundaryElements);

        //Add leaf nodes
        addLeaves(root, boundaryElements);

        //Add Right boundary
        addRightBoundaryExcludingLeaves(root.right, boundaryElements);

        return boundaryElements;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(new BoundaryTraversalBinaryTree().boundary(root).toString());
    }
}