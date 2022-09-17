package TOP_450.TREE.BINARY_TREE.Views_BinaryTree;

/*
     Problem: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
      Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

               1
            /     \
           2       3
          /  \    /   \
        4    5  6      7

        Top view will be: 4 2 1 3 7
        Note: Return nodes from leftmost node to rightmost node.

        Example 1:

        Input:
              1
           /    \
          2      3
        Output: 2 1 3
        Example 2:

        Input:
               10
            /      \
          20        30
         /   \    /    \
        40   60  90    100
        Output: 40 20 10 30 100

        Solution:
               10 (0)
            /      \
          20 (-1)  30(1)
         /   \      /  \
       40(-2)60(0)90(0) 100(2)

  Solution:
  1. Do level order traversal storing horizontal distance from root of each node
     level 0: {0,10}
     level 1: {-1,20} {1,30}
     level 2: {-2,40} {0,60} {0,90} {2,100}

     for each hd, when we encounter the first element, i.e the top view.

     Time complexity: O(n*log(n)), where n is the number of nodes in the given tree.
     Auxiliary Space : O(n), As we store nodes in the map and queue.
 */

import TOP_450.TREE.TreeNode;

import java.util.*;

public class TopViewOfBinaryTree {

    static class Pair {
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    List<Integer> topView(TreeNode root) {
        List<Integer> topView = new ArrayList<>();

        //TreeMap because of it will be sorted based on key
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(0, root));
        int index = 0;
        while (!Q.isEmpty()) {
            int currentSize = Q.size();
            for (int i = 0; i < currentSize; i++) {
                Pair temp = Q.remove();
                if (!map.containsKey(temp.hd)) {
                    map.put(temp.hd, temp.node.val);
                }

                if (null != temp.node.left) {
                    Q.add(new Pair(temp.hd - 1, temp.node.left));
                }
                if (null != temp.node.right) {
                    Q.add(new Pair(temp.hd + 1, temp.node.right));
                }
            }
        }

        map.forEach((k, v) -> {
            topView.add(v);
        });

        return topView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right.left = new TreeNode(90);
        root.right.right = new TreeNode(100);

        TopViewOfBinaryTree topViewOfBinaryTree = new TopViewOfBinaryTree();
        List<Integer> topView = topViewOfBinaryTree.topView(root);
        System.out.println(topView.toString());
    }
}