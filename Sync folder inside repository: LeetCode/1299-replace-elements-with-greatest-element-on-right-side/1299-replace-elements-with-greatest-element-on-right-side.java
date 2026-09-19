// class Solution {
//     public int[] replaceElements(int[] arr) {
//         // int n = arr.length;
//         // int ans [] = new int[arr.length];
//         // for(int i=0;i<n-1;i++){
//         // int max = Integer.MIN_VALUE;
//         //     for(int j=i+1;j<n;j++){
//         //         if(arr[j]>max){
//         //             max = arr[j];
//         //         }
//         //     }
//         //     ans[i]=max;
//         // }
//         // ans[n-1]=-1;
//         // return ans;
      
//     }
// }

// optimal
class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int ans [] = new int[arr.length];

        int premax[]=new int[n];

        premax[n-1]=-1;

        int max = Integer.MIN_VALUE;

        for(int i=n-2;i>=0;i--){
            max=Math.max(max,arr[i+1]);
            premax[i]=max;
        }

        for(int i=0;i<n;i++){
            ans[i]=premax[i];
        }

        return ans;

    }
}