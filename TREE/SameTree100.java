package TREE;

/*
[Problem-100] Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Complexity Analysis

Time complexity :O(N), where N is a number of nodes in the tree, since one visits each node exactly once.

Space complexity : O(log(N)) in the best case of completely balanced tree &
O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
 */
class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;

        // one of p and q is null
        if (q == null || p == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }
}