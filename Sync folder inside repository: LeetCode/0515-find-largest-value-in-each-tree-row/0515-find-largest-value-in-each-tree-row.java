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
    public List<Integer> largestValues(TreeNode root) {
        //List<List<Integer> list =new ArrayList<>()
        List<Integer>ans = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        if(root==null) return ans;
        while(!q.isEmpty()){
        List<Integer>list = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
             TreeNode curr = q.poll();
             list.add(curr.val);
             if(curr.left!=null){
                q.offer(curr.left);
             }
             if(curr.right!=null){
                q.offer(curr.right);
             }
            }
            int max = Integer.MIN_VALUE;
            for(int i=0;i<list.size();i++){
                if(max<list.get(i)){
                    max=list.get(i);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}