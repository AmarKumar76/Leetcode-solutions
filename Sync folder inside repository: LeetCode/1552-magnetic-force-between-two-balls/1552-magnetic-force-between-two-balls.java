class Solution {
    boolean ispossible(int arr[], int mid, int m){
        int lastPosition = arr[0];
        int totalball =1;
        for(int i=0;i<arr.length;i++){
            if((arr[i]-lastPosition)>=mid){
                lastPosition = arr[i];
                totalball++;
            }
        }
        return totalball>=m;
    }
    public int maxDistance(int[] position, int m) {
        int max=0;
        int min =Integer.MAX_VALUE;
        for(int i=0;i<position.length;i++){
            max=Math.max(max,position[i]);
            min = Math.min(min,position[i]);
        }
        Arrays.sort(position);
        int left =1;
        int ans=0;
        int right=max-min;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(ispossible(position,mid,m)){
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
            }
        }
        return ans; 
    }
}