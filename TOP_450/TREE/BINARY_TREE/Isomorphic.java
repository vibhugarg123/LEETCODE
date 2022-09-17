package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

/*
        Problem- https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
            Given two Binary Trees. Check whether they are Isomorphic or not.

            Note:
                Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and right children of several nodes. Any number of nodes at any level can have their children swapped.
                Two empty trees are isomorphic.

                Input:
                T1    1     T2:    1
                    /  \         /   \
                   2    3       3     2
                  /                    \
                  4                     4
                Output: Yes

        Expected Time Complexity: O(min(M, N)) where M and N are the sizes of the two trees.
        Expected Auxiliary Space: O(min(H1, H2)) where H1 and H2 are the heights of the two trees.
 */
public class Isomorphic {

    boolean isIsomorphic(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) return true;
        if (null == root1 || null == root2) return false;

        if (root1.val != root2.val) return false;

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been "Flipped". Both of these subtrees have to be isomorphic.
        // Case 2: The subtrees rooted at these nodes have been "Flipped"
        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) ||
                isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        System.out.println(new Isomorphic().isIsomorphic(root1, root2));
    }
}