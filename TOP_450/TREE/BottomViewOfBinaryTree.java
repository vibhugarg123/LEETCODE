package TOP_450.TREE;

/*
     Given a binary tree, print the bottom view from left to right.
     A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /  \
                  10    14

        For the above tree, the bottom view is 5 10 3 14 25.
        If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.
        For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /  \
              5      3 4     25
                     /  \
                 10     14

        For the above tree the output should be 5 10 4 14 25.


  Solution:
  1. Do level order traversal storing horizontal distance from root of each node
     level 0: {0,20}
     level 1: {-1,8} {1,22}
     level 2: {-2,5} {0,3} {0,4} {2,25}
     level 3: {-1,10} {1,14}

     Output: [5,10,4,14,25]

     for each hd, when we encounter the last element, i.e the bottom view.

     Time complexity: O(n*log(n)), where n is the number of nodes in the given tree.
     Auxiliary Space : O(n), As we store nodes in the map and queue.
 */

import java.util.*;

public class BottomViewOfBinaryTree {

    static class Pair {
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    List<Integer> bottomView(TreeNode root) {
        List<Integer> bottomView = new ArrayList<>();

        //TreeMap because of it will be sorted based on key
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(0, root));
        int index = 0;
        while (!Q.isEmpty()) {
            int currentSize = Q.size();
            for (int i = 0; i < currentSize; i++) {
                Pair temp = Q.remove();
                map.put(temp.hd, temp.node.val);

                if (null != temp.node.left) {
                    Q.add(new Pair(temp.hd - 1, temp.node.left));
                }
                if (null != temp.node.right) {
                    Q.add(new Pair(temp.hd + 1, temp.node.right));
                }
            }
        }

        map.forEach((k, v) -> {
            bottomView.add(v);
        });

        return bottomView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(14);

        BottomViewOfBinaryTree topViewOfBinaryTree = new BottomViewOfBinaryTree();
        List<Integer> bottomView = topViewOfBinaryTree.bottomView(root);
        System.out.println(bottomView.toString());
    }
}