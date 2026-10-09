
class Solution {

    public void dfs(int[][] image, int r, int c,
                    int originalColor, int newColor) {

        int rows = image.length;
        int cols = image[0].length;

        // 1. Boundary check
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        // 2. Check original color
        if (image[r][c] != originalColor) {
            return;
        }

        // 3. Change the color
        image[r][c] = newColor;

        // 4. Visit four directions
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r, c - 1, originalColor, newColor); // Left
        dfs(image, r, c + 1, originalColor, newColor); // Right
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If both colors are same
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }
}
