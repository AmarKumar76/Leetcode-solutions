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
    static int cnt =0;
    public static void path(TreeNode root,long targetSum){
        if(root==null)return;
        targetSum = targetSum-root.val;
        if(targetSum==0){
            cnt++;
        }
        path(root.left,targetSum);
        path(root.right,targetSum);
    }
    public static void solve(TreeNode root,long targetSum){
        if(root==null)return;
        path(root,targetSum);
        solve(root.left,targetSum);
        solve(root.right,targetSum);
    }
    public int pathSum(TreeNode root, int targetSum) {
         cnt=0;
        solve(root,targetSum);
        return cnt;
    }
   
}