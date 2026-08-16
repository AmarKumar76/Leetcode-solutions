/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return -1; // no edges for null

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // path through this node = leftHeight + rightHeight + 2 edges connecting them
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}