class Solution {
    public boolean canFinish(int V, int[][] prerequisites) { 
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
                for (int i = 0; i < V; i++) {
                    adj.add(new ArrayList<>());
                }
                for (int i = 0; i < prerequisites.length; i++) {
                    int u = prerequisites[i][0];
                    int v =prerequisites[i][1];
                    adj.get(u).add(v);
                }
                int[] indegree = new int[V];

                for (int i = 0; i < V; i++) {
                    for (int x : adj.get(i)) {
                        indegree[x]++;
                    }
                }

                Queue<Integer> q = new LinkedList<>();
                for (int i = 0; i < V; i++) {
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }

               int cnt=0;

                // BFS
                while (!q.isEmpty()) {
                    int node = q.poll();
                   cnt++;

                    for (int x : adj.get(node)) {
                        indegree[x]--;

                        if (indegree[x] == 0) {
                            q.add(x);
                        }
                    }
                }

                if(cnt==V)return true;
         return false;  
    }
}