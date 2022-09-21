package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*      Problem-235: https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

         For Binary search tree, while traversing the tree from top to bottom the first node which lies
         in between the two numbers n1 and n2 is the LCA of the nodes, i.e.
         the first node n with the lowest depth which lies in between n1 and n2 (n1<=n<=n2) n1 < n2.
         So just recursively traverse the BST in,
         - if node’s value is greater than both n1 and n2 then our LCA lies on the left side of the node,
         - if it is smaller than both n1 and n2, then LCA lies on the right side.
         Otherwise, the root is LCA (assuming that both n1 and n2 are present in BST).

        Time Complexity: O(h).
            The time Complexity of the above solution is O(h), where h is the height of the tree.
        Space Complexity: O(h).
            If recursive stack space is ignored, the space complexity of the above solution is constant.
 */
public class LCABST235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) return null;
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
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

        System.out.println(new LCABST235().lowestCommonAncestor(root, root.left, root.right).val);
    }
}
