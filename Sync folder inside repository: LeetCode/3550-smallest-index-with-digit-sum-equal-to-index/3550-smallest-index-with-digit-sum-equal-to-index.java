class Solution {
    public int smallestIndex(int[] nums) {
     for(int i=0;i<nums.length;i++){
        int sum =0,num = Math.abs(nums[i]);
       while(num>0){
          sum = sum+num%10;
          num = num/10;
       }
       if(sum==i){
        return i;
       }
     }
       return -1;
    }
}