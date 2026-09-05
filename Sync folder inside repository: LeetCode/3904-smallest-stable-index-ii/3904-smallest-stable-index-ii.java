class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int premax[]=new int[n];
        int sufmin[]=new int[n];
        premax[0]=nums[0];
        sufmin[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            premax[i]=Math.max(premax[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            sufmin[i]=Math.min(sufmin[i+1],nums[i]);
        }
        for(int i=0;i<n;i++){
            if(premax[i]-sufmin[i]<=k){
                return i;
            }
        }
        return -1;
    }
}