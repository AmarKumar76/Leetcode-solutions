class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
       }
       for(int i=0;i<prerequisites.length;i++){
         int u = prerequisites[i][0];
         int v = prerequisites[i][1];
         adj.get(u).add(v);
       }
       int indeg[]=new int[numCourses];
       for(int i=0;i<numCourses;i++){
           for(int x : adj.get(i))
            indeg[x]++;
       }
       Queue<Integer>que = new LinkedList<>();
       for(int i=0;i<numCourses;i++){
           if(indeg[i]==0){
            que.offer(i);
           }
       }
       int ans[]=new int[numCourses];
       ArrayList<Integer>list = new ArrayList<>();
       while(!que.isEmpty()){
           int curr = que.peek();
           que.remove();
           list.add(curr);
            for(int x : adj.get(curr)){
            indeg[x]--;
                if(indeg[x]==0){
                    que.offer(x);
                }
            }
       }
       if(list.size()!=numCourses){
         return new int[]{};
       }
       Collections.reverse(list);
       for(int i=0;i<list.size();i++){
        ans[i]=list.get(i);
       }
       return ans;
    }
}