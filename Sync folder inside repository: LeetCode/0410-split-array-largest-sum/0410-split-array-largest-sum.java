class Solution {
    boolean ispossible(int arr[],long mid , int k){
        long sum =0;
        int cnt=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+sum>mid){
                sum = arr[i];
                cnt++;
            }else{
                sum+=arr[i];
            }
        }
        return cnt<=k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        long left= 0;
        long right=0;
        for(int i=0;i<n;i++){
            left = Math.max(left,nums[i]);
            right+=nums[i];
        }
        long ans=0;
        while(left<right){
            long mid = left+(right-left)/2;
            if(ispossible(nums,mid,k)){
                right= mid;
                // ans=mid;
            }else{
            left = mid+1;
        }
    }
        return (int)left;
    }
}