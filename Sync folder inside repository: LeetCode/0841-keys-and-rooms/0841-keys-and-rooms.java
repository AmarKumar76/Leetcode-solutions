class Solution {
    public static void dfs(int src,List<List<Integer>>rooms,int vis[]){
        vis[src]=1;
        for(int x : rooms.get(src)){
            if(vis[x]==0){
                vis[x]=1;
                dfs(x,rooms,vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int vis[] = new int[rooms.size()];
        dfs(0,rooms,vis);
        for(int i=0;i<rooms.size();i++){
            if(vis[i]==0){
                return false;
            }
        }
        return true;
    }
}