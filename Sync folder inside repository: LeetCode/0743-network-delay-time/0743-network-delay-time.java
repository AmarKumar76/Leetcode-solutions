class Pair {
    int dist;
    int node;
    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new Pair(w, v));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.dist, b.dist)
        );

        int[] mintime = new int[n + 1];
        Arrays.fill(mintime, Integer.MAX_VALUE);

        mintime[k] = 0;
        pq.add(new Pair(0, k));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int dist = curr.dist;
            int nod = curr.node;

            if (dist > mintime[nod]) {
                continue;
            }

            for (Pair edge : adj.get(nod)) {
                int neighbour = edge.node;
                int weight = edge.dist;

                if (mintime[nod] + weight < mintime[neighbour]) {
                    mintime[neighbour] = mintime[nod] + weight;

                    pq.offer(new Pair(mintime[neighbour], neighbour));
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (mintime[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxTime = Math.max(maxTime, mintime[i]);
        }

        return maxTime;
    }
}
