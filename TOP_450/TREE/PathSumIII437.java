package TOP_450.TREE;

import java.util.*;

/*
        Problem-437- https://leetcode.com/problems/path-sum-iii/
        Given the root of a binary tree and an integer targetSum,
        return the number of paths where the sum of the values along the path equals targetSum.

        The path does not need to start or end at the root or a leaf, but it must go downwards
        (i.e., traveling only from parent nodes to child nodes).

                                10
                               /  \
                              5   -3
                            /  \    \
                           3   2    11
                         /  \   \
                        3   -2   1

                       Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
                       Output: 3
                      Explanation: The paths that sum to 8 are shown.
                          Path-1: [5,2,1]
                          Path-2: [-3,11]
                          Path-3: [5,3]

        Thought process:-
            To find all the paths whose sum is equals to target we need to consider all possible paths in the tree which arises from parent to child nodes.
            Most basic approach would be by considering each node as a root node and calculate sum of paths from this node.
            In the below illustration, we have considered node with value 10 as a root node and calculated path sums.
            While exploring paths if we encounter path sum equals to the target then increment the counter.
            Repeat the same for all nodes, and keep on incrementing counter.
            Considering 10 as root-
                                    10 (10)
                                   /    \
                            (15)  5     -3  (7)
                                /  \        \
                          (18) 3   2 (17)   11 (18)
                             /  \   \
                   (21)   3 (16)-2   1 (18)

           Complexity Analysis:-
                Time complexity:- O(N²) where N is a number of nodes in tree
                Space complexity:- O(N) as we have used stack for storing each node.

           Can we optimize the time complexity by storing path-sums?
           - Prefix-sum is a technique to calculate and store sum of consecutive numbers in a slice by increasing size of slice.

          Array -       10,  5,   3,   3
          Prefix-Sum -   10,  15,  18,  21
              We can use Prefix-sum to find nodes in the binary tree whose values sum up to target sum.
                target  = 8
              In the third iteration we have found the subarray whose sum adds up to target.
              Iteration         Current Sum    CurrentSum- Target        Result
              1                 10              10-8=2                   Not found
              2                 15              15-8=7                   Not found
              3                 18              18-8=10                  Found


      Solution:
      1. Prefix-sum to optimize our approach-
            Prefix-sum is a technique to calculate and store sum of consecutive numbers in a slice by increasing size of slice.
      2. Maintain a counter to store the result. Increment the value of counter in following two conditions —
            - Current sum is equals to the target.
            - A value which is difference between current sum & target is found in prefix-sum mapping.
      3. Once both left and right subtree of any node is traversed, remove their sum from prefix sum array.
         This is to avoid invalid paths (not following parent to child flow).

 */
public class PathSumIII437 {

    int total = 0;
    Vector<Integer> path = new Vector<>();

    // utility function to print contents of a vector from index i to it's end
    static void printVector(Vector<Integer> v, int i) {
        for (int j = i; j < v.size(); j++)
            System.out.print(v.get(j) + " ");
        System.out.println();
    }

    /*
            Time complexity:- O(N), where N is a number of nodes in tree
            Space complexity:- O(N), we have used hashmap for storing prefix-sum
     */
    public int pathSum(TreeNode root, int targetSum) {
        // Hashmap stores running sum to count mapping
        HashMap<Long, Integer> hm = new HashMap<>();
        pathSumUtils(root, 0, targetSum, hm);
        return total;
    }

    public void pathSumUtils(TreeNode root, long runningSum, int targetSum, HashMap<Long, Integer> hm) {
        if (null == root) return;

        runningSum += root.val;

        if (runningSum == targetSum) total++;

        if (hm.containsKey(runningSum - targetSum)) {
            total += hm.get(runningSum - targetSum);
        }

        hm.put(runningSum, hm.getOrDefault(runningSum, 0) + 1);

        pathSumUtils(root.left, runningSum, targetSum, hm);
        pathSumUtils(root.right, runningSum, targetSum, hm);

        //To backtrack decrease the count of running sum by 1
        hm.put(runningSum, hm.get(runningSum) - 1);
    }

    /*
            Time Complexity: O(n*h*h)  , as maximum size of path vector can be h
            Space Complexity: O(h)
     */
    public void printPathKSum(TreeNode root, int targetSum) {
        if (null == root) return;

        path.add(root.val);

        printPathKSum(root.left, targetSum);
        printPathKSum(root.right, targetSum);

        // check if there's any k sum path that terminates at this node
        // Traverse the entire path as there can be negative elements too
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);

            // If path sum is target sum, print the path
            if (f == targetSum)
                printVector(path, j);
        }

        //To backtrack remove the last element from the vector
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        System.out.println(new PathSumIII437().pathSum(root, targetSum));
        System.out.println("Printing paths:");
        new PathSumIII437().printPathKSum(root, targetSum);
    }
}