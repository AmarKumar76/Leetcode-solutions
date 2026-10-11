// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         // brute force
//         int n = nums.length;
//         Arrays.sort(nums);
//         //int cnt=1;
//         return nums[n-k];
//     }
// }

//optimal using priority queue
class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer>pq = new PriorityQueue<>();
         
         for(int ele : nums){
             pq.add(ele);
             if(pq.size()>k){
                 pq.remove();
             }
         }
         return pq.peek();
    }
}