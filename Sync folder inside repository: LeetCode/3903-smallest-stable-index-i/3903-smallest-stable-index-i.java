class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
       for(int i=0;i<n;i++){
        int max = Integer.MIN_VALUE;
           for(int j=0;j<=i;j++){
               if(max<nums[j]){
                   max = nums[j];
               }
           }
        int min = Integer.MAX_VALUE;
           for(int p=i;p<n;p++){
               if(nums[p]<min){
                   min = nums[p];
               }
           }
           if(max-min<=k){
               return i;
           }
       }
        return -1;
    }
}