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
 */
class Solution {

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode middle = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {

        inorder(root);

        // Only one violation
        if (second == null) {

            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;

        }
        // Two violations
        else {

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Current
        if (prev != null && prev.val > root.val) {

            // First violation
            if (first == null) {

                first = prev;
                middle = root;

            }
            // Second violation
            else {

                second = root;
            }
        }

        // Update previous
        prev = root;

        // Right
        inorder(root.right);
    }
}