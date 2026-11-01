class Solution {
    public int minMergedInteger(int[] nums) {
        int n = nums.length;
        int min  = Integer.MAX_VALUE;
        for(int i=0;i<n;i+=2){
            String str1 = Integer.toString(nums[i]);
            String str2 = Integer.toString(nums[i+1]);
           min = Math.min(min,Integer.parseInt(str1+str2));
        }
        return min;
    }
}