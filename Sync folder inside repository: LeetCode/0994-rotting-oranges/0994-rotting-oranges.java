class Solution {
   public int orangesRotting(int[][] grid) {
       Queue<int[]> q = new LinkedList<>();
       int fresh = 0, time = 0;
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == 2)
                   q.add(new int[]{i, j});
               if (grid[i][j] == 1)
                   fresh++;
           }
       }
       int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

       while (!q.isEmpty() && fresh > 0) {
           int size = q.size();
           time++;

           for (int s = 0; s < size; s++) {
               int[] curr = q.poll();

               for (int[] d : dir) {
                   int ni = curr[0] + d[0];
                   int nj = curr[1] + d[1];

                   if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] == 1) {
                       grid[ni][nj] = 2;
                       fresh--;
                       q.add(new int[]{ni, nj});
                   }
               }
           }
       }

       return fresh == 0 ? time : -1;
   }
}
