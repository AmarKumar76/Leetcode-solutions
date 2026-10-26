class Solution {
    public int countIslands(int[][] grid, int k) {
         int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    long islandSum = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.offer(new int[]{i, j});
                    islandSum += grid[i][j];
                    grid[i][j] = 0; 
                    
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];
                        
                        for (int[] dir : dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] != 0) {
                                islandSum += grid[nr][nc];
                                grid[nr][nc] = 0; 
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    if ((islandSum % k )== 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}