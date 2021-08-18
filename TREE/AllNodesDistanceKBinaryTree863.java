package TREE;

/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.
<img src="IMAGES/863.png" />

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 */

import java.util.*;

class Solution {

    public HashMap<TreeNode, TreeNode> storeParent(TreeNode root) {
        if (null == root) {
            return null;
        }
        HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode p = Q.poll();
            if (p == root) {
                hashMap.put(root, null);
            }
            if (null != p.left) {
                hashMap.put(p.left, p);
                Q.add(p.left);
            }
            if (null != p.right) {
                hashMap.put(p.right, p);
                Q.add(p.right);
            }
        }
        return hashMap;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashSet<TreeNode> seen = new HashSet<>();
        if (root == null || target == null || k < 0) {
            return null;
        }
        HashMap<TreeNode, TreeNode> parentArray = storeParent(root);

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> Q = new LinkedList<>();
        int level = 0;
        Q.add(target);
        seen.add(target);

        while (!Q.isEmpty()) {

            if (level == k) {
                while (!Q.isEmpty()) {
                    result.add(Q.peek().val);
                    Q.poll();
                }
            }
            int currentLevelLength = Q.size();
            for (int i = 0; i < currentLevelLength; i++) {
                TreeNode p = Q.poll();

                if (null != p.left && !seen.contains(p.left)) {
                    seen.add(p.left);
                    Q.add(p.left);
                }

                if (null != p.right && !seen.contains(p.right)) {
                    seen.add(p.right);
                    Q.add(p.right);
                }

                if (parentArray.containsKey(p)) {
                    TreeNode parent = parentArray.get(p);
                    if (null != parent && !seen.contains(parent)) {
                        seen.add(parent);
                        Q.add(parent);
                    }
                }
            }

            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution s = new Solution();
        List<Integer> result = s.distanceK(root, root.left, 2);
        result.forEach(System.out::println);

    }
}