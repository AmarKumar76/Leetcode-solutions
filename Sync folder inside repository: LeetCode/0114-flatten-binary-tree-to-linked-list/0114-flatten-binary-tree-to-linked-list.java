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
     static ArrayList<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
       inorder(root);
       for(int i=0;i<list.size()-1;i++){
        TreeNode node = list.get(i);
        node.right = list.get(i+1);
        node.left = null;
       }
    }
    public static void inorder(TreeNode root){
        if(root==null)return;
        list.add(root);
        inorder(root.left);
        inorder(root.right);
    }
}