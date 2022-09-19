package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
    Problem: https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/

 */
public class PredecessorAndSuccessorBST {
    static class Res {
        TreeNode pre = null;
        TreeNode succ = null;
    }

    /*  We can also find the inorder successor and inorder predecessor using inorder traversal.
    Check if the current node is smaller than the given key for the predecessor and for a successor,
    check if it is greater than the given key.

    Time Complexity: O(n), where n is the total number of nodes in the tree. In the worst case as explained above we travel the whole tree.
    Auxiliary Space: O(n).
 */
    public void findPreSuc(TreeNode root, Res p, Res s, int key) {
        if (null == root) return;

        findPreSuc(root.left, p, s, key);

        //first node greater than key
        if (null == s.succ && root.val > key) {
            s.succ = root;
        }

        // last node less than key
        if (root.val < key) {
            p.pre = root;
        }

        findPreSuc(root.right, p, s, key);
    }

    private TreeNode TreeMaximum(TreeNode root) {
        TreeNode temp = root;
        while (null != temp && null != temp.right) {
            temp = temp.right;
        }
        return temp;
    }

    private TreeNode TreeMinimum(TreeNode root) {
        TreeNode temp = root;
        while (null != temp && null != temp.left) {
            temp = temp.left;
        }
        return temp;
    }

    /*
             Inorder Predecessor of node "p":
                    1. Case-1: If the node "p" has left subtree, then return the maximum node in left subtree.
                                    50
                                  /   \                 Find predecessor of node 40: i.e just smaller element than 40
                                16     90               Case-1: 40 has left child, hence return maximum in left subtree, i.e, 37
                                 \      \
                                 40      91
                                /
                               35
                                 \
                                 36
                                   \
                                   37
                      2. Case-2: If the node "p" does not have left subtree, search that node from root, and the node from where
                                 we take the last right is the answer.
                                   50
                                  /   \
                                16     90                 For node 79,find predecessor:
                                 \    /  \                - search 79 from root
                                 40  78  100              -  50->R->90->L->78->R->82->L->81->L->79 (key found)
                                /       \                 - 1st right: 50->R->90
                               35        82               - 2nd right: 78->R->82
                                 \        /                 Last right turn was from 78 to reach 79, hence 78 is predecessor
                                 36      81
                                   \     /
                                   37  79

         Time Complexity: O(h), where h is the height of the tree. In the worst case as explained above we travel the whole height of the tree.
     */
    public void findInorderPredecessor(TreeNode root, int key, Res pre, TreeNode lastRightTurnToReachKey) {
        if (null == root) return;

        if (root.val == key) {
            if (null != root.left) {
                pre.pre = TreeMaximum(root.left);
            } else {
                pre.pre = lastRightTurnToReachKey;
            }
            return;
        }
        if (root.val < key) {
            lastRightTurnToReachKey = root;
            findInorderPredecessor(root.right, key, pre, lastRightTurnToReachKey);
        } else {
            findInorderPredecessor(root.left, key, pre, lastRightTurnToReachKey);
        }
    }

    /*
        Optimised Version:

        Case-1: x has a right subtree:
                If x has a right subtree, inorder successor will be the minimum value in right subtree i.e, Tree-Minimum(x.right)
                             5
                           /   \
                         4      7
                       /  \     /
                     3    4.1  6
                     Inorder successor of 5=6

        Case-2: x has no right subtree:
                                    50
                                  /   \
                                16     90                 For node 37,find successor:
                                 \    /  \                - search 37 from root
                                 40  78  100              -  50->L->16->R->40->L->35->R->36->R->37 (key found)
                                /       \                 - 1st left: 50->L->16
                               35        82               - 2nd left: 40->R->35
                                 \        /                 Last left turn was from 40 to reach 35, hence 40 is successor
                                 36      81
                                   \     /
                                   37  79

     */

    public void findInorderSuccessor(TreeNode root, int key, Res succ, TreeNode lastLeftTurnToReachKey) {
        if (null == root) return;

        if (root.val == key) {
            if (null != root.right) {
                succ.succ = TreeMinimum(root.right);
            } else {
                succ.succ = lastLeftTurnToReachKey;
            }
            return;
        }
        if (root.val < key) {
            findInorderSuccessor(root.right, key, succ, lastLeftTurnToReachKey);
        } else {
            lastLeftTurnToReachKey = root;
            findInorderSuccessor(root.left, key, succ, lastLeftTurnToReachKey);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        PredecessorAndSuccessorBST predecessorAndSuccessorBST = new PredecessorAndSuccessorBST();
        Res predecessor = new Res();
        Res successor = new Res();
        predecessorAndSuccessorBST.findPreSuc(root, predecessor, successor, 22);
        System.out.println("predecessor " + (null == predecessor.pre ? null : predecessor.pre.val) +
                " successor " + (null == successor.succ ? null : successor.succ.val));


        TreeNode root1 = new TreeNode(50);
        root1.left = new TreeNode(16);
        root1.left.right = new TreeNode(40);
        root1.left.right.left = new TreeNode(35);
        root1.left.right.left.right = new TreeNode(36);
        root1.left.right.left.right.right = new TreeNode(37);

        root1.right = new TreeNode(90);
        root1.right.left = new TreeNode(78);
        root1.right.right = new TreeNode(100);
        root1.right.left.right = new TreeNode(82);
        root1.right.left.right.left = new TreeNode(81);
        root1.right.left.right.left.left = new TreeNode(79);

        Res pre = new Res();
        predecessorAndSuccessorBST.findInorderPredecessor(root1, 79, pre, null);
        System.out.println("predecessor " + (pre.pre == null ? null : pre.pre.val));

        Res succ = new Res();
        predecessorAndSuccessorBST.findInorderSuccessor(root1, 37, succ, null);
        System.out.println("successor " + (succ.succ == null ? null : succ.succ.val));
    }
}