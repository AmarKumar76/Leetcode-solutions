class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
      int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        int cnt=0;
        int prefixsum = 0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
            prefixsum+=0;
            }else{
                prefixsum+=1;
            }
            if(map.containsKey(prefixsum-k)){
                cnt+=map.get(prefixsum-k);
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return cnt;
    }
}