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
    public int minDepth(TreeNode root) {
      int leftcnt=0;
      int rightcnt=0;
      if(root==null) return 0;
      leftcnt=minDepth(root.left);
      rightcnt=minDepth(root.right);
      if(root.left==null)return rightcnt+1;
      if(root.right==null)return leftcnt+1;
      return Math.min(leftcnt,rightcnt)+1;
    }
}