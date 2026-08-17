class Solution {
    static boolean isvalid(int time[],int trip,long mid){
        long cnt=0;
        for(int i=0;i<time.length;i++){
             cnt+=mid/time[i];
             if(cnt>=trip){
                return true;
             }
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
         long left = 1;
         long right = Integer.MAX_VALUE;
         for(int i=0;i<time.length;i++){
            right = Math.min(time[i],right);
         }
         right =right*totalTrips;
        while(left<right){
            long mid= left+(right-left)/2;
            if(isvalid(time,totalTrips,mid)){
                right =mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}