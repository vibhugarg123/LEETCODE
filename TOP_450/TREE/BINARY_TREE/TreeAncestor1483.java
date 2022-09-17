package TOP_450.TREE.BINARY_TREE;

/*
          Problem-1483: https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
          You are given a tree with n nodes numbered from 0 to n - 1 in the form of a parent array parent where parent[i] is the parent of ith node.
          The root of the tree is node 0. Find the kth ancestor of a given node.
          The kth ancestor of a tree node is the kth node in the path from that node to the root node.

          Implement the TreeAncestor class:

          TreeAncestor(int n, int[] parent) Initializes the object with the number of nodes in the tree and the parent array.

          int getKthAncestor(int node, int k) return the kth ancestor of the given node. If there is no such ancestor, return -1.

                            0
                          /  \
                         1    2
                       /  \  /  \
                      3   4  5   6

            Input
            ["TreeAncestor", "getKthAncestor", "getKthAncestor", "getKthAncestor"]
            [[7, [-1, 0, 0, 1, 1, 2, 2]], [3, 1], [5, 2], [6, 3]]

            Output
            [null, 1, 0, -1]

            Explanation
            TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
            treeAncestor.getKthAncestor(3, 1); // returns 1 which is the parent of 3
            treeAncestor.getKthAncestor(5, 2); // returns 0 which is the grandparent of 5
            treeAncestor.getKthAncestor(6, 3); // returns -1 because there is no such ancestor


               2^ith parent   Node       0       1       2      3        4       5       6
              0:2^0=1                   -1       0       0      1        1       2       2
              1:2^1=2                   -1
              2:2^2=4                   -1
              3:2^3=8                   -1
              4                         -1
              5                         -1
              6                         -1
              7                         -1

            Binary Lifting: Every integer can be represented in binary form.
                Binary of 9=1001  indices with set bits=3,0
                K=9=2^3+2^0=9
                To find the Kth parent of the vertex V, let K = b0b1b2…bn be an n bit number in the binary representation,
                let p1, p2, p3, …, pj be the indices where bit value is 1 then K can be represented as K = 2p1 + 2p2 + 2p3 + … + 2pj.
                Thus, to reach Kth parent of V, we have to make jumps to 2pth1, 2pth2, 2pth3 upto 2pthj parent in any order.
                For eg: For 9th parent of node V, we have to make jumps to 2(3rd) and 2(0th) parent.

                Time Complexity: O(NlogN) for pre-processing and logN for finding the ancestor.

 */
public class TreeAncestor1483 {
    private final int MAX = 16;
    private final int[][] memo;

    public TreeAncestor1483(int n, int[] parent) {
        this.memo = new int[this.MAX + 1][n];

        //Adding 2^0th i.e 1st parent of each node
        for (int i = 0; i < parent.length; i++) {
            this.memo[0][i] = parent[i];
        }

        for (int i = 1; i <= this.MAX; i++) {
            this.memo[i][0] = -1;
        }

        //Traversing over 2^1 (i=1),2^2 (i=2) ,2^3 (i=3) parent
        for (int i = 1; i <= this.MAX; i++) {
            //Doing for all nodes for j=0 to j=n-1
            for (int j = 1; j < n; j++) {
                // 2^ith parent for node j= 2^i-1th parent of [2^i-1th parent of node j]
                // 2nd parent of node    1,2....n-1
                // 4th parent of node    1,2....n-1
                //.....
                //.....
                // 2^16th parent of node 1,2....n-1

                // 2nd parent of node 3= 1st parent of node 1
                // node 1= first parent of node 3
                if ((memo[i - 1][j]) == -1) {
                    memo[i][j] = -1;
                } else
                    memo[i][j] = memo[i - 1][memo[i - 1][j]];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        // Traversing over each index i.e 2^0.......2^MAX, checking whether bit is set
        for (int i = 0; i <= this.MAX; i++) {
            int mask = (1 << i);
            if ((k & mask) > 0) {
                if (node == -1) {
                    return -1;
                }
                // Checking 2^ith parent for node
                node = memo[i][node];
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor1483 treeAncestor = new TreeAncestor1483(n, parent);
        System.out.println(treeAncestor.getKthAncestor(3, 1));
    }
}