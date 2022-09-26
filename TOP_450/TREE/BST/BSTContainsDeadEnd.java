package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
        Problem: https://www.geeksforgeeks.org/check-whether-bst-contains-dead-end-not/

        Input :
                       8
                     /   \
                   5      9
                 /  \
                2    7
               /
              1

        Output : Yes
        Explanation : Node "1" is the dead End because after that
                      we cant insert any element.

        We can notice that we basically need to check if there is a leaf node with value x such that x+1 and x-1 exist in BST
        exception being x = 1.
        For x = 1, we can’t insert 0 as the problem statement says BST contains positive integers only.

        To implement the above idea we first traverse the whole BST and store all nodes in a set.
         - We also store all leaves in a separate hash to avoid re-traversal of BST.
         - Finally, we check for every leaf node x, if x-1 and x+1 are present in set or not.
 */
public class BSTContainsDeadEnd {
    public boolean isDeadEnd(TreeNode root) {
        HashSet<Integer> hs = new HashSet<>();
        List<Integer> leaves = new ArrayList<>();
        store(root, hs, leaves);

        for (int leaf : leaves) {
            if ((leaf == 1 && hs.contains(leaf + 1))
                    || (hs.contains(leaf - 1) && hs.contains(leaf + 1))) {
                System.out.println(leaf + " is dead end");
                return true;
            }
        }
        return false;
    }

    private void store(TreeNode root, HashSet<Integer> hs, List<Integer> leaves) {
        if (null == root) return;
        store(root.left, hs, leaves);

        if (null == root.left && null == root.right) leaves.add(root.val);
        hs.add(root.val);

        store(root.right, hs, leaves);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(13);

        System.out.println(new BSTContainsDeadEnd().isDeadEnd(root));
    }
}