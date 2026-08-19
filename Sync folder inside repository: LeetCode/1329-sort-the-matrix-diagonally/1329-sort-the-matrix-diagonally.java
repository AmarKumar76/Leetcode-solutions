class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // Starting points: first row
        for (int col = 0; col < n; col++) {
            sortDiagonal(mat, 0, col, m, n);
        }

        // Starting points: first column
        for (int row = 1; row < m; row++) {
            sortDiagonal(mat, row, 0, m, n);
        }

        return mat;
    }

    static void sortDiagonal(int[][] mat, int r, int c, int m, int n) {

        ArrayList<Integer> list = new ArrayList<>();

        int i = r;
        int j = c;

        // Diagonal ke elements collect karo
        while (i < m && j < n) {
            list.add(mat[i][j]);
            i++;
            j++;
        }

        // Sort
        Collections.sort(list);

        // Sorted values wapas daalo
        i = r;
        j = c;

        int k = 0;

        while (i < m && j < n) {
            mat[i][j] = list.get(k++);
            i++;
            j++;
        }
    }
}