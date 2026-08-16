class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int total = requests[0];
        
        for(int i=1;i<requests.length;i++){
           int  curr =  requests[i-1];
            total+=Math.abs(requests[i]-curr);
        }
        return total;
    }
}