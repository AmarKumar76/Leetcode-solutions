/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {};
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //public static void inorder(TreeNode root,List<Integer>list){
    //     if(root==null)return;
    //     inorder(root.left,list);
    //     list.add(root.val);
    //     inorder(root.right,list);
    // }
     public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer>ans = new ArrayList<>();
    //     inorder(root,ans);
    //     return ans;

    // iterative method
        List<Integer>ans = new ArrayList<>();
        Stack<TreeNode>st = new Stack<>();
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);

           curr = curr.right;
        }
        return ans;
    }
}