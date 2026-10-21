class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int []fl : flights){
            ls.get(fl[0]).add(new int[]{fl[1],fl[2]});    
        }
        Queue<int[]>qu = new LinkedList<>();
        int[]d  = new int[n];
        Arrays.fill(d,(int)1e9);

        qu.offer(new int[]{0,src,0});
        d[src]=0;

        while(!qu.isEmpty()){
            int[]p = qu.poll();
            int st = p[0];
            int nod = p[1];
            int dis = p[2];

            if(st>k){
                continue;
            }
            for(int[] j : ls.get(nod)){
                int new_nod = j[0];
                int new_d = j[1];

                int upt_dis = dis + new_d;

            if(upt_dis < d[new_nod]){
                d[new_nod]= upt_dis;

                qu.offer(new int[]{
                    st+1,
                    new_nod,upt_dis
                });
            }
            }
        }
        return d[dst]==(int)1e9?-1:d[dst];
    }
}