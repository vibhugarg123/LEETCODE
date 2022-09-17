package TOP_450.TREE.BINARY_TREE;

/*
    Problem-236: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

    What is (LCA) Lowest Common Ancestor in Binary Tree?

        The lowest common ancestor is the lowest node in the tree that
        has both n1 and n2 as descendants, where n1 and n2 are the nodes
        for which we wish to find the LCA. Hence,
        the LCA of a binary tree with nodes n1 and n2 is the shared ancestor of n1 and n2 that is located farthest from the root.

        Note-A node can be a descendant of itself.

        3
      /  \
     5    1
    / \  / \
   6  2  0  8
     / \
    7  4

    LCA(5,1)=3
    LCA(2,5)=5
    LCA(2,6)=5

    Time Complexity: O(N)
    Space Complexity: O(N)
 */
public class LCA236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        //Case-1: If the current element matches either p or q, current element is LCA
        if (root == p || root == q) {
            return root;
        }
        //Case-2: Find p or q in left subtree or right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If the element is not found in left subtree, return right.
        if (null == left) return right;
        // If the element is not found in right subtree, return left.
        if (null == right) return left;

        //When both left and right are not null, we get our ans
        return root;
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

        System.out.println(new LCA236().lowestCommonAncestor(root, root.left, root.right).val);
    }
}