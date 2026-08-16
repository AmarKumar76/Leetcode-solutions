class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dirr[] = {0,0,-1,1};
        int dirc[] = {-1,1,0,0};
        int ans[]=new int[2];
        int p=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean flag=true;
                for(int k=0;k<4;k++){
                    int row = dirr[k]+i;
                    int col = dirc[k]+j;
                    if(row<m && row>=0 && col>=0 && col<n){
                        if(mat[i][j]<=mat[row][col]){
                            flag = false;
                        }
                    }
                }
                    if(flag){
                        ans[0]=i;
                        ans[1]=j;
                    }
                }
        }
        return ans;
    }
}