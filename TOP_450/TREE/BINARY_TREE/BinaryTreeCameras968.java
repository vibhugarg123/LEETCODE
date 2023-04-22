package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

/*
        Problem-968: https://leetcode.com/problems/binary-tree-cameras/description/

        3 statues of each node-
        1. [CAMERA]    Camera is already placed at this node.
        2. [COVERED]   Camera is not there, but it's already covered by its parent, or it's two children.
        3. [NO_CAMERA] Camera is not there, and it's not covered by anyone.

 */
public class BinaryTreeCameras968 {
    enum STATUS {
        CAMERA,
        COVERED_NO_CAMERA,
        NOT_COVERED_NO_CAMERA
    }

    int count = 0;

    public int minCameraCover(TreeNode root) {
        return minCameraCoverUtils(root) == STATUS.NOT_COVERED_NO_CAMERA ? ++count : count;
    }

    public STATUS minCameraCoverUtils(TreeNode root) {
        if (null == root)
            // Base case - if there is no node then it's already covered
            return STATUS.COVERED_NO_CAMERA;

        // Try to cover left and right children's subtree
        STATUS left = minCameraCoverUtils(root.left);
        STATUS right = minCameraCoverUtils(root.right);

        // Neither camera at left, nor at night, add camera at parent to cover left, right and itself as well.
        if (left == STATUS.NOT_COVERED_NO_CAMERA || right == STATUS.NOT_COVERED_NO_CAMERA) {
            count++;
            return STATUS.CAMERA;
        }// Both left and right are covered, but they don't have camera, add camera to cover itself
        else if (left == STATUS.CAMERA || right == STATUS.CAMERA) {
            return STATUS.COVERED_NO_CAMERA;
        }
        return STATUS.NOT_COVERED_NO_CAMERA;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode();
        root.left.left = new TreeNode();
        root.left.right = new TreeNode();
        System.out.println(new BinaryTreeCameras968().minCameraCover(root));
    }
}