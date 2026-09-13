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
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
       HashSet<Integer>set = new HashSet<>();
       ListNode dummy = new ListNode(-1);
       ListNode curr = dummy;
       ListNode temp = head;
       for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
       }
       while(temp!=null){
        if(!set.contains(temp.val)){
            curr.next = new ListNode(temp.val);
            curr = curr.next;
        }
        temp = temp.next;
       }
       return dummy.next;
    }
}