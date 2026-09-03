class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int even=0;
        int odd=0;
       int oddmin=Integer.MAX_VALUE;
       int evenmin = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
               even++;
               if(evenmin>nums1[i]){
                evenmin=nums1[i];
               }
            }else{
                odd++;
                if(oddmin>nums1[i]){
                    oddmin=nums1[i];
                }
            }
        }
        if(odd!=0 && even!=0){
            if(evenmin<oddmin){
                return false;
            }
        }
        return true;
       
    }
}