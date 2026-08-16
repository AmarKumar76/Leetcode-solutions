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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        Queue<TreeNode>que  = new LinkedList<>();
        if(root==null) return res;
        que.add(root);
        while(!que.isEmpty()){
            List<Integer>list = new ArrayList<>();
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                list.add(curr.val);
            if(curr.left!=null){
                que.add(curr.left);
            }
            if(curr.right!=null){
                que.add(curr.right);
            }
            }
            res.add(0,list);
        }
        return res;
    }
}