package TOP_450.TREE;

/*
    Problem- https://www.geeksforgeeks.org/check-if-two-trees-are-mirror

        Given two Binary Trees, write a function that returns true if two trees are mirror of each other,
        else false. For example, the function should return true for following input trees.

          1          1
         / \        /  \
        2   3      3    2
        As we can clearly see, the second tree is mirror image of the first.

        Time Complexity: O(N)
        Space Complexity: O(h), where h=height of tree.
 */
public class MirrorTree {

    boolean areMirror(TreeNode root1, TreeNode root2) {
        /* Base case : Both empty */
        if (null == root1 && null == root2) return true;

        // If only one is empty
        if (null == root1 || null == root2) return false;

         /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return root1.val == root2.val && areMirror(root1.left, root2.right) && areMirror(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        System.out.println(new MirrorTree().areMirror(root1, root2));
    }
}