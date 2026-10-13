class Solution {
    private static void dfs(int src,ArrayList<ArrayList<Integer>>adj,int isvis[]){
        isvis[src]=1;
        for(int x : adj.get(src)){
             if(isvis[x]==0){
                dfs(x,adj,isvis);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        int cnt=0;
      int isvisited[]=new int[n];
        for(int i=0;i<n;i++){
            if(isvisited[i]==0){
                cnt++;
                dfs(i,adj,isvisited);
            }
        }
        return cnt;

    }
}