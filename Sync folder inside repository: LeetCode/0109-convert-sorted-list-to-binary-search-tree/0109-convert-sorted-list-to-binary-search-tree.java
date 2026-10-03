/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    List<ListNode>list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        while(temp !=null){
            list.add(temp);
            temp = temp.next;
        }
        return build(list,0,list.size()-1);

    }
    public TreeNode build(List<ListNode>list ,int left,int right){
            
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(list.get(mid).val);

        root.left = build(list, left, mid - 1);
        root.right = build(list, mid + 1, right);

        return root;
    }
}