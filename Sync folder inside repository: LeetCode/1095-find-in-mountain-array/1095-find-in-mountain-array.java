/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public static int asBinarySearch(MountainArray arr,int l ,int r,int key){
        while (l<=r){
            int mid = l+(r-l)/2;
            int midele = arr.get(mid);
            if(midele==key){
                return mid;
            }
            if(midele>key){
                r= mid-1;
            }
            else{
                l= mid+1;
            }
        } 
        return -1;
    }
    public static int desBinarySearch(MountainArray arr,int l ,int r,int key){
        while (l<=r){
            int mid = l+(r-l)/2;
            int midele = arr.get(mid);
            if(midele==key){
                return mid;
            }
            if(midele<key){
                r= mid-1;
            }
            else{
                l= mid+1;
            }
        } 
        return -1;
    }
    public static int peak(MountainArray arr,int left ,int right ){
         left = left+1;
         right = right-1;
         while(left<=right){
            int mid =( left+right)/2;
            int midele = arr.get(mid);
            if(arr.get(mid-1)<midele && midele>arr.get(mid+1)){
                return mid;
            }else if(midele>arr.get(mid-1)){
                left = mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    static int searchBitonic(MountainArray arr, int n,
                            int key, int index)
    {
        int indexele = arr.get(index);
        if (key > indexele)
        {
            return -1;
        }
        else if (key == indexele)
        {
            return index;
        }
        else {
            int temp = asBinarySearch(
                arr, 0, index - 1, key);
           
            int tem = desBinarySearch(arr, index + 1,
                                        n - 1, key);
          
           if(temp!=-1){
            return temp;
           }
           return tem;
        }
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int peakindex = peak(mountainArr,0,mountainArr.length()-1);
        int x = searchBitonic(mountainArr, mountainArr.length(),target, peakindex);
        if(x!=-1){
            return x;
        }
        return -1;
    }
}