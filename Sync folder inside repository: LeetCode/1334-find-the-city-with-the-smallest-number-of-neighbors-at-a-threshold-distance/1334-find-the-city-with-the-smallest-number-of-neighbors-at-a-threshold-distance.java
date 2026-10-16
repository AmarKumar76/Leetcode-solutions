class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int result = -1;
        int minCount = Integer.MAX_VALUE;

        for (int src = 0; src < n; src++) {

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

            dist[src] = 0;
            pq.offer(new int[]{0, src});

            while (!pq.isEmpty()) {

                int[] curr = pq.poll();
                int d = curr[0];
                int node = curr[1];

                if (d > dist[node]) {
                    continue;
                }

                for (int[] neighbor : adj.get(node)) {

                    int nextNode = neighbor[0];
                    int weight = neighbor[1];

                    if (dist[nextNode] > d + weight) {
                        dist[nextNode] = d + weight;
                        pq.offer(new int[]{dist[nextNode], nextNode});
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (i != src && dist[i] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCount) {
                minCount = count;
                result = src;
            }
        }

        return result;
    }
}